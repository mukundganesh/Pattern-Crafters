package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.EncryptedString;
import edu.umb.cs680.hw09.PrintingFramework.Command;
import edu.umb.cs680.hw09.SecurityContext;
import edu.umb.cs680.hw09.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.in;
import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {
    private final ByteArrayOutputStream ootcon = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errcon = new ByteArrayOutputStream();
    private final PrintStream origi = System.out;
    private final PrintStream origierr = System.err;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(ootcon));
        System.setErr(new PrintStream(errcon));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(origi);
        System.setErr(origierr);
    }

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
        assertTrue(ootcon.toString().contains("Printing job is being executed"));
    }

    @Test
    void  printjobtest(){
        PrintJob printJob=new PrintJob();
        printJob.execute();
        assertTrue(printJob instanceof PrintJob);
        assertTrue(ootcon.toString().contains("Printing job is being executed"));
    }


    public void authentication_doprint_test() throws Exception{
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw09.ModelABC.PrintJobExecutor gen=new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
        EncryptedString pwd= new EncryptedString("hello1");
        Command job=new PrintJob();
        gen.execute(job,pwd,ctx);
        PrintJobExecutor printJobExecutor= new PrintJobExecutor();
        printJobExecutor.doPrint(job, ctx);

    }
    @Test
    public void doPrintfuncusingExecuteauthenfailure() throws Exception {
        SecurityContext ctx = new SecurityContext(new User(), new EncryptedString("hello"));
        edu.umb.cs680.hw09.ModelABC.PrintJobExecutor gen = new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor();
        try {
            authentication_doprint_test();
            fail("Expected Exception not thrown");
        } catch (IllegalStateException exception) {
            System.out.println("The Exception is caught");
            assertTrue(ootcon.toString().contains("Current Job aborted,Retry logging in and Performing job"));
        }
    }
}