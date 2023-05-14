package edu.umb.cs680.hw16;

import java.util.TreeMap;

public class ThreeDObserver implements Observer<StockEvent>{

    private TreeMap<String,Double> map=new TreeMap<>();

    @Override
    public void update(Observable<StockEvent> sender, StockEvent stockEvent) {
        map.put(stockEvent.getTicker(),stockEvent.getQuote());
        System.out.println("This is 3 Dimensional  Observer Printing \n The 3 dimensional graph has been plotted");
        System.out.println("(Quote,Ticker)"+"("+stockEvent.getQuote()+","+stockEvent.getTicker()+")");

    }

    public TreeMap<String,Double> getmap(){
        return map;
    }


}

