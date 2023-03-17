package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {


    @Test
    void StateTransitiontest(){
        SecurityContext ctx = new SecurityContext(new User(),new EncryptedString("hello"));
        assertTrue(ctx.getState() instanceof LoggedOut);
        ctx.login(new EncryptedString("hello"));
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    void  StateTransitionTestEqualtest(){
        SecurityContext ctx = new SecurityContext(new User(),new EncryptedString("hello"));
        ctx.login(new EncryptedString("hello"));
        assertEquals(ctx.getState(),LoggedIn.getLoggedInInstance(ctx));
        ctx.logout();
        assertEquals(ctx.getState(),LoggedOut.getLoggedOutInstance(ctx));
    }


}