package com.aeb.elan9.gui.javaclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aquafx_project.AquaFx;

public class MainApp2 extends Application {

	private ResourceBundle bundle;
	private static final Logger log = LoggerFactory.getLogger(MainApp2.class);

	public void start(Stage stage) throws Exception {
		String fxmlFile = "/com/aeb/elan9/gui/javaclient/view/MessageDialog.fxml";
		log.debug("Loading FXML for main view from: {}", fxmlFile);
		FXMLLoader loader = new FXMLLoader();
		
		bundle = ResourceBundle.getBundle("bundles.lang", new Locale("de","DE"));
		loader.setResources(bundle);
//		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
		log.debug("Showing JFX scene");
		Scene scene = new Scene(rootNode, 800, 600);
		AquaFx.style();
//		scene.getStylesheets().add("/styles/styles.css");
//		String css = MainApp2.class.getResource("/styles/styles.css").toExternalForm();
//		scene.getStylesheets().add(css);
		
		stage.setTitle(bundle.getString("dialog.title"));
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) throws Exception {
		launch(args);
	}

}
