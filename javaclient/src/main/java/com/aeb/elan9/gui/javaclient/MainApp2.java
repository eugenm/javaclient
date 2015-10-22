package com.aeb.elan9.gui.javaclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp2 extends Application {

	private static final Logger log = LoggerFactory.getLogger(MainApp2.class);

	public void start(Stage stage) throws Exception {
		String fxmlFile = "/fxml/MessageDialog.fxml";
		log.debug("Loading FXML for main view from: {}", fxmlFile);
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
		log.debug("Showing JFX scene");
		Scene scene = new Scene(rootNode, 400, 200);
		scene.getStylesheets().add("/styles/styles.css");
		
		HTMLEditor editor = (HTMLEditor) scene.lookup("#htmlEditor");
		stage.setTitle("MessageDialog");
		stage.setScene(scene);
		stage.show();

		WebView webview = (WebView) editor.lookup("WebView");
		GridPane.setHgrow(webview, Priority.ALWAYS);
		GridPane.setVgrow(webview, Priority.ALWAYS);
	}

	public static void main(String[] args) throws Exception {
		launch(args);
	}

}
