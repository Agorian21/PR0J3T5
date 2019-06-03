package controller;

import contract.view.IPanel;
import model.move.EnemyMove;
import model.move.Gravity;
import view.MapConstructor;

public class GameTurn {
	private MapConstructor maker;
	private Gravity gravity;
	private Controller controller;
	
	private EnemyMove enemyMove;
	private IPanel panel;
	private EndTheGame end;
	private boolean loop = true;
/**
 * Constructor of GameTurn
 * @param maker
 * @param panel
 * @param end
 * @param controller
 */
	public GameTurn(MapConstructor maker, IPanel panel, EndTheGame end,Controller controller) {
		this.maker = maker;
		this.panel = panel;
		this.end = end;
		this.controller= controller;
		gravity = new Gravity();
		enemyMove = new EnemyMove();
	}

	/**
	 * The loop of the game which moves every movable elements every
	 * 250ms 
	 * @throws InterruptedException
	 */
	public void loop() throws InterruptedException {
		while (loop) {
			Thread.sleep(250);
			
			maker.setAllHasMovedToFalse(maker.getSprites());
			controller.directionControl();		
			gravity.makeThemSlide(maker.getSprites());
			gravity.makeThemFall(maker.getSprites(), this.panel);
			enemyMove.toMoveTheEnemies(maker.getSprites());
			if (gravity.isGameOver() || enemyMove.isGameOver()) {
				end.gameOver();
				loop = false;
			}
			panel.update();
		}
	}
}
