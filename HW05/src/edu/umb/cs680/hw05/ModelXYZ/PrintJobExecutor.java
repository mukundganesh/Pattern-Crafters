package edu.umb.cs680.hw05.ModelXYZ;

import edu.umb.cs680.hw05.SecurityContext;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.User;

public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor {
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx){
    }
    @Override
    protected void doAccessControl(){
    }
    @Override
    protected void doPrint(){
        System.out.println("This Text is Printed by the PRINTER MODELXYZ");
    }

    @Override
    protected void doErrorHandling(){

    }

    public static void main(String[] args) {
//        SecurityContext ctx=new SecurityContext(new User(),new EncryptedString("hello"));
//        edu.umb.cs680.hw05.ModelABC.PrintJobExecutor priABC = new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
//        priABC.doAuthentication(new EncryptedString("hello"),ctx);
//        SecurityContext ctx= new SecurityContext(new User(),new EncryptedString("hello"));
//        edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor gen=new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
//        gen.execute("printjob",new EncryptedString("hello"),ctx);
        System.out.println("This is the Main Class Of printer ModelXYZ");
    }

}
