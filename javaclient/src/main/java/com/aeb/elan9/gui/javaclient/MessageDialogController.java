package com.aeb.elan9.gui.javaclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDialogController {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

    private static final Logger log = LoggerFactory.getLogger(MessageDialogController.class);
    

    @FXML private TextField fromTextField;
    @FXML private TextField toTextField;
    @FXML private TextField subjectTextField;
    @FXML private Button sendButton;
    @FXML private Button cancelButton;
    
    public void exit(){
    	System.out.println("closing");
    }
	
	
}
