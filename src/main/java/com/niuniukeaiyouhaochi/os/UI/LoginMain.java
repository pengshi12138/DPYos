package com.niuniukeaiyouhaochi.os.UI;

/**
 * @description:
 * @projectName:DPYos
 * @see:com.test
 * @author: pc
 * @createTime:2021/10/16 14:19
 * @version:1.0
 */
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.w3c.dom.Node;


public class LoginMain extends Application {

	private Scene scene;
	private WebView webView;
	private WebEngine webEngine;

	/** 用于与Javascript引擎通信。 */
	private JSObject javascriptConnector;

	public JavaApp javaApp = new JavaApp();

	public static Stage LoginStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginStage = primaryStage;
		webView = new WebView();
		webEngine = webView.getEngine();
		webEngine.load(getClass().getResource("/html/index.html").toExternalForm());

		webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
			if (Worker.State.SUCCEEDED == newValue) {
				// 在web引擎页面中设置一个名为“javaConnector”的接口对象
				javascriptConnector = (JSObject) webEngine.executeScript("window");
				javascriptConnector.setMember("JavaApp", javaApp);
				System.out.println(javascriptConnector.getMember("JavaApp"));
			}
		});
		scene = new Scene(webView);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ESCAPE) {
					primaryStage.close();
				}
			}
		});

		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
