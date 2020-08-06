package br.com.rodrigoluisfaria.frame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class MessageFrame extends JFrame {

	private static final long serialVersionUID = 7070006407837557456L;
	
	private JLabel userLabel;
	private JButton newMessageButton;
	private JTextField newMessageTextField;
	private JTextArea messageTextArea;
	
	public MessageFrame() {
		setSize(450, 450);
		setResizable(false);
		setTitle("Me ajuda?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		initialize();
	}
	
	private void initialize() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		userLabel = new JLabel();
		userLabel.setText("Olá XXX!");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		//gbc.insets = new Insets(10, -32, 10, 0);
		gbc.insets = new Insets(10, 16, 10, 0);
		getContentPane().add(userLabel, gbc);
		
		JLabel messageLabel = new JLabel();
		messageLabel.setText("Mensagens:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, -12, 0, 0);
		getContentPane().add(messageLabel, gbc);
		
		messageTextArea = new JTextArea();
		messageTextArea.setEditable(false);
		JScrollPane messageTextAreaScroll = new JScrollPane(messageTextArea);
		messageTextAreaScroll.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		messageTextAreaScroll.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		messageTextAreaScroll.setPreferredSize(new Dimension(400, 250));
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(-100, 0, 0, 0);
		getContentPane().add(messageTextAreaScroll, gbc);
		
		JLabel newMessageLabel = new JLabel();
		newMessageLabel.setText("Nova mensagem:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(-190, 17, 0, 0);
		getContentPane().add(newMessageLabel, gbc);
		
		newMessageTextField = new JTextField();
		newMessageTextField.setColumns(28);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(-150, 17, 0, 0);
		getContentPane().add(newMessageTextField, gbc);
		
		newMessageButton = new JButton();
		newMessageButton.setText("Enviar");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(-150, 17, 0, 18);
		gbc.anchor = GridBagConstraints.LINE_END;
		getContentPane().add(newMessageButton, gbc);
	}

	public JLabel getUserLabel() {
		return userLabel;
	}

	public JButton getNewMessageButton() {
		return newMessageButton;
	}
	
	public JTextField getNewMessageTextField() {
		return newMessageTextField;
	}

	public JTextArea getMessageTextArea() {
		return messageTextArea;
	}
	
}
