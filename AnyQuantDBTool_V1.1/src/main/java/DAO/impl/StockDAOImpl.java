package DAO.impl;

import DAO.BaseDAO;
import DAO.StockDAO;
import entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Qiang
 * @date 16/5/6
 */
@Repository
public class StockDAOImpl implements StockDAO {

    @Autowired
    BaseDAO baseDAO;
    private static String tableName = StockEntity.class.getName();

    @Override
    public List<String> getAllStockCodes() {
        String hql = "select code from "+ tableName;
        return (List<String>) baseDAO.getAllList(hql);
    }

    @Override
    public List<StockEntity> getAllStocks()
    {
        return (List<StockEntity>) baseDAO.getAllList(StockEntity.class);
    }

    @Override
    public StockEntity getStockEntity(String code)
    {
        return (StockEntity) baseDAO.load(StockEntity.class,code);
    }
}