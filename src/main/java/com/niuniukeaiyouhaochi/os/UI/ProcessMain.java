package com.niuniukeaiyouhaochi.os.UI;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebEngine;

import javafx.stage.Stage;


public class ProcessMain extends Application {
    /** 用于与Javascript引擎通信。 */
//    private JSObject javascriptConnector;

    /** 用于从Javascript引擎进行通信。 */
    private int javaConnector;

    private WebEngine engine = null;


    Stage stage=new Stage();
    public static Parent page;
    public static Scene scene;
    public static Stage LoginStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginStage = primaryStage;
        page = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        scene = new Scene(page);
        scene.getStylesheets().add(getClass().getResource("/css/sample.css").toExternalForm());
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void loginProcessController() throws Exception {
        start(stage);
    }
}
