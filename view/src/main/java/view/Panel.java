package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JPanel;

import contract.view.IMapConstructor;
import contract.view.IPanel;

public class Panel extends JPanel implements Serializable, IPanel {
	private static final long serialVersionUID = 1L;
	Font font = new Font("Courier", Font.BOLD, 15);
	private int diamondsGet = 0, score = 0;
	private IMapConstructor maker;
	private int finalDiamonds;

	/**
	 * The constructor of Panel
	 * 
	 * @param maker
	 *            the maker of the map
	 */
	public Panel(MapConstructor maker, int finalDiamonds) {
		this.maker = maker;
		this.finalDiamonds = finalDiamonds;
	}

	public void counterDiamond(Graphics g){
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Diamonds : " + diamondsGet + "/" + finalDiamonds, 10, 430);
	}
	
	public void counterScore(Graphics g){
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Score : " + score, 10, 450);
	}
	
	/**
	 * @param g
	 */
	public void updateCount(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 500);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		this.updateCount(g);
		this.counterDiamond(g);
		this.counterScore(g);
		this.maker.drawMap(g);
	}

	/**
	 * Update the map when a movement is done
	 */
	@Override
	public void update() {
		this.repaint();
	}

	@Override
	public int getDiamondsGet() {
		return diamondsGet;
	}

	@Override
	public void setDiamondsGet(int diamondsGet) {
		this.diamondsGet = diamondsGet;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setScore(int score) {
		this.score = score;
	}
}