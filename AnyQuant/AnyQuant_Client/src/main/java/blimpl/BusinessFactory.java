package blimpl;

import blservice.BenchMarkBLService;
import blservice.StockBLService;

/**
 * 逻辑层工厂
 * @author czq
 * @date 2016年3月10日
 */
public class BusinessFactory {
	
	public static StockBLService getStockBLService(){
		return StockBLImpl.getAPIBLService();
	}
	
	public static BenchMarkBLService getBenchMarkBLService(){
		return null;
	}
	
}