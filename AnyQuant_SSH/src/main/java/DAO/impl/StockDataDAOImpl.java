package DAO.impl;

import DAO.BaseDAO;
import DAO.StockDataDAO;
import entity.StockdataEntity;
import entity.StockdataEntityPK;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.MyDate;
import util.DateCalculator;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by 67534 on 2016/5/7.
 */
@Repository
public class StockDataDAOImpl implements StockDataDAO {

    @Autowired
    BaseDAO baseDAO;
    private static String tableName = StockdataEntity.class.getName();

    @Override
    public StockdataEntity getStockData(String stockCode)
    {
        String hql = "from "+tableName+" where  date = "+
               " (select max(date) from " +tableName+ ") and code = '"+stockCode+"'";

        return (StockdataEntity) baseDAO.load(hql);

    }

    @Override
    public StockdataEntity getStockData(String stockCode, MyDate date)
    {

        StockdataEntityPK stockDataKey = getStockKey(stockCode,date);
        StockdataEntity entity = (StockdataEntity) baseDAO.load(StockdataEntity.class,stockDataKey);
        return entity;
    }

    @Override
    public List<StockdataEntity> getStockData(String stockCode, MyDate start, MyDate end)
    {
        String hql = "from"+tableName+
                "where date between "+start.DateToString()+" and "+end.DateToString();

        return (List<StockdataEntity>) baseDAO.getAllList(hql);
    }

    @Override
    public List<StockdataEntity> getAllStockData() {
        return null;
    }



    private StockdataEntityPK getStockKey(String stockCode, MyDate date){
        Date sqlDate = DateCalculator.MyDateToSQLDate(date);
        StockdataEntityPK stockDataKey = new StockdataEntityPK();
        stockDataKey.setCode(stockCode);
        stockDataKey.setDate(sqlDate);
        return stockDataKey;
    }
}
