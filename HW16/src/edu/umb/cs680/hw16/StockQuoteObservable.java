package edu.umb.cs680.hw16;

import java.util.TreeMap;

public class StockQuoteObservable extends Observable {

    public StockQuoteObservable(){
        stringDoubleTreeMap=new TreeMap<String,Double>();
    }

    private TreeMap<String, Double> stringDoubleTreeMap;

    public TreeMap<String,Double> getStringDoubleTreeMap(){
        return stringDoubleTreeMap;
    }

    public void  changeQuote(String t,Double q){
        stringDoubleTreeMap.put(t,q);
        notifyObservers(new StockEvent(t,q));
    }

}
