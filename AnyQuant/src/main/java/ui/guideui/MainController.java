package ui.guideui;

import org.dom4j.Element;

import ui.blockui.BlockPanel;
import ui.config.CompomentType;
import ui.listui.BenchMarkListPanel;
import ui.listui.StockListPanel;
import ui.stockdetail.DetailMainPanel;
import ui.tool.ButtonState;
import ui.tool.MyPanel;
import ui.tool.MyPictureButton;
import ui.tool.MySideBarButton;
import ui.tool.MySideBarListener;
import ui.tool.PanelController;

/**
 * 主界面跳转控制器
 * 
 * @author czq
 * @date 2016年3月2日
 */
public class MainController extends PanelController {

//	private MySideBarButton BlockButton;
	private MySideBarButton StockListButton;
	private MySideBarButton BenchmarkButton;

	private final static String stockDetailPanelStr = "stockDetailPanel";
	private final static String stockListPanelStr = "stockListPanel";
	private final static String benchmarkPanelStr = "benchmarkPanel";
	private final static String blockPanelStr = "blockPanel";

	private DetailMainPanel stockDetailPanel;
	private BenchMarkListPanel benchMarkListPanel;
	private StockListPanel stockListPanel;
//	private BlockPanel blockPanel;

	public MainController(MyPanel initialPanel, Element root) {
		super(initialPanel, root.element("changepanel"));

		initialBL();
		initButtons(root.element(CompomentType.BUTTONS.name()));
		initPanel(root);
		addButtons();
		addPanels();
		addListeners();
		addToMap();
		this.setAllButtonVisable(true);
		panelManager.show(changePanel, stockListPanelStr);
		changePanel.setVisible(true);

	}

	@Override
	protected void initPanel(Element e) {
		stockDetailPanel = new DetailMainPanel(e.element(stockListPanelStr).element(stockDetailPanelStr),this);
		stockListPanel = new StockListPanel(e.element(stockListPanelStr), this,stockDetailPanel);
		benchMarkListPanel = new BenchMarkListPanel(
				e.element(benchmarkPanelStr));
//		blockPanel=new BlockPanel(e.element(blockPanelStr));
	}

	@Override
	protected void initButtons(Element e) {
		StockListButton = new MySideBarButton(e.element("StockList"));
		BenchmarkButton = new MySideBarButton(e.element("BenchMark"));
		StockListButton.setMyIcon(null);//默认初始界面是股票列表
	}

	@Override
	protected void addButtons() {
		mainPanel.add(BenchmarkButton);
		mainPanel.add(StockListButton);
	}

	@Override
	protected void addPanels() {
		changePanel.add(stockListPanel, stockListPanelStr);
		changePanel.add(benchMarkListPanel, benchmarkPanelStr);
		changePanel.add(stockDetailPanel, stockDetailPanelStr);
//		changePanel.add(blockPanel,blockPanelStr);
	}

	@Override
	protected void addListeners() {
		BenchmarkButton.addMouseListener(new MySideBarListener(BenchmarkButton,
				this, benchmarkPanelStr));
		StockListButton.addMouseListener(new MySideBarListener(StockListButton,
				this, stockListPanelStr));

	}

	@Override
	public void setAllButtonUnClicked() {
		BenchmarkButton.setMyIcon(ButtonState.NORMAL);
//		BlockButton.setMyIcon(ButtonState.NORMAL);
		StockListButton.setMyIcon(ButtonState.NORMAL);

	}

	@Override
	public void setAllButtonVisable(boolean state) {
		BenchmarkButton.setVisible(state);
//		StockDetailButton.setVisible(state);
		StockListButton.setVisible(state);

	}

	@Override
	protected void addToMap() {
		buttonMap.put(benchmarkPanelStr, BenchmarkButton);
//		buttonMap.put(blockPanelStr, BlockButton);
		buttonMap.put(stockListPanelStr, StockListButton);

	}

	@Override
	protected void initialBL() {
		// TODO Auto-generated method stub

	}

}