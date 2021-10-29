package com.niuniukeaiyouhaochi.os.util;

import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

public class GUI {
    //    弹窗警告
    public static void contentOutGUI(String context){
        //                    显示文件内容
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText(context);
        Stage dialogStage = new Stage();
        Scene dialogScene = new Scene(dialogPane);
        dialogStage.setScene(dialogScene);
        dialogStage.show();
    }

}
