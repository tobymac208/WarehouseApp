package com.groupproject.group.Model;

/*
 * Description: This class is for holding information on a product; name, weight, price, description, volume, and even location
 * Created: 02/11/2018
 */

public class Product {
    private String name;
    private double weight; // we'll have to decide what unit this is measured in
    private double price;
    private String description;
    private Volume volume;
    private Location location;

    public Product(String name, double weight, int price, String description, Volume volume, Location location){
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.description = description;
        this.volume = volume;
        this.location = location;
    }

    // Name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    // weight
    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}


    // price
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    // description
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    // volume
    public Volume getVolume() {return volume;}
    public void setVolume(Volume volume) {this.volume = volume;}

    // location
    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}
}