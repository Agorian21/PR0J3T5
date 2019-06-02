package controller;

import java.io.IOException;

import contract.view.LvlObservator;
import dao.DBQueries;
import model.MapMatrix;
import view.CreateMenu;
import view.CreateWindow;
import view.MapConstructor;

public class Run implements LvlObservator {
	private static CreateMenu menu;
	private static MapConstructor maker = null;
	private final static int SET_SIZE = 16;

	/**
	 * Constructor of Launcher
	 * @throws IOException 
	 */
	public Run() throws IOException {
		menu = new CreateMenu();
		menu.getObservators().add(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.LevelObservator#onLevelSelected(int)
	 */
	@Override
	public void onLevelSelected(int level) {
		(new Thread(new Runnable() {
			@Override
			public void run() {
					DBQueries launchQuery = new DBQueries(level);
					launchQuery.queries();
					MapMatrix matrix;

					try {

						matrix = new MapMatrix(launchQuery.getTab());
						maker = new MapConstructor(matrix);
						maker.spritesCreation(SET_SIZE);

						VKeyListener vkeyListener = new VKeyListener();
						CreateWindow window = new CreateWindow(maker, vkeyListener, DBQueries.getDiamondRequired(), level);

						EndTheGame end = new EndTheGame(window.getPanel(), window);
						Controller controller = new Controller(
								maker.getCharacter(matrix.getCharacterX(), matrix.getCharacterY()),
								window.getPanel(), SET_SIZE, maker, DBQueries.getDiamondRequired(), end);

						vkeyListener.addObserver(controller);
						vkeyListener.setController(controller);

						GameTurn gameTurn = new GameTurn(maker, window.getPanel(), end, controller);
						gameTurn.loop();

					} catch (Exception e1) {
						e1.printStackTrace();

					}
				}
			
		})).start();
	}
}