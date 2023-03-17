package edu.umb.cs680.hw04;

import java.util.Objects;

public class LoggedOut implements State {

    public static LoggedOut LoggedOutInstance=null;
    SecurityContext ctx;

    public LoggedOut(SecurityContext ctx) {
        this.ctx=ctx;
    }

    public static LoggedOut getLoggedOutInstance(SecurityContext ctx) {
        try {
            return Objects.requireNonNull(LoggedOutInstance);
        } catch (NullPointerException ex) {
            LoggedOutInstance = new LoggedOut(ctx);
            return LoggedOutInstance;
        }
    }


    public State login(EncryptedString pwd) {
        if (Authenticator.authenticate(ctx,pwd)) {
            ctx.ChangeState(LoggedIn.getLoggedInInstance(ctx));
        }
        else{
            throw new RuntimeException("Authentication Failure");
        }
        return LoggedOutInstance;
    }


    public State logout(){
        return null;
    }
}