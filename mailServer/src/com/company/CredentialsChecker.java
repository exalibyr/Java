package com.company;

public class CredentialsChecker {
    public User checkUser(User[] users, String login, String password) {

        for ( User user : users ) {
            if ( login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}