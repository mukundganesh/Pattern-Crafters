package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.EncryptedString;
import edu.umb.cs680.hw09.LoggedIn;
import edu.umb.cs680.hw09.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw09.PrintingFramework.PrintJobExecutor{
    public boolean authenstatus=false;

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws IllegalStateException{
        try {
            ctx.login(pwd);
            if ((ctx.getState() instanceof LoggedIn) && !authenstatus){
                authenstatus = true;
            } else {
                authenstatus = false;
            }
        } catch(RuntimeException runtimeException) {
            throw new IllegalStateException("Authentication Failed please check uname and password");
        }
    }

    @Override
    protected void doAccessControl(){
    }

    @Override
    protected void doPrint(){
        if(authenstatus){
            PrintJob printJob=new PrintJob();
            printJob.execute();
            System.out.println("This Text is Printed by the PRINTER MODELABC");

        }else{
            System.out.println("Please Complete the Authentication process");
        }


    }

    @Override
    protected void doErrorHandling(){
        System.out.println("Current Job aborted,Retry logging in and Performing job");
    }

    public static void main(String[] args) throws IllegalStateException{

    }
}
