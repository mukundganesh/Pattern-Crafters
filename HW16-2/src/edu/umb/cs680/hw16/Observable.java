package edu.umb.cs680.hw16;

import java.util.LinkedList;
import java.util.List;


public abstract class Observable<StockEvent> {

	private LinkedList<Observer<StockEvent>> observers = new LinkedList<>();
	
	public void addObserver(Observer<StockEvent> stockEventObserver) {
		observers.add(stockEventObserver);
	}

	public void clearObservers() {
		observers.clear();
		
	}
	public List<Observer<StockEvent>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}
	public void removeObserver(Observer<StockEvent> stockEventObserver) {
		observers.remove(stockEventObserver);
	}

	public void notifyObservers(StockEvent event) {
		observers.forEach( (observer)->{observer.update(this, event);} );
	}

	public static void main(String[] args) {
	}
	
}
