package edu.umb.cs680.hw04;

public class LoggedIn implements State{
    public static LoggedIn LoggedInInstance =null;

    public SecurityContext ctx;


    public LoggedIn(SecurityContext ctx){
        this.ctx=ctx;
    }

    public static LoggedIn getLoggedInInstance(SecurityContext ctx){
        if(LoggedInInstance==null){
            LoggedInInstance = new LoggedIn(ctx);
        }
        return  LoggedInInstance;
    }

    public State login(EncryptedString pwd) {
        if(!ctx.isActive()){
            ctx.ChangeState(LoggedOut.getLoggedOutInstance(ctx));
            ctx.login(pwd);
        }
        return LoggedInInstance;
    }


    public State logout() {
        ctx.ChangeState(LoggedOut.getLoggedOutInstance(ctx));
        ctx.isActive=false;
        return LoggedInInstance;

    }
}
