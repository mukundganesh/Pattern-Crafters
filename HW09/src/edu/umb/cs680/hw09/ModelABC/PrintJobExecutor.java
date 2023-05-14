package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.EncryptedString;
import edu.umb.cs680.hw09.LoggedIn;
import edu.umb.cs680.hw09.PrintingFramework.Command;
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
    protected void doPrint(Command job, SecurityContext ctx){

        if(this.authenstatus){
            job.execute();
        }else {
            doErrorHandling();
        }

    }

    @Override
    protected void doErrorHandling(){
        System.out.println("Current Job aborted,Retry logging in and Performing job");
    }
    public static void main(String[] args) throws IllegalStateException{

    }
}
