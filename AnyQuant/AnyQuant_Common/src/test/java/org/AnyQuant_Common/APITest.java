package org.AnyQuant_Common;

import java.util.List;

import dataservice.APIDataFactory;
import dataservice.APIInterface;
import dataservice.APIInterfaceImpl;
import enumeration.MyDate;
import junit.framework.TestCase;
import po.BenchMarkPO;
import po.StockPO;
import util.MyTime;


public class APITest extends TestCase {
         public static void main(String a[]){
        	    //getAllstocksMessageByAPI();
        	// getBenchMes();
        	   // getStockCode();
        getAllMesByCache();
        //	 System.out.println(MyTime.getToDay().DateToString()+" "+MyTime.getToDay().TimeToString());
//            System.out.println(MyTime.getAnotherDay(-1).AllToString());
//            System.out.println(MyTime.getAnotherDay(0).AllToString());
         }
         public  static void getAllstocksMessageByAPI(){
        	 APIInterface api =  APIInterfaceImpl.getAPIInterfaceImpl();
        	 MyDate start = new MyDate(2016, 2, 29);
        	 MyDate end = new MyDate(2016, 3, 7);
        	List<StockPO>  stocks =  api.getStockMes("sh600979",start,end);
        //	StockPO stock =   api.getStockMes("sh600126");

        	for(StockPO stock : stocks){
             
        		System.out.print("name: "+stock.getName()+"  " );
             	System.out.print("code: "+stock.getCode()+"  ");
             	System.out.print("open: "+stock.getOpen()+"  ");
               	System.out.print("close: "+stock.getClose()+"  ");
               	System.out.print("preClose:"+stock.getPreClose()+"  ");
               	System.out.print("high: "+stock.getHigh()+"  ");
               	System.out.print("low: "+stock.getLow()+"  ");
               	System.out.print("pe: "+stock.getPe_ttm()+"  ");
                System.out.print("pb: "+stock.getPb()+"  ");
                System.out.print("adj_price: "+stock.getAdj_price()+"  ");
               	System.out.print("changeRate: "+stock.getChangeRate()+"  ");
             	System.out.print("amp: "+stock.getAmplitude()+"  ");	
             	System.out.print("turnover: "+stock.getTurnover()+"  ");
             	System.out.print("date: "+stock.getDate()+'\n');
        	}
         }

         public static void getBenchMes(){
        	 
        	 APIInterface api =  APIInterfaceImpl.getAPIInterfaceImpl();
        	// BenchMarkPO stock = api.getBenchMes("hs300");
        	 MyDate start = new MyDate(2016, 3, 1);
        	 MyDate end = new MyDate(2016, 3, 10);
        	 List<BenchMarkPO> benchs = api.getBenchMes("hs300", start, end);
        	 for(BenchMarkPO  stock: benchs){
        		            System.out.print("date: "+stock.getDate()+" ");
        		        	System.out.print("code: "+stock.getCode()+" ");
        		        	System.out.print("open: "+stock.getOpen()+" ");
        		          	System.out.print("close: "+stock.getClose()+" ");
        		          	System.out.print("high: "+stock.getHigh()+" ");
        		          	System.out.print("low: "+stock.getLow()+" ");
        		          	System.out.print("adj_price: "+stock.getAdj_price()+'\n');
        		        	
        		 }
        		        
         }
         
         public static void getStockCode(){
        	 APIInterface api = new APIDataFactory().getAPIDataService();
        	 List<String > codes = api.getAllStocks();
        	 if(codes!=null){
        	   for(String temp : codes ){
        		   System.out.println(temp);
        	   }
        	 }else{
        		 System.out.println("null");
        	 }
         }
         
         
         
         public static void getAllMesByCache(){
        	 APIInterface api = new APIDataFactory().getAPIDataService();
        	 MyDate start = new MyDate(2016,3,8);
        	 MyDate end = new MyDate(2016, 3, 10);
        	 List<StockPO > stocks = api.getStockMes("sh600007",start,end);
        	 
        	 for(StockPO stock : stocks){
           	    System.out.print("name: "+stock.getName()+"  " );
             	System.out.print("code: "+stock.getCode()+"  ");
             	System.out.print("open: "+stock.getOpen()+"  ");
               	System.out.print("close: "+stock.getClose()+"  ");
               	System.out.print("preClose:"+stock.getPreClose()+"  ");
               	System.out.print("high: "+stock.getHigh()+"  ");
               	System.out.print("low: "+stock.getLow()+"  ");
               	System.out.print("pe: "+stock.getPe_ttm()+"  ");
                System.out.print("pb: "+stock.getPb()+"  ");
                System.out.print("adj_price: "+stock.getAdj_price()+"  ");
               	System.out.print("changeRate: "+stock.getChangeRate()+"  ");
             	System.out.print("amp: "+stock.getAmplitude()+"  ");	
             	System.out.print("turnover: "+stock.getTurnover()+"  ");
             	System.out.print("date: "+stock.getDate()+'\n');
        	 }
         }
}
