package contract.view;

import java.util.List;
import java.util.Observable;

public interface ICreateMenu {
	public List<LvlObservator> getObservators();
	
	public void setObservators(List<LvlObservator> observators);
	
	public int getChoice();

	public void update(Observable obs, Object obj);
}