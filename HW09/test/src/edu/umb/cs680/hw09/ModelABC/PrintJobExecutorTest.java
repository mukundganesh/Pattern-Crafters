package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.EncryptedString;
import edu.umb.cs680.hw09.PrintingFramework.Command;
import edu.umb.cs680.hw09.SecurityContext;
import edu.umb.cs680.hw09.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    @Test
    void printersingletontest(){
        Printer class1=Printer.getPrinterinstance();
        Printer class2=Printer.getPrinterinstance();
        assertEquals(class1.hashCode(),class2.hashCode());
    }

    @Test
    void Printjobexecutortest(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        PrintJobExecutor printJobExecutor= new PrintJobExecutor();
        EncryptedString pwd=new EncryptedString("hello");
        Command job=new PrintJob();
        printJobExecutor.execute(job,pwd,ctx);
    }

    @Test
    void  printjobtest(){
        PrintJob printJob=new PrintJob();
        printJob.execute();
        assertTrue(printJob instanceof PrintJob);
    }

    @Test
    void doprinttest(){
        PrintJobExecutor printJobExecutor= new PrintJobExecutor();
        printJobExecutor.doPrint();
    }

    public void authentication(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw09.ModelABC.PrintJobExecutor gen=new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
        EncryptedString pwd= new EncryptedString("hello1");
        Command job=new PrintJob();
        gen.execute(job,pwd,ctx);

    }
    @Test
    public void doPrintfuncusingExecuteauthenfailure() {
        SecurityContext ctx = new SecurityContext(new User(), new EncryptedString("hello"));
        edu.umb.cs680.hw09.ModelABC.PrintJobExecutor gen = new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
        try {
            authentication();
            fail("Expected Exception not thrown");
        } catch (IllegalStateException exception) {
            System.out.println("The Exception is caught");
        }
    }
}