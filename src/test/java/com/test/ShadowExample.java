package com.test;

/**
 * @description:
 * @projectName:DPYos
 * @see:com.test
 * @author: pc
 * @createTime:2021/10/23 15:42
 * @version:1.0
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ShadowExample extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root = new AnchorPane(new Label("fdsafdsafd"));
		root.setPrefSize(270, 350);
		DropShadow dropshadow = new DropShadow();// 阴影向外
		dropshadow.setRadius(10);// 颜色蔓延的距离
		dropshadow.setOffsetX(0);// 水平方向，0则向左右两侧，正则向右，负则向左
		dropshadow.setOffsetY(0);// 垂直方向，0则向上下两侧，正则向下，负则向上
		dropshadow.setSpread(0.1);// 颜色变淡的程度
		dropshadow.setColor(Color.BLACK);// 设置颜色
		root.setEffect(dropshadow);// 绑定指定窗口控件
		HBox treeRoot = new HBox();// 创建最底层的面板
		treeRoot.setBackground(Background.EMPTY);// 设置背景色为透明
		treeRoot.setAlignment(Pos.CENTER);// 设置对齐方式为居中
		treeRoot.setPadding(new Insets(dropshadow.getRadius()));// 设置要显示的阴影宽度为根控件与底层容器的四边距离
		treeRoot.getChildren().add(root);// 添加根控件到底层容器中
		Scene scene = new Scene(treeRoot, 270, 350, Color.TRANSPARENT);
		primaryStage.initStyle(StageStyle.TRANSPARENT);// 设定窗口无边框
		primaryStage.setScene(scene);
		primaryStage.setTitle("Shadow Effect Example");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
