package edu.umb.cs680.hw05;

public class Authenticator {
    public static boolean authenticate(SecurityContext ctx, EncryptedString pwd){
        if(ctx.getPwd().pwd.equals(pwd.pwd)){
            return true;
        }else{
            return false;
        }
    }
    }
