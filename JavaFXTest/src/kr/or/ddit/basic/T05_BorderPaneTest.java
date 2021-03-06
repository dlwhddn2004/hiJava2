package kr.or.ddit.basic;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 	-top, bottom, left, right, center 설에 컨트롤을 배치하는 컨테이너
 	 각 셀에는 하나의 컨트롤 또는 컨테이너만 배치
 	-top, bottom, left, right에 배치하지 않으면 center에 배치된 컨트롤이
 	 사방으로 자동 확장됨.
  */
public class T05_BorderPaneTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane(); //Layout을 나눠놓을때 미리 배치해놓으면 편하다.
			root.setPrefSize(300, 200);
			
		ToolBar toolBar = new ToolBar(
				new Button("첫번째 버튼"),
				new Button("두번째 버튼")
				);
		
		TextArea textArea = new TextArea();
		
		root.setTop(toolBar); //Top영역에 ToolBar 추가하기
		root.setCenter(textArea); //Center영역에 TextArea 추가하기
		
		BorderPane bottom = new BorderPane();
			bottom.setPadding(new Insets(10));
		
		TextField txtField = new TextField();	
		Button btn1 = new Button("확인");

		bottom.setCenter(txtField); //센터해놓으면 빈공간은 자동으로 layout으로 만들어진다.
		bottom.setRight(btn1);
		
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("BorderPane연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
