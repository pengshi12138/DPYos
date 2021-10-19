package com.niuniukeaiyouhaochi.os.UI;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class Main extends Application {
    /** 用于与Javascript引擎通信。 */
    private JSObject javascriptConnector;

    /** 用于从Javascript引擎进行通信。 */
    private int javaConnector;

    private WebEngine engine = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("os");
        WebView webView = new WebView();
        engine = webView.getEngine();
        engine.load(getClass().getResource("/html/index.html").toExternalForm());
        primaryStage.setScene(new Scene(webView));
        primaryStage.getScene().getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        primaryStage.getScene().setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
                System.exit(0);
            }
        });
        primaryStage.setFullScreen(true);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        addListeningMonitor();
    }

    public void addListeningMonitor () {
        engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (Worker.State.SUCCEEDED == newValue) {
                // 在web引擎页面中设置一个名为“javaConnector”的接口对象
                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("javaConnector", javaConnector);

                // 获取Javascript连接器对象。
                try {
                    javascriptConnector = (JSObject) engine.executeScript("getJsConnector()");
                    javascriptConnector.call("showResult", 40);
                } catch (Exception e) {

                }

            }
        });

    }
    public static void main(String[] args) {
        launch(args);
    }
}
