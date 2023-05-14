package edu.umb.cs680.hw09;

public interface State {
    EncryptedString ENCRYPTED_STRING = null;
    public State login(EncryptedString pwd);
    public State logout();
}
