package com.groupproject.group.Model;

/*
 * Description: This is a class for holding multiple accounts at a time
 * Created: 02/11/2018
 */

import java.util.ArrayList;

public class AccountsList {
    private ArrayList<Account> accounts;
    // A variable for tracking how man accounts their are
    private static int numberAccounts = 0;
    // A variable to set the maximum number of accounts
    private static final int MAX_ACCOUNTS = 10;

    public AccountsList() {
        this.accounts = new ArrayList<>();
    }

    // getter
    public ArrayList<Account> getAccounts() {return accounts;}

    // Methods
    /** Allows someone to add to this collection of Account objects */
    public void addAccount(String username, String password, String firstname, String lastName, int age, boolean isAdmin, int tier){
        if( findByUsername(username) == null  && (numberAccounts != MAX_ACCOUNTS) ){ // if the list isn't empty and an Account with that name doesn't exist yet, and the MAX hasn't been reached
            // add 1 to the numberOfAccounts
            numberAccounts++;
            accounts.add(new Account(firstname, lastName, username, password, age, isAdmin, tier)); // creates a new Account and adds it to the list
        }
        else{
            System.out.println("Account couldn't be created!");
        }
    }

    /** Allows someone to add to this collection of Account objects */
    public void addAccount(Account newAccount){
        // simply passes all fields from newAccount to the other method
        addAccount(newAccount.getUsername(), newAccount.getPassword(), newAccount.getFirstName(), newAccount.getLastName(), newAccount.getAge(), newAccount.isAdmin(), newAccount.getTier());
    }

    /** A method that checks if there are any users with that username yet, if there are return nothing */
    private Account findByUsername(String username){
        if(accounts.isEmpty()) // there is nothing in the list yet
            return null; // return null
        for(Account account : accounts){ // for-each loop that will go through each Account object and check their name
            if(account.getUsername().equals(username)) // if the usernames match
                return account; // return the account
        }
        // found nothing, return null
        return null;
    }
}
