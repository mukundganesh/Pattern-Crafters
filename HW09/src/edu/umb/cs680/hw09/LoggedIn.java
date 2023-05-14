package edu.umb.cs680.hw09;

public class LoggedIn implements State {
    private static LoggedIn LoggedInInstance =null;

    private SecurityContext ctx;

    private LoggedIn(SecurityContext ctx){
        this.ctx=ctx;
    }

    public static LoggedIn getLoggedInInstance(SecurityContext ctx){
        if(LoggedInInstance==null){
            LoggedInInstance = new LoggedIn(ctx);
        }
        return  LoggedInInstance;
    }

    public State login(EncryptedString pwd) {
        if(!ctx.isActive() || ctx.isActive()){
            ctx.ChangeState(LoggedOut.getLoggedOutInstance(ctx));
            ctx.login(pwd);
        }
        return LoggedInInstance;
    }


    public State logout() {
        ctx.ChangeState(LoggedOut.getLoggedOutInstance(ctx));
        return LoggedInInstance;

    }
}
