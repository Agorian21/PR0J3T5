package contract.controller;

import java.io.IOException;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public void directionControl() throws InterruptedException;

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void setStackOrder(ControllerOrder controllerOrder);
}
