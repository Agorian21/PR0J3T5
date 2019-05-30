package contract.controller;

public interface IVKeyListener {
	/**
	 * @param keyCode
	 * @return
	 */
	public ControllerOrder keyCodeToUserOrder(final int keyCode);
	
	/**
	 * @return
	 */
	public IController getController();

	/**
	 * @param controller
	 */
	public void setController(IController controller);
}
