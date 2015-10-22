package com.aeb.elan9.gui.javaclient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDialogController implements Initializable {

	//	public static void main(String[] args) {
	//		// TODO Auto-generated method stub
	//
	//	}

	private static final Logger log = LoggerFactory.getLogger(MessageDialogController.class);

	@FXML
	private TextField fromTextField;
	@FXML
	private TextField toTextField;
	@FXML
	private TextField subjectTextField;
	@FXML
	private Button sendButton;
	@FXML
	private Button cancelButton;
	@FXML
	private HTMLEditor htmlEditor;
	@FXML
	private Label subjectLabel;
	@FXML
	private Label fromLabel;
	@FXML
	private Label toLabel;

	private String content;

	public void exit() {
		System.out.println("closing");
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		log.debug("Initializing " + getClass().getSimpleName());
		WebView webview = (WebView) htmlEditor.lookup("WebView");
		GridPane.setHgrow(webview, Priority.ALWAYS);
		GridPane.setVgrow(webview, Priority.ALWAYS);
	}

	public void openDoc() {
		Scene scene = sendButton.getScene();
		Window window = scene.getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"),new FileChooser.ExtensionFilter("HTML", "*.html"));
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(window);
		if(file != null){
			try {
				content = Files.toString(file, Charsets.UTF_8);
			} catch (IOException e) {
				log.error(e.getMessage());
			}
			htmlEditor.setHtmlText(content);
		}
	}
	
	public void send(){
		System.out.println(htmlEditor.getHtmlText());
	}

}
