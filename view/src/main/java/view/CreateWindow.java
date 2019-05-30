package view;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import contract.controller.IVKeyListener;
import contract.view.ICreateWindow;
import contract.view.IPanel;

public class CreateWindow extends JFrame implements ICreateWindow {
	private static final long serialVersionUID = 8164118974463460991L;
	private Panel panel;
//	private ScorePanel scorePanel;
	int finalDiamonds;


	/**
	 * The constructor of Window
	 * @param maker
	 * @param listener
	 * @param finalDiamonds
	 * @param title
	 */
	public CreateWindow(MapConstructor maker, IVKeyListener listener, int finalDiamonds, int title) {

		/*
		 * Create a new window
		 */
		this.finalDiamonds = finalDiamonds;
		this.setTitle("BoulderDash level " + title);
		this.setSize(405, 490);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.addKeyListener((KeyListener) listener);
		/*
		 * Create a new Panel
		 */
		panel = new Panel(maker, finalDiamonds);

		/*
		 * Fill the panel
		 */
		this.setContentPane(panel);
		this.setVisible(true);
		
		
	}
	
	public IPanel getPanel() {
		return panel;
	}
}