package edu.umb.cs680.hw16;

public class TableObserver implements Observer<StockEvent>{
    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("This is Table Observer Printing The ticker and the quote \n ("+event.getQuote()+","+event.getTicker()+")");
    }
}
