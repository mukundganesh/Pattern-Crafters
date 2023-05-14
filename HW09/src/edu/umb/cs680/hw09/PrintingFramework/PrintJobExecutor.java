package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.EncryptedString;
import edu.umb.cs680.hw09.SecurityContext;

public abstract class PrintJobExecutor {


    public void execute(Command job, EncryptedString pwd, SecurityContext ctx) throws IllegalStateException{
        try{
            doAuthentication(pwd, ctx);
        }
        catch (IllegalStateException ex){
            doErrorHandling();
            throw ex;
        }

        doPrint(job,ctx);

    }

    protected void doAuthentication(EncryptedString pwd,SecurityContext ctx) throws IllegalStateException{
    }

    protected void doAccessControl(){

    }

    protected void doPrint(Command job, SecurityContext ctx){
    }

    protected void doErrorHandling(){

    }

    public static void main(String[] args) {

    }




}
