package com.niuniukeaiyouhaochi.os.UI;

/**
 * @description: 页面跳转类，实现三个面板之间的跳转
 * @projectName:DPYos
 * @see:com.niuniukeaiyouhaochi.os.UI
 * @author: pc
 * @createTime:2021/10/23 10:39
 * @version:1.0
 */
public class JavaApp {
	ProcessMain processMain;

	public void login() throws Exception {
		System.out.println("login Choice...");
	}

	/**
	 * description 登录Process控制面板
	 * param void
	 * return void
	 * author pc
	 * createTime 2021/10/27
	 **/
	public void loginProcess() throws Exception {
		System.out.println("login Process...");
		if (processMain == null) {
			processMain = new ProcessMain();
			processMain.loginProcessController();
		} else {
			processMain.LoginStage.show();
		}

		LoginMain.LoginStage.hide();
	}

	public void loginFile() throws Exception {
		System.out.println("login File...");

		LoginMain.LoginStage.hide();
	}
}
