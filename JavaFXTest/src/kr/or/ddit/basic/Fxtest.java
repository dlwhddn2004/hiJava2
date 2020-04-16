package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kr.or.ddit.basic.T11_ComboBoxTest2.MyFriend;

public class Fxtest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox box = new VBox();

		box.setPrefWidth(650);
		box.setPrefHeight(300);
		box.setAlignment(Pos.CENTER_LEFT);
		box.setPadding(new Insets(10, 10, 10, 10));
		box.setSpacing(10);

		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();
		HBox hbox4 = new HBox();
		HBox hbox5 = new HBox();
		//
		Label label = new Label();
		label.setText("이 름 :");

		TextField tf = new TextField();
		tf.setPrefWidth(200);

		//
		Label label2 = new Label("성 별 : ");
		RadioButton radio = new RadioButton("남");
		RadioButton radio2 = new RadioButton("여");
		
		ToggleGroup a = new ToggleGroup();
		
		radio.setToggleGroup(a);
		radio2.setToggleGroup(a);
		
		Label label3 = new Label("취미");
		
		
	/*	ObservableList<CheckBox> list = FXCollections.observableArrayList(new CheckBox("여행"),
				new CheckBox("등산"),
				new CheckBox("바둑"),
				new CheckBox("장기"),
				new CheckBox("게임"),
				new CheckBox("테니스"),
				new CheckBox("베드민턴")); */
		
		
		
	/*	CheckBox[] test = new CheckBox[] {new CheckBox("여행"),
				new CheckBox("여행"),
				new CheckBox("등산"),
				new CheckBox("바둑"),
				new CheckBox("장기"),
				new CheckBox("게임"),
				new CheckBox("테니스"),
				new CheckBox("베드민턴")}; */
		
		//combo.setItems(list);
				
		
		
		CheckBox cb1 = new CheckBox("여행");
		CheckBox cb2 = new CheckBox("등산");
		CheckBox cb3 = new CheckBox("독서");
		CheckBox cb4 = new CheckBox("바둑");
		CheckBox cb5 = new CheckBox("장기");
		CheckBox cb6 = new CheckBox("게임");
		CheckBox cb7 = new CheckBox("테니스");
		CheckBox cb8 = new CheckBox("배드민턴");
		
		
		//
		Button button = new Button("보기");

		//
		TextArea ta = new TextArea();
		ta.prefWidth(300);
		ta.prefHeight(300);
		/////// 이벤트 처리

		
		  button.setOnAction(new EventHandler<ActionEvent>() {
		  
		  @Override public void handle(ActionEvent arg0) {
			  List<CheckBox> list = new ArrayList<CheckBox>(); 
			  list.add(cb1); list.add(cb2); list.add(cb3);
			  list.add(cb4); list.add(cb5);	list.add(cb6);
			  list.add(cb7); list.add(cb8);
			  
			  for(int i=0; i<=list.size(); i++) {
				  if(list.get(i).isSelected()) {
					ta.appendText(list.get(i).getText());
				  }
			  }

		  ta.appendText((tf.getText()+","+((RadioButton)a.getSelectedToggle()).getText()));
		  
		  } });
		 

		hbox1.getChildren().addAll(label, tf);
		hbox2.getChildren().addAll(label2, radio, radio2);
		hbox3.getChildren().addAll(label3, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8);
		hbox4.getChildren().addAll(button);
		hbox5.getChildren().add(ta);

		box.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);
		Scene scene = new Scene(box);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
