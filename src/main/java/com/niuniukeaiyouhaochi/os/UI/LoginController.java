package com.niuniukeaiyouhaochi.os.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @description:
 * @projectName:DPYos
 * @see:com.niuniukeaiyouhaochi.os.UI
 * @author: pc
 * @createTime:2021/10/23 14:19
 * @version:1.0
 */
public class LoginController {

	@FXML
	void file(ActionEvent event) {

	}

	@FXML
	void process(ActionEvent event) {
		try {
			JavaApp.loginProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
