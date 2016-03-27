package ui;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
*
* @author Qiang
* @date Mar 22, 2016
*/
public class GraphicsUtils {

	private static final String fxmlPath = "source/fxml/";
	private static FXMLLoader fxmlLoader;

	public static Parent getParent(String fileName){


	try {
		fxmlLoader = new FXMLLoader();

		fxmlLoader.setLocation(new URL("ui/source/fxml" + fileName + ".fxml"));
		return fxmlLoader.load();
	} catch (IOException e) {
		System.out.println("配置文件路径有误*************");
		e.printStackTrace();
	}
		return null;

	}


	public static final String getStyleFromClass(String css){
		return css.substring(css.indexOf('{') + 1, css.indexOf('}'));
	}


}
