package view;

import java.awt.Graphics;

import contract.model.ISprite;
import contract.model.SpriteType;
import contract.view.IMapConstructor;
import model.MapMatrix;
import model.element.Background;
import model.element.Boulder;
import model.element.Diamond;
import model.element.Dirt;
import model.element.Enemy;
import model.element.Exit;
import model.element.Player;
import model.element.Sprite;
import model.element.Wall;

public class MapConstructor implements IMapConstructor {
	private ISprite[][] sprites = new Sprite[25][25];
	private SpriteType map[][];
	private int x = 0, y = 0, ligne = 0, colonne = 0;

	/**
	 * The constructor of MapMaker,
	 * 
	 * @param translate
	 *            the translation of the query
	 */
	public MapConstructor(MapMatrix translate) {
		this.map = translate.getMap();
	}

	/**
	 * It creates the sprites which are in the map and give their position.
	 * Then they're put in the sprites array.
	 * 
	 * @param SET_SIZE
	 *            the size of a sprite
	 */
	@Override
	public void spritesCreation(final int SET_SIZE) {
		ligne = 0;
		for (SpriteType sousSpitTp[] : map) {
			x = 0;
			colonne = 0;
			for (SpriteType SpitTp : sousSpitTp) {
				switch (SpitTp) {
				case WALL:
					sprites[ligne][colonne] = new Wall(x, y);
					break;
				case DIRT:
					sprites[ligne][colonne] = new Dirt(x, y);
					break;
				case BACKGROUND:
					sprites[ligne][colonne] = new Background(x, y);
					break;
				case BOULDER:
					sprites[ligne][colonne] = new Boulder(x, y);
					break;
				case DIAMOND:
					sprites[ligne][colonne] = new Diamond(x, y);
					break;
				case PLAYER:
					sprites[ligne][colonne] = new Player(x, y);
					break;
				case EXIT:
					sprites[ligne][colonne] = new Exit(x, y);
					break;
				case ENEMY:
					sprites[ligne][colonne] = new Enemy(x, y);
					break;
				default:
					break;
				}
				x = x + SET_SIZE;
				colonne++;
			}
			y = y + SET_SIZE;
			ligne++;
		}
	}

	/**
	 * It displays the sprites and their position
	 * 
	 * @param g
	 * 
	 */
	@Override
	public void drawMap(Graphics g) {
		for (ISprite[] sousSpit : sprites) {
			for (ISprite spit : sousSpit) {
				g.drawImage(spit.getImage(), spit.getX(), spit.getY(), null);
			}
		}
	}

	/**
	 * 
	 * @return a two-dimensional array of Sprite
	 */
	@Override
	public ISprite[][] getSprites() {
		return sprites;
	}

	/**
	 * 
	 * @return a Sprite in the two-dimensional array
	 */
	@Override
	public ISprite getCharacter(int colonne, int ligne) {
		return sprites[ligne][colonne];
	}

	/* (non-Javadoc)
	 * @see view.IMapMaker#setSprites(view.ISprite[][])
	 */
	@Override
	public void setSprites(ISprite[][] sprites) {
		this.sprites = sprites;
	}

	/* (non-Javadoc)
	 * @see view.IMapMaker#setAllHasMovedToFalse(view.ISprite[][])
	 */
	@Override
	public void setAllHasMovedToFalse(ISprite[][] sprites) {
		for (ISprite sousSpit[] : sprites) {
			for (ISprite spit : sousSpit) {
				spit.setHasMoved(false);
			}
		}
	}
}