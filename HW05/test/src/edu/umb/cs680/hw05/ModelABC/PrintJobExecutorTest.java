package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest extends PrintJobExecutor {
    @Test
    public void SimpledoPrinttest(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor gen=new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        gen.doPrint();
    }

    @Test
    public void doPrintfuncusingExecute(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor gen=new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        gen.execute("printjob",new EncryptedString("hello"),ctx);//successfullauthentication
    }

    public void authentication(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor gen=new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        EncryptedString pwd= new EncryptedString("hello1");
        gen.execute("printjob",pwd,ctx);

    }
    @Test
    public void doPrintfuncusingExecuteauthenfailure(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor gen=new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
        try{
            authentication();
            fail("Expected Exception not thrown");
        }catch (IllegalStateException exception){
            System.out.println("The Exception is caught");
        }

    }
}

