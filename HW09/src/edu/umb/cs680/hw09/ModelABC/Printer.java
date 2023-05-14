package edu.umb.cs680.hw09.ModelABC;

public class Printer {

    private static Printer Printerinstance=null;

    private Printer printer;

    private Printer() {}

    public static  Printer getPrinterinstance() {
        //singleton instance
        if(Printerinstance==null){
            Printerinstance= new Printer();
        }
        return Printerinstance;
    }

    public void print(){
        System.out.println("Printing job is being executed");
    }
}
