package edu.umb.cs680.hw05;

public interface State {
    EncryptedString ENCRYPTED_STRING = null;
    public State login(EncryptedString pwd);
    public State logout();
}
