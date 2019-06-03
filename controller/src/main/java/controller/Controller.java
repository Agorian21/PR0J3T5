package controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.model.ISprite;
import contract.model.Permeability;
import contract.model.SpriteType;
import contract.view.IPanel;
import model.move.Move;
import view.MapConstructor;

public class Controller implements IController {
	private ControllerOrder stackOrder = ControllerOrder.NOP;
	private int SET_SIZE = 0, colonne = 0, ligne = 0, finalDiamonds = 0;
	private IPanel panel;
	private ISprite sprite;
	private MapConstructor maker;
	private Move move;
	protected Image image;

	private EndTheGame end;

	/**
	 * Constructor of Controller
	 * 
	 * @param sprite
	 * @param panel
	 * @param SET_SIZE
	 * @param maker
	 * @param finalDiamonds
	 */
	public Controller(ISprite sprite, IPanel panel, int SET_SIZE, MapConstructor maker, int finalDiamonds, EndTheGame end) {
		this.panel = panel;
		this.sprite = sprite;
		this.SET_SIZE = SET_SIZE;
		this.maker = maker;
		this.finalDiamonds = finalDiamonds;

		move = new Move(maker.getSprites(), SET_SIZE, panel);

		this.end = end;
	}

	/**
	 * move the character
	 */

	@Override
	public final void directionControl() throws InterruptedException {
		if (sprite.getType() == SpriteType.PLAYER) {

			move.setVictory(false);
			move.gameOver(false);

			colonne = sprite.getX() / SET_SIZE;
			ligne = sprite.getY() / SET_SIZE;

			switch (this.getStackOrder()) {
			case RIGHT:
				maker.setSprites(move.digRight(colonne, ligne, sprite));
				break;
			case LEFT:
				maker.setSprites(move.digLeft(colonne, ligne, sprite));
				break;
			case DOWN:
				maker.setSprites(move.digDown(colonne, ligne, sprite));
				break;
			case UP:
				maker.setSprites(move.digUp(colonne, ligne, sprite));
				break;
			case NOP:
			default:
				break;
			}

			if (move.isGameOver()) {
				end.gameOver();
			}

			if (panel.getDiamondsGet() >= finalDiamonds) {
				setExitToPermeable(maker.getSprites());
			}

			if (move.isVictory()) {
				end.victory();
			}
			stackOrder = ControllerOrder.NOP;
		}
	}

	/**
	 * @return stackOrder
	 */
	public ControllerOrder getStackOrder() {
		return stackOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IController#setStackOrder(model.UserOrder)
	 */
	@Override
	public void setStackOrder(ControllerOrder stackOrder) {
		this.stackOrder = stackOrder;
	}


	/**
	 * It sets the exit's permeability to permeable
	 * 
	 * @param sprites
	 */
	public void setExitToPermeable(ISprite[][] sprites) {
		for (ISprite[] sousSpit : sprites) {
			for (ISprite spit : sousSpit) {
				if (spit.getType() == SpriteType.EXIT) {
					spit.setPermeability(Permeability.PERMEABLE);
					try {
							image = ImageIO.read(new File("../images/ExitOpen.png"));
							spit.setImage(image);
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
