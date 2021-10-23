package com.niuniukeaiyouhaochi.os.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * @description:
 * @projectName:DPYos
 * @see:com.niuniukeaiyouhaochi.os.UI
 * @author: pc
 * @createTime:2021/10/23 10:39
 * @version:1.0
 */
public class JavaApp {
	public void login() throws Exception {
		System.out.println("login...");
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		Scene scene = new Scene(root, 600, 400);
		LoginMain.LoginStage.setScene(scene);
	}

	public static void loginProcess() throws Exception {
		System.out.println("login...");
		ProcessMain processMain = new ProcessMain();
		processMain.loginProcessController();
		LoginMain.LoginStage.close();
	}
}
