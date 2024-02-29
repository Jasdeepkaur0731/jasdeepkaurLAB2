package com.example.jasdeepkaurlab2;

public class renovation {
    public int ID;
    public String Name;
    public String Location;
    public String MobileNumber;

    public int getID() {
        return ID;
    }

    public renovation(int ID, String name, String location, String mobileNumber, double cost) {
        this.ID = ID;
        Name = name;
        Location = location;
        MobileNumber = mobileNumber;
        Cost = cost;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public double Cost;
}
