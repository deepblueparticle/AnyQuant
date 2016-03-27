package ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.GraphicsUtils;


/**
 * Controller of the right pane
 *
 * @author Qiang
 * @date Mar 22, 2016
 */
public class RightPaneController{
	private static Stage stage;
	private static BorderPane pane;
	private BorderPane stockListPane;
	private Pane benchMarkPane;
	private Pane stockDetailPane;
	private AnchorPane candleStickPane;
	@FXML
	private ImageView min;
	@FXML
	private ImageView close;
	
	private static RightPaneController instance;

	public RightPaneController() {
		if (instance == null) {
			instance = this;
		}
		initialize();
	}

	public static RightPaneController getRightPaneController() {
		if (instance == null) {
			instance = new RightPaneController();
		}
		return instance;
	}
	@FXML
	public void initialize() {
		stockListPane = (BorderPane) GraphicsUtils.getParent("StockList");
		 benchMarkPane = (Pane) GraphicsUtils.getParent("BenchMarkPane");
		 candleStickPane = (AnchorPane) GraphicsUtils.getParent("CandleStickPane");

	}

	void showStockListPane() {
		System.out.println("show stockList!!!");
        pane.getChildren().clear();
		pane.setCenter(stockListPane);
	}

	void showBenchMarkListPane() {
		 pane.getChildren().clear();
		pane.setCenter(benchMarkPane);
	}

	void showCandleStickPane() {
	     pane.getChildren().clear();
		pane.setCenter(candleStickPane);
	}

	private void showDetailPane() {

	}

	static void  setPane(Pane pane){
		if(RightPaneController.pane == null){
		RightPaneController.pane = (BorderPane) pane;
		}

		

	}
	@FXML
	private void handleMin(MouseEvent event){
		System.out.println("----handing");
		if(event.getEventType() == MouseEvent.MOUSE_ENTERED){
			min.getStyleClass().clear();
			min.getStyleClass().add("minEnteredImg");
			System.err.println("mouse enter!");
		}else if(event.getEventType() == MouseEvent.MOUSE_EXITED){
			min.getStyleClass().clear();
			min.getStyleClass().add("minNormalImg");
		}
		
		if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
			stage.setIconified(true);
		}
		
	}
	@FXML
	private void handleClose(MouseEvent event) {
		if(event.getEventType() == MouseEvent.MOUSE_ENTERED){
			close.getStyleClass().clear();
			close.getStyleClass().add("closeEnteredImg");
		}else if(event.getEventType() == MouseEvent.MOUSE_EXITED){
			close.getStyleClass().clear();
			close.getStyleClass().add("closeNImg");
		}
		
		if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
			stage.close();
			System.exit(0);
		}
		
	}
	
	
	public static void setStage(Stage stage) {
				RightPaneController.stage = stage;
	}

	}
