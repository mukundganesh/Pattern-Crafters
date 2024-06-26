package edu.umb.cs680.hw04;

import java.util.ArrayList;
import java.util.List;

public class SecurityContext {

    public List<Integer> list = new ArrayList<Integer>();
    public boolean isActive;
    public State state;

    private User user;

    public EncryptedString pwd;



    public SecurityContext(User user, EncryptedString pwd){
        this.user= user;
        this.pwd=pwd;
        isActive= false;
        state= new LoggedOut(this);
    }

    public void ChangeState(State newState){
        state=newState;
    }


    public boolean userloginfreq(){
        boolean res;
        if(isActive=false){
            return false;
        }else{
        if(list.size()>0){
            res=true;}
        else{
            res=false;
        }
        return res;
    }
    }

    public void logout(){
        state.logout();
        isActive=false;
    }

    public void login(EncryptedString pwd){
        state.login(pwd);
        list.add(1);
    }

    public boolean isActive(){

        return userloginfreq();
    }

    public State getState() {
        return state;
    }

    public EncryptedString getPwd(){
        return pwd;
    }

    public static void main(String[] args) {
        SecurityContext ctx = new SecurityContext(new User(),new EncryptedString("hello"));
        System.out.println("Initial state or Default state:  "+ctx.getState());
        System.out.println("Checking whether Login is Active or not :  "+  ctx.isActive());
        System.out.println("Performing login operation");
        ctx.login(new EncryptedString("hello"));
        System.out.println("Getting current state and checking whether login is Active or not");
        System.out.println("Current state : " + ctx.getState());
        System.out.println("Checking whether Login is Active or not :  "+  ctx.isActive());
        System.out.println(ctx.list);
        ctx.login(new EncryptedString("yo"));
        System.out.println(ctx.list);
        System.out.println("Checking whether Login is Active or not :  "+  ctx.isActive());
    }





}
