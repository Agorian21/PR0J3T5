package contract.view;

import java.awt.Graphics;

public interface IPanel {
	/**
	 * Paint the component
	 * @param g
	 */
	public void paintComponent(Graphics g);

	/**
	 * update the map
	 */
	public void update();
	
	/**
	 * Getter of diamondGet
	 * @return diamondGet
	 */
	public int getDiamondsGet();

	/**
	 * Setter of diamondGet
	 * @param diamondsGet
	 */
	public void setDiamondsGet(int diamondsGet);
	
	/**
	 * Getter of Score
	 * @return Score
	 */
	public int getScore();

	/**
	 * Setter of Score
	 * @param score
	 */
	public void setScore(int score);
}
