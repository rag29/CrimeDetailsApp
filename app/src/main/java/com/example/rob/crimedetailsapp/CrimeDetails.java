package com.example.rob.crimedetailsapp;

public class CrimeDetails {
    String date;
    String location;
    String category;
    String outcome;
    String dateOfOutcome;

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getDateOfOutcome() {
        return dateOfOutcome;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public void setDateOfOutcome(String dateOfOutcome) {
        this.dateOfOutcome = dateOfOutcome;
    }
}
