package edu.umb.cs680.hw16;

public class StockEvent {

    private String ticker;
    private double quote;

    public StockEvent(String ticker,double quote){
        this.ticker=ticker;
        this.quote=quote;
    }

    public double getQuote() {
        return quote;
    }

    public String getTicker() {
        return ticker;
    }
}
