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
    private boolean isAdmin; // specifies if the user has admin access
    // TODO: Add tiers (lower-level and mid-level)

    public Account(String firstName, String lastName, String username, String password, int age, boolean isAdmin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.age = age;
        this.isAdmin = isAdmin;
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
    public void setAdmin(boolean admin) {isAdmin = admin;}
}
