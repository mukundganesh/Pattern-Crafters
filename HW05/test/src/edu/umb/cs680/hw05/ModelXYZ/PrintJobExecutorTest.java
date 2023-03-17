package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.LoggedOut;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {
    @Test
    public void SimpledoPrinttest(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor gen=new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        gen.doPrint();
    }

    @Test
    public void doPrintfuncusingExecute(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor gen=new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
        gen.execute("printjob",new EncryptedString("hello"),ctx);
    }

    @Test
    public void initialStatetest(){
        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

}