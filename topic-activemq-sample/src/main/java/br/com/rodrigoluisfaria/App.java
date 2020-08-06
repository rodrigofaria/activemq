package br.com.rodrigoluisfaria;

import javax.swing.JOptionPane;

import br.com.rodrigoluisfaria.controller.LoginController;

public class App {
    
	public static void main( String[] args ) {
        try {
			LoginController controller = new LoginController();
			controller.initialize();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(), 
					"Topic", 
					JOptionPane.ERROR_MESSAGE);
		}
    }
}
