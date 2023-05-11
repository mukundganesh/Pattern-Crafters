package edu.umb.cs680.hw16;

public class ThreeDObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent stockEvent) {
        System.out.println("This is 3 Dimensional  Observer Printing \n The 3 dimensional graph has been plotted");
        System.out.println("(Quote,Ticker)"+"("+stockEvent.getQuote()+","+stockEvent.getTicker()+")");

    }
}
