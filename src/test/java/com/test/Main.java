package com.test;

/**
 * @description:
 * @projectName:DPYos
 * @see:com.test
 * @author: pc
 * @createTime:2021/10/16 14:19
 * @version:1.0
 */
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

	/** 用于与Javascript引擎通信。 */
	private JSObject javascriptConnector;

	/** 用于从Javascript引擎进行通信。 */
	private int javaConnector;

	private WebEngine engine = null;
	private WebView webView = null;


	Thread thread;
	List<Integer> list = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {

		webView = new WebView();
		engine = webView.getEngine();

		engine.setJavaScriptEnabled(true);
		// 获取本地html文件, 注意文件目录，注意与调用路径一致
		engine.load(getClass().getResource("/html/os.html").toExternalForm());

		// 如果是网络上的站点，直接使用 engine.load("http://www.damengsanqian.com/")

		Scene scene = new Scene(webView);
		primaryStage.setScene(scene);
//		primaryStage.setFullScreen(true);
		primaryStage.show();
		addListeningMonitor();


		 thread = new Thread(() -> {
			 Platform.runLater(() -> {
			 	int i = 0;


					 javascriptConnector.call("showResult", i++);
					 try {
						 Thread.sleep(100);
					 } catch (Exception e) {

					 }

			 });

		 });
	}

	/**
	 * description
	 * param
	 * return
	 * author pc
	 * createTime
	 **/
	public void addListeningMonitor () {
		engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {

			if (Worker.State.SUCCEEDED == newValue) {

				// 在web引擎页面中设置一个名为“javaConnector”的接口对象
				JSObject window = (JSObject) engine.executeScript("window");
				window.setMember("javaConnector", javaConnector);

				// 获取Javascript连接器对象。
				try {
					showResult();
				} catch (Exception e) {
					System.out.println("不是该网页");
				}
			}
		});
	}

	void showResult() {

		javascriptConnector = (JSObject) engine.executeScript("getJsConnector()");
		thread.start();
		System.out.println("1");
	}
}
