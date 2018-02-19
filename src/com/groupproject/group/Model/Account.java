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
    // TODO: Add tiers (lower-level and mid-level)
    private int tier; // is immutable -- can't change after object is created
    // values for deciding with tier to use -- public to allow a user to choose when creating the object of Account
    public static final int ADMIN_LEVEL = 1, SECOND_LEVEL = 2, THIRD_LEVEL = 3;

    public Account(String firstName, String lastName, String username, String password, int age, int tier){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.age = age;
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

    // tier
    public int getTier(){return tier;}

    // toString()
    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName + "\n"
                + "Username: " + username + "\n"
                + "Age: " + age + "\n"
                + "Which tier? " + tier + "\n";
    }
}
