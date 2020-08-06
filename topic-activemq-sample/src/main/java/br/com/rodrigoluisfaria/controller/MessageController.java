package br.com.rodrigoluisfaria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import br.com.rodrigoluisfaria.frame.MessageFrame;
import br.com.rodrigoluisfaria.jms.TopicMessage;

public class MessageController {

	private MessageFrame messageFrame;
	private TopicMessage topicMessage;
	private String userName = null;
	
	public MessageController() {
		messageFrame = new MessageFrame();
		startTopic();
	}
	
	public void startTopic() {
		try {
			topicMessage = new TopicMessage();
		} catch (NamingException | JMSException e) {
			throw new RuntimeException("Erro ao conectar com o servidor de messageria.");
		}
		
		topicMessage.startListener(this);
	}
	
	public void initialize(String userName) {
		this.userName = userName;
		messageFrame.setVisible(true);
		messageFrame.getUserLabel().setText("Olá " + userName + "!");
		messageFrame.getNewMessageButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendNewMessage();
				messageFrame.getNewMessageTextField().setText(null);
				messageFrame.getNewMessageTextField().requestFocus();
			}
		});
	}
	
	public void sendNewMessage() {
		try {
			String message = this.userName + ": " + messageFrame.getNewMessageTextField().getText();
			topicMessage.send(message);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(), 
					"Topic", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateMessage(String message) {
		messageFrame.getMessageTextArea().append(message);
		messageFrame.getMessageTextArea().append("\n");
	}
}
