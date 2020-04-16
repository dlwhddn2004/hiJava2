package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ComboGugudanController implements Initializable{
	//F m x l 화면 1개당 컨트롤러 1개가 필수다.!!
	// 신빌더에 껍대기 작성후 자바 이클립스에 오버해드 해준다 그다음 컨트롤러할 클래스 만든 다음 
	//FXML파일에 콘트롤 경로 만들어주고 Initializable 임플리먼트 후  컨트롤 경로에 FXML파일 변수명 컨트롤+1해준다. 그다음 메소드에서 사용
	
	@FXML
	private ComboBox<Integer> cmbDan;
	@FXML 
	private Button btnDan;
	@FXML 
	private TextArea textResult;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//assert로 cmbDan != null인걸 확신 , but Null일 경우 에러 표시
		assert cmbDan != null : "fx:id\"cmbDan\" was not injected: "
							+ "check your FXML file 'CombuGUgudan.fxml'";
		
		assert btnDan != null : "fx:id\"btnDan\" was not injected: "
				+ "check your FXML file 'CombuGUgudan.fxml'";


		assert textResult != null : "fx:id\"textResult\" was not injected: "
				+ "check your FXML file 'CombuGUgudan.fxml'";

		
		ObservableList<Integer> list = FXCollections.observableArrayList(
				 1,2,3,4,5,6,7,8,9 );
		cmbDan.setItems(list); 
		cmbDan.setValue(1);
				  
	/*	 btnDan.setOnAction(e -> {
		//int dan = cmbDan.getSelectionModel().getSelectedItem(); 
		 int dan = cmbDan.getValue();
		 
		 textResult.setText(dan + "단\n\n"); 
		 for(int i=1; i<=9; i++){
			 	int r = dan * i; 
			 	textResult.appendText(dan + " * " + i + " = " + r + "\n"); 
			}
		});*/

	}

	@FXML 
	public void btnDanClicked(ActionEvent event) {
		//int dan = cmbDan.getSelectionModel().getSelectedItem(); 
		int dan = cmbDan.getValue();
		textResult.setText(dan + "단\n\n"); 
		 
	    for(int i=1; i<=9; i++){
			 	int r = dan * i; 
			 	textResult.appendText(dan + " * " + i + " = " + r + "\n"); 
		}
	}
	
	
}
