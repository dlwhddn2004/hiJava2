package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T04_FxmLayout extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// fxml파일을 읽어와 현재 Stage에 적용하기
		// 방법1
	/*	Parent root = FXMLLoader.load( //Parent 대신 HBox해줘도 상관없지만 Object 느낌으로 Parent써줌
									   //(Object -> node ->Parent)
				getClass().getResource("FxmlLayout.fxml"));
		
		//자동으로 FXM이 로드 해주쥼 */
		
		//방법2 FXMLLoader 객체 만들어주고 load 하기 (정교한 작업 가능)
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("FxmlLayout.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Fxml문서를 이용한 레이아웃 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
