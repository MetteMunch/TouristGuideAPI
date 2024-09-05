package com.example.touristguideapi.model;

public class TouristAttraction {

    private String name;
    private String description;

    public TouristAttraction(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }




    @Override
    public String toString(){
        return name + description;
    }
}
