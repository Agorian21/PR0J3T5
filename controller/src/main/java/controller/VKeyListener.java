package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.controller.IVKeyListener;

public class VKeyListener extends Observable implements KeyListener, IVKeyListener{
	private IController controller;
	
	/**
	 * It return the direction corresponding to the key pressed
	 * @param keyCode
	 * 			The value corresponding to the key pressed
	 * @return userOrder
	 */
	
	public ControllerOrder keyCodeToUserOrder(final int keyCode) {
		ControllerOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = ControllerOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = ControllerOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = ControllerOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = ControllerOrder.DOWN;
			break;
		default:
			userOrder = ControllerOrder.NOP;
			break;
		}
		return userOrder;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		this.getController().setStackOrder(keyCodeToUserOrder(keyEvent.getKeyCode()));
		setChanged();
		notifyObservers(keyEvent);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	/* (non-Javadoc)
	 * @see controller.IBDKeyListener#getController()
	 */
	public IController getController() {
		return this.controller;
	}

	/* (non-Javadoc)
	 * @see controller.IBDKeyListener#setController(controller.IController)
	 */

	public void setController(IController controller) {
		this.controller =  controller;
	}
}