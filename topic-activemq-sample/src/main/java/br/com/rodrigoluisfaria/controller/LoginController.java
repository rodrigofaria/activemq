package br.com.rodrigoluisfaria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.rodrigoluisfaria.frame.LoginFrame;

public class LoginController {

	private LoginFrame loginFrame;
	private MessageController messageController;
	
	public LoginController() {
		loginFrame = new LoginFrame();
		messageController = new MessageController();
	}
	
	public void initialize() {
		loginFrame.setVisible(true);
		loginFrame.getEnterButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidForm()) {
					openMessageFrame();
				}
			}
		});
	}

	private void openMessageFrame() {
		loginFrame.setVisible(false);
		messageController.initialize(loginFrame.getNameTextField().getText());
	}
	
	private boolean isValidForm() {
		return !loginFrame.getNameTextField().getText().trim().isEmpty();
	}
	
}
