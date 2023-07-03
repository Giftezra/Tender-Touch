package com.example.tendertouch;

import kotlin.text.UStringsKt;

/**
 * Description of Users
 * <p>
 * Auto-generated class for XML file: Users
 */
public class Users {
    private String countryName;
    private int distance;
    private int diameter;
    private int gravity;

    public Users(String country, int distance, int diameter, int gravity){
        this.diameter = diameter;
        this.countryName = country;
        this.distance = distance;
        this.gravity = gravity;
    }

    public String getCountryName () {
        return countryName;
    }

    public int getDistance () {
        return distance;
    }

    public int getDiameter () {
        return diameter;
    }

    public int getGravity () {
        return gravity;
    }
}