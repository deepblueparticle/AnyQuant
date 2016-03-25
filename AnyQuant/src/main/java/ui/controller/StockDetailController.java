package ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import vo.Stock;
import vo.StockVO;

public class StockDetailController {

	@FXML
	Label nameLabel;
	@FXML
	Label codeLabel;
	@FXML
	Label open;
	@FXML
	Label close;
	@FXML
	Label high;
	@FXML
	Label low;
	@FXML
	Label turnover;
	@FXML
	Label volume;
	@FXML
	Label pe;
	@FXML
	Label pb;
	
	
	
	private static StockDetailController instance;

	public StockDetailController() {
		System.err.println("init constructor");
		if (instance == null) {
			instance = this;
		}
	}

	public static StockDetailController getStockDetailController() {
		System.err.println("get instance");
		if (instance == null) {
			System.err.println("create");
			instance = new StockDetailController();
		}
		return instance;
	}
	@FXML
	private void initialize(){
		//TODO
		System.out.println("init complete");
		if(nameLabel==null){
			System.out.println("name null in init");
			return;
			}else{
				System.out.println("not null in init");
			}
		nameLabel.setText("hello");
	}

	public static StockDetailController getCurrent(){
		return instance;
	}
	public void setData(Stock stock){
		if(nameLabel==null){
			System.out.println("name null in set method");
			return;
			}else{
				System.out.println("not null in set method");
				}
		System.out.println("changed!!");
		System.out.println(stock.name.get());
		nameLabel.setText(stock.name.get());
	}
}
