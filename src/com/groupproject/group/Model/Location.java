package com.groupproject.group.Model;

/*
 * Description: This class is for holding information of which aisle, shelf, and tier (level) an item is located
 * Created: 02/11/2018
 */

public class Location {
    private int aisle;
    private int shelf;
    private int tier;

    public Location(int aisle, int shelf, int tier){
        this.aisle = aisle;
        this.shelf = shelf;
        this.tier = tier;
    }

    // aisle
    public int getAisle(){return this.aisle;}
    public void setAisle(int aisle){this.aisle = aisle;}

    // shelf
    public int getShelf(){return this.shelf;}
    public void setShelf(int shelf){this.shelf = shelf;}

    // tier
    public int getTier(){return this.tier;}
    public void setTier(int tier){this.tier = tier;}
}
