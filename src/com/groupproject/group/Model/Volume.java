package com.groupproject.group.Model;

/*
 * Description: This class is for holding information on what the volume of an item is
 * Created: 02/11/2018
 */

public class Volume {
    private double length;
    private double depth;
    private double height;

    public Volume(double length, double depth, double height){
        this.length = length;
        this.depth = depth;
        this.height = height;
    }

    // length
    public double getLength(){return this.length;}
    public void setLength(double length){this.length = length;}

    // depth
    public double getDepth(){return this.depth;}
    public void setDepth(double depth){this.depth = depth;}

    // height
    public double getHeight(){return this.height;}
    public void setHeight(double height){this.height = height;}

    // TODO: Add functionality for calculating and getting the volumetric size of the item
}
