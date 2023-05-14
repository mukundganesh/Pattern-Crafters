package edu.umb.cs680.hw16;
import edu.umb.cs680.hw16.StockEvent;

public interface Observer<StockEvent> {
	public void update(Observable<StockEvent> sender, StockEvent event);

}
