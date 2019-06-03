package contract.view;

import java.util.List;

public interface ICreateMenu {
	/**
	 * Getter of Observators
	 * @return an Observators list
	 */
	public List<LvlObservator> getObservators();
	/**
	 * Setter of Observators
	 * @param observators
	 */
	public void setObservators(List<LvlObservator> observators);
	
	/**
	 * Getter of Choice
	 * @return Choice
	 */
	public int getChoice();

}