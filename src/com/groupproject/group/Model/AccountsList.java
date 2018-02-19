package com.groupproject.group.Model;

/*
 * Description: This is a class for holding multiple accounts at a time
 * Created: 02/11/2018
 * Author: Nik
 */

import java.util.ArrayList;

public class AccountsList {
    private ArrayList<Account> accounts;
    // A variable for tracking how man accounts their are
    private static int numberAccounts = 0;
    // A variable to set the maximum number of accounts
    private static final int MAX_ACCOUNTS = 10;
    private static final int MAX_ADMINS = 1;
    private static final int MAX_TIER_TWO = 4;
    private static final int MAX_TIER_THREE = 5;

    public AccountsList() {
        this.accounts = new ArrayList<>();
    }

    // getter
    public ArrayList<Account> getAccounts() {return accounts;}

    // Methods
    /** Allows someone to add to this collection of Account objects */
    public void addAccount(String username, String password, String firstname, String lastName, int age, int tier){
        if( findByUsername(username) == null  && (numberAccounts != MAX_ACCOUNTS) ){ // if the list isn't empty and an Account with that name doesn't exist yet, and the MAX hasn't been reached
            // checks which tier and sees if the max has been reached
            if( (((tier == 1) && (findByTier(tier) < MAX_ADMINS))) || (((tier == 2) && (findByTier(tier) < MAX_TIER_TWO))) || (((tier == 3) && (findByTier(tier) < MAX_TIER_THREE))) ){ // if not maxes have been reached, create account
                numberAccounts++;
                accounts.add(new Account(firstname, lastName, username, password, age, tier));
            }
            else{ // otherwise, don't create the account
                System.out.println("Account couldn't be created. Some max value has been reached.");
            }
        }
        else{
            System.out.println("Account couldn't be created!");
        }
    }

    /** Allows someone to add to this collection of Account objects */
    public void addAccount(Account newAccount){
        // simply passes all fields from newAccount to the other method
        addAccount(newAccount.getUsername(), newAccount.getPassword(), newAccount.getFirstName(), newAccount.getLastName(), newAccount.getAge(), newAccount.getTier());
    }

    /** A method that checks if there are any users with that username yet, if there are return nothing */
    public Account findByUsername(String username){
        if(accounts.isEmpty()) // there is nothing in the list yet
            return null; // return null
        for(Account account : accounts){ // for-each loop that will go through each Account object and check their name
            if(account.getUsername().equals(username)) // if the usernames match
                return account; // return the account
        }
        // found nothing, return null
        return null;
    }

    /** Private method that checks how many accounts are assigned to each tier
     * Author: Nik */
    private int findByTier(int tier){
        int numberOfAccounts = 0;
        if(tier == 1){
            for(Account account : accounts){
                if(account.getTier() == 1)
                    numberOfAccounts++; // add 1 to the number of accounts counts for admins
            } // end of for
        } // end of if
        else if(tier  == 2){
            for (Account account : accounts){
                if(account.getTier() == 2)
                    numberOfAccounts++; // add 1 to the number of accounts count for tier two workers
            } // end of for
        } // end of else-if
        else if(tier == 3){
            for (Account account : accounts){
                if (account.getTier() == 3)
                    numberOfAccounts++; // add 1 to the number of accounts count for tier three workers
            }
        }
        // return the count
        return numberOfAccounts;
    }
}
