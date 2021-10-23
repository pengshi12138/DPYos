package com.niuniukeaiyouhaochi.os.UI;

/**
 * @description:
 * @projectName:DPYos
 * @see:com.niuniukeaiyouhaochi.os.UI
 * @author: pc
 * @createTime:2021/10/23 10:39
 * @version:1.0
 */
public class JavaApp {
	public void login(){
		System.out.println("login...");
		ProcessMain processMain = new ProcessMain();
		try {
			processMain.loginProcessController();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LoginMain.LoginStage.close();
	}
}
