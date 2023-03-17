package edu.umb.cs680.hw05.ModelABC;

import edu.umb.cs680.hw05.SecurityContext;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.User;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor{
    public boolean authenstatus=false;

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws IllegalStateException{
        try {
            ctx.login(pwd);
            if (ctx.isActive() && !authenstatus){
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
        System.out.println("This is Main Class of PRINTER ABC");
//        SecurityContext ctx=new SecurityContext(new User(),new EncryptedString("hello"));
//        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor priABC = new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
//        priABC.execute("printJobAuthentication", new EncryptedString("hello1"),ctx);
//        priABC.doPrint();

    }
}
