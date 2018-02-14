package com.groupproject.group.Model;

/*
 * Description: This class is for holding information on Account information for a user; name, password, age, and if they are an admin or not
 * Created: 02/11/2018
 */

public class Account {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private boolean isAdmin; // specifies if the user has admin access -- is immutable
    // TODO: Add tiers (lower-level and mid-level)
    private int tier; // is immutable -- can't change after object is created
    // enum for deciding with tier to use -- public to allow a user to choose when creating the object of Account
    public enum TIER{FIRST_LEVEL, SECOND_LEVEL}; // allows the user to choose from either tier

    public Account(String firstName, String lastName, String username, String password, int age, boolean isAdmin, int tier){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.age = age;
        this.isAdmin = isAdmin;
        this.tier = tier;
    }

    // first name
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    // last name
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    // username
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    // password
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    // age
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    // isAdmin
    public boolean isAdmin() {return isAdmin;}

    // tier
    public int getTier(){return tier;}

    // toString()
    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName + "\n"
                + "Username: " + username + "\n"
                + "Age: " + age + "\n"
                + "Is admin? " + isAdmin + "\n"
                + "Which tier? " + tier + "\n";
    }
}
