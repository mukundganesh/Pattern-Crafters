package edu.umb.cs680.hw16;

public interface Observer<StockEvent> {
	public void update(Observable<StockEvent> sender, StockEvent event);

}
