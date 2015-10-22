package com.aeb.elan9.gui.javaclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tbee.javafx.scene.layout.fxml.*;

public class HelloController {
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private Label messageLabel;

	
	public void sayHello() {

		String firstName = firstNameField.getText();
		String lastName = lastNameField.getText();

		StringBuilder builder = new StringBuilder();

		if (!StringUtils.isEmpty(firstName)) {
			builder.append(firstName);
		}

		if (!StringUtils.isEmpty(lastName)) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(lastName);
		}

		if (builder.length() > 0) {
			String name = builder.toString();
			log.debug("Saying hello to " + name);
			messageLabel.setText("Hello " + name);
		} else {
			log.debug("Neither first name nor last name was set, saying hello to anonymous person");
			messageLabel.setText("Hello mysterious person");
		}
	}

}
