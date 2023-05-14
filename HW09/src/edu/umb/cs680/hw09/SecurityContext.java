package edu.umb.cs680.hw09;

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
        state= LoggedOut.getLoggedOutInstance(this);
    }

    public void ChangeState(State newState){
        state=newState;
    }


    public boolean userloginfreq(){
        boolean res;
        if(list.size()==1){
            res=true;}
        else{
            res=false;
        }
        return res;
    }

    public void logout(){
        state.logout();
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

    }
}
