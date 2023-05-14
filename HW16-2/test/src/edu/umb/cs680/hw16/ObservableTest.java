package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.Line;
import java.awt.*;
import java.util.Random;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ObservableTest {
    private TreeMap<String,Double> linechartmap = new TreeMap<>();
    private TreeMap<String,Double> tablemap=new TreeMap<>();
    private TreeMap<String,Double> Threedmap=new TreeMap<>();



    @Test
    void change_Quote_test(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        stockQuoteObservable.changeQuote("INBB",23.76);
        TreeMap<String,Double> actual= stockQuoteObservable.getStringDoubleTreeMap();
        TreeMap<String,Double> expected = new TreeMap<>();
        expected.put("INBB",23.76);
        assertEquals(expected,actual);
    }

    @Test
    void Stock_Quote_Observable_notify_test() throws InterruptedException {

        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        Observer<StockEvent> QuoteUpdateLineChart=(sender, event) -> {
            linechartmap.put(event.getTicker(),event.getQuote());
            System.out.println("Line Chart Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdateTableObserver=(sender, event) -> {
            tablemap.put(event.getTicker(),event.getQuote());
            System.out.println("Table Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdate3D= (sender, event) -> {
            Threedmap.put(event.getTicker(),event.getQuote());
            System.out.println("3d Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };

        stockQuoteObservable.addObserver(QuoteUpdateLineChart);
        stockQuoteObservable.addObserver(QuoteUpdateTableObserver);
        stockQuoteObservable.addObserver(QuoteUpdate3D);
        Random random=new Random();
        double upperbound=100;
        for(int i=0;i<3;i++){
            String ticker="HSBC";
            double quote=random.nextDouble()*upperbound;
            stockQuoteObservable.changeQuote(ticker,quote);
            Thread.sleep(2000);
            assertEquals(stockQuoteObservable.getStringDoubleTreeMap(),linechartmap);
            assertEquals(stockQuoteObservable.getStringDoubleTreeMap(),tablemap);
            assertEquals(stockQuoteObservable.getStringDoubleTreeMap(),Threedmap);
        }
        assertEquals(3,stockQuoteObservable.countObservers());
    }

    @Test
    void add_and_remove_obeservertest(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        Observer<StockEvent> QuoteUpdateLineChart=(sender, event) -> {
            System.out.println("Line Chart Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdateTableObserver=(sender, event) -> {
            System.out.println("Table Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdate3D= (sender, event) -> {
            System.out.println("3d Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        stockQuoteObservable.addObserver(QuoteUpdateTableObserver);
        stockQuoteObservable.addObserver(QuoteUpdateLineChart);
        stockQuoteObservable.addObserver(QuoteUpdate3D);
        stockQuoteObservable.changeQuote("BBBO",212.2);
        assertEquals(3,stockQuoteObservable.countObservers());
        stockQuoteObservable.removeObserver(QuoteUpdateTableObserver);
        stockQuoteObservable.changeQuote("BBBO",212.2);
        assertEquals(2,stockQuoteObservable.countObservers());

    }

    @Test
    void clear_observer_test(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        Observer<StockEvent> QuoteUpdateLineChart=(sender, event) -> {
            System.out.println("Line Chart Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdateTableObserver=(sender, event) -> {
            System.out.println("Table Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdate3D= (sender, event) -> {
            System.out.println("3d Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        stockQuoteObservable.addObserver(QuoteUpdateTableObserver);
        stockQuoteObservable.addObserver(QuoteUpdateLineChart);
        stockQuoteObservable.addObserver(QuoteUpdate3D);
        stockQuoteObservable.clearObservers();
        assertEquals(0,stockQuoteObservable.countObservers());
    }

    @Test
    void update_observers_usingLE(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        Observer<StockEvent> QuoteUpdateLineChart=(sender, event) -> {
            System.out.println("Line Chart Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdateTableObserver=(sender, event) -> {
            System.out.println("Table Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };
        Observer<StockEvent> QuoteUpdate3D= (sender, event) -> {
            System.out.println("3d Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
        };

        stockQuoteObservable.addObserver(QuoteUpdateTableObserver);
        stockQuoteObservable.addObserver(QuoteUpdate3D);
        stockQuoteObservable.addObserver(QuoteUpdateLineChart);
        stockQuoteObservable.changeQuote("BBBO",212.2);

        assertEquals(3,stockQuoteObservable.countObservers());

        stockQuoteObservable.removeObserver(QuoteUpdateTableObserver);
        stockQuoteObservable.removeObserver(QuoteUpdateLineChart);
        stockQuoteObservable.changeQuote("BBBO",212.2);

        assertEquals(1,stockQuoteObservable.countObservers());

        stockQuoteObservable.clearObservers();
        assertEquals(0,stockQuoteObservable.countObservers());

    }
}