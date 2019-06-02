package controller;

import contract.view.IPanel;
import model.move.EnemyMove;
import model.move.Gravity;
import view.MapConstructor;

public class GameTurn {
	private MapConstructor maker;
	private Gravity gravity;

	private EnemyMove enemyMove;
	private IPanel panel;
	private EndTheGame end;
	private boolean loop = true;

	public GameTurn(MapConstructor maker, IPanel panel, EndTheGame end) {
		this.maker = maker;
		this.panel = panel;
		this.end = end;
		gravity = new Gravity();
		enemyMove = new EnemyMove();
	}

	public void loop(Controller controller) throws InterruptedException {
		while (loop) {
			Thread.sleep(250);
			maker.setAllHasMovedToFalse(maker.getSprites());
			gravity.makeThemSlide(maker.getSprites());
			gravity.makeThemFall(maker.getSprites(), this.panel);
			enemyMove.toMoveTheEnemies(maker.getSprites());
			controller.directionControl();		
			if (gravity.isGameOver() || enemyMove.isGameOver()) {
				end.gameOver();
				loop = false;
			}
			panel.update();
		}
	}
}
