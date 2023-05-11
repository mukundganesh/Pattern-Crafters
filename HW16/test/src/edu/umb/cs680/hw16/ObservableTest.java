package edu.umb.cs680.hw16;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Line;
import java.awt.*;
import java.util.Random;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class ObservableTest {

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
        TableObserver tableObserver=new TableObserver();
        LineChartObserver lineChartObserver=new LineChartObserver();
        ThreeDObserver threeDObserver=new ThreeDObserver();
         stockQuoteObservable.addObserver(lineChartObserver);
         stockQuoteObservable.addObserver(tableObserver);
         stockQuoteObservable.addObserver(threeDObserver);
        Random random=new Random();
        double upperbound=30.5;
        for(int i=0;i<3;i++){
            String ticker="HSBC";
            double quote=random.nextDouble(upperbound)*10;
            stockQuoteObservable.changeQuote(ticker,quote);
            Thread.sleep(2000);
        }
        assertEquals(3,stockQuoteObservable.countObservers());
    }

    @Test
    void add_and_remove_obeservertest(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        TableObserver tableObserver=new TableObserver();
        LineChartObserver lineChartObserver=new LineChartObserver();
        ThreeDObserver threeDObserver=new ThreeDObserver();
        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(lineChartObserver);
        stockQuoteObservable.addObserver(threeDObserver);
        stockQuoteObservable.changeQuote("BBBO",212.2);
        assertEquals(3,stockQuoteObservable.countObservers());
        stockQuoteObservable.removeObserver(tableObserver);
        stockQuoteObservable.changeQuote("BBBO",212.2);
        assertEquals(2,stockQuoteObservable.countObservers());

    }

    @Test
    void clear_observer_test(){
        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
        TableObserver tableObserver=new TableObserver();
        LineChartObserver lineChartObserver=new LineChartObserver();
        ThreeDObserver threeDObserver=new ThreeDObserver();
        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(lineChartObserver);
        stockQuoteObservable.addObserver(threeDObserver);
        stockQuoteObservable.clearObservers();
        assertEquals(0,stockQuoteObservable.countObservers());
    }

//    @Test
//    void update_observers_usingLE(){
//        StockQuoteObservable stockQuoteObservable=new StockQuoteObservable();
//        Observer<StockEvent> QuoteUpdateLineChart=(sender, event) -> {
//            System.out.println("Line Chart Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
//        };
//        Observer<StockEvent> QuoteUpdateTableObserver=(sender, event) -> {
//            System.out.println("Table Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
//        };
//        Observer<StockEvent> QuoteUpdate3D= (sender, event) -> {
//            System.out.println("3d Observer - Ticker: " + event.getTicker() + ", Quote: " + event.getQuote());
//        };
//
//        stockQuoteObservable.addObserver(QuoteUpdateTableObserver);
//        stockQuoteObservable.addObserver(QuoteUpdate3D);
//        stockQuoteObservable.addObserver(QuoteUpdateLineChart);
//        stockQuoteObservable.changeQuote("BBBO",212.2);
//
//        assertEquals(3,stockQuoteObservable.countObservers());
//
//        stockQuoteObservable.removeObserver(QuoteUpdateTableObserver);
//        stockQuoteObservable.removeObserver(QuoteUpdateLineChart);
//        stockQuoteObservable.changeQuote("BBBO",212.2);
//
//        assertEquals(1,stockQuoteObservable.countObservers());
//
//        stockQuoteObservable.clearObservers();
//        assertEquals(0,stockQuoteObservable.countObservers());
//
//    }
}