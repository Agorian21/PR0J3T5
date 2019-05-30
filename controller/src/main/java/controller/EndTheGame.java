package controller;

import javax.swing.JOptionPane;

import contract.view.IPanel;
import view.CreateWindow;

public class EndTheGame {
	private IPanel panel;
	private CreateWindow window;

	
	/**
	 * Constructon of EndTheGame 
	 *
	 * @param panel
	 * @param window
	 */
	public EndTheGame(IPanel panel, CreateWindow window){
		this.panel = panel;
		this.window = window;
	}
	
	/**
	 * Execute the gameOver routine
	 * 
	 * @param audio
	 */
	public void gameOver(){
		panel.update();
		JOptionPane.showMessageDialog(null, "Game Over!");
		window.dispose();
	}
	
	/**
	 * Execute the victory routine
	 */
	public void victory(){
		panel.update();
		JOptionPane.showMessageDialog(null, "Victory!");
		window.dispose();
	}
}
