package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import contract.model.IMapMatrix;
import contract.model.SpriteType;

public class MapMatrix implements IMapMatrix {
	private Map<Character, SpriteType> translator = new HashMap<>();
	private int characterX = 0, characterY = 0;
	private SpriteType map[][] = new SpriteType[25][25];

	/**
	 * The constructor of MapMatrix
	 * 
	 * @param tab
	 *            the character arrey which contains the map in the form of
	 *            characters
	 * @throws IOException
	 */
	public MapMatrix(char[][] tab) throws IOException {

		/*
		 * Fill translator with the pictures which correspond to the characters
		 */
		this.translator.put('0', SpriteType.BACKGROUND);	
		this.translator.put('1', SpriteType.PLAYER);	
		this.translator.put('2', SpriteType.ENEMY);	
		this.translator.put('3', SpriteType.BOULDER);
		this.translator.put('4', SpriteType.DIAMOND);	
		this.translator.put('5', SpriteType.DIRT);
		this.translator.put('6', SpriteType.WALL);
		this.translator.put('7', SpriteType.EXIT);


		/*
		 * Fill a two-dimensional array 
		 */
		int ligne = 0, colonne = 0;
		for (char sousTab[] : tab) {
			colonne = 0;
			for (char chr : sousTab) {
				if (this.translator.containsKey(chr)) {
					map[ligne][colonne] = this.translator.get(chr);
					if (chr == '1') {
						characterX = colonne;
						characterY = ligne;
					}
				} else {
					System.out.println("Error TranslateMap");
				}
				colonne++;
			}
			ligne++;
		}
	}

	/**
	 * @return map a two-dimensional SpriteType array which contains the map in
	 *         the form of enum
	 */
	public SpriteType[][] getMap() {
		return map;
	}

	/* (non-Javadoc)
	 * @see view.ITranslateMap#getCharacterX()
	 */
	@Override
	public int getCharacterX() {
		return characterX;
	}

	/* (non-Javadoc)
	 * @see view.ITranslateMap#getCharacterY()
	 */
	@Override
	public int getCharacterY() {
		return characterY;
	}
}