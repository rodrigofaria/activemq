package br.com.rodrigoluisfaria.frame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 4719527814747174539L;
	
	private JTextField nameTextField;
	private JButton enterButton;

	public LoginFrame() {
		setSize(250, 125);
		setResizable(false);
		setTitle("Me ajuda?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		initialize();
	}
	
	private void initialize() {
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Nome: ");
		getContentPane().add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(15);
		getContentPane().add(nameTextField);
		
		enterButton = new JButton();
		enterButton.setText("Entrar");
		getContentPane().add(enterButton);
	}

	public JButton getEnterButton() {
		return enterButton;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}
	
}
