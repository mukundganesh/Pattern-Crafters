package edu.umb.cs680.hw16;

public class LineChartObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("This is Line Chart Observer Printing \n The Line plot has been plotted");
        System.out.println("(Quote,Ticker)"+"("+event.getQuote()+","+event.getTicker()+")");
    }

}

