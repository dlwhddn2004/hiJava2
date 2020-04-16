package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class T02_StageSceneTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(); // 컨트롤들을 세로로 배치해 주는 컨테이너

		root.setPrefWidth(650); // VBox의 너비
		root.setPrefHeight(150); // VBox의 높이
		root.setAlignment(Pos.CENTER); // 컨트롤들을 가운데 정렬 Alignment배치
		root.setSpacing(20); // 컨트롤과 컨트롤 사이의 간격

		Label label = new Label(); // Label 객체 생성
		label.setText("안녕하십니까. JavaFX입니다.");
		label.setFont(new Font(50)); // Font 객체를 이용하여 글자크기설정

		Button button = new Button();
		button.setText("확인");

		// 버튼에 대한 클릭 이벤트 처리
		// 방법1 => 람다식을 사용하지 않은 경우 // EventHandler 이벤트에 대해 처리/ EventLisnner 이벤트를 기다리다가
		// 처리?
		// 버튼을 눌렀을떄 set 액션을 취하자 Handler는 인터페이스 그걸 구현하는 추상메서드 handle // Handler나 Lisnner은
		// 추상메서드가 1개인 인터페이스다
		
		/*button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// 처리할 내용을 기술하는 영역
				Platform.exit(); // 프로그램 종료 앞에 대문자는 Static
			}
		}); */

		// 방법 2 -> 람다식
		button.setOnAction(
				(/* ActionEvent */ e) -> {
					Platform.exit();
				});


		// VBox에 컨트롤들 추가하기  ObservableList는 일반 list와 유사하며 추가하거나 삭제하면 화면에서 삭제 추가됨
		//getChildren은 ObservableList에 속함
		//root.getChildren().add(label);
		//root.getChildren().add(button);
		root.getChildren().addAll(label, button);
		
		// VBox를 루트 컨테이너로 하는 Scene객체 생성
		Scene scene = new Scene(root);

		primaryStage.setTitle("Stage와 Scene연습"); // 창제목
		primaryStage.setScene(scene); // Stage에 Scene 설정
		primaryStage.show(); // 창(Stage) 보이기
	}

	public static void main(String[] args) {
		launch(args);
	}
}
