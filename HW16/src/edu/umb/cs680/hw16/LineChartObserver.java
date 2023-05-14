package edu.umb.cs680.hw16;

import java.util.TreeMap;

public class LineChartObserver implements Observer<StockEvent>{

    private TreeMap<String,Double> map=new TreeMap<>();

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        map.put(event.getTicker(),event.getQuote());
        System.out.println("This is Line Chart Observer Printing \n The Line plot has been plotted");
        System.out.println("(Quote,Ticker)"+"("+event.getQuote()+","+event.getTicker()+")");
    }

    public TreeMap<String,Double> getmap(){
        return map;
    }

}

