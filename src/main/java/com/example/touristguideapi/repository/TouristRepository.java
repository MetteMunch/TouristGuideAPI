package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class TouristRepository {

    private List<TouristAttraction> listOfAttractions;

    public TouristRepository(){
        listOfAttractions = new ArrayList<>();
        hardCodedAddingToList();
    }

    public void hardCodedAddingToList(){
        listOfAttractions.add(new TouristAttraction("Bornholms Kyststi", "Bornholms kyststi (ca. 115 km). Du kommer gennem både større og mindre byer på Bornholm, men det meste af turen foregår i uforstyrret natur med en utrolig flot udsigt."));
        listOfAttractions.add(new TouristAttraction("Hærvejen", "Hærvejen (ca. 280 km). Hærvejen er en historisk rute, som snor sig op gennem Jylland fra Padborg til Viborg, og ruten byder på nogle af Jyllands flotteste landskaber."));
    }

    public String getDescription(String name){
        String result = "";
        for (TouristAttraction t:listOfAttractions){
            if(name.equalsIgnoreCase(t.getName())){
                result = t.getDescription();
            }
        }
        return result;
    }

    public void addAttraction(String name, String description){
        listOfAttractions.add(new TouristAttraction(name, description));
    }


    public void deleteAttraction(String name){
        for (TouristAttraction t:listOfAttractions){
            if(name.equalsIgnoreCase(t.getName())){
                listOfAttractions.remove(t);
            }
        }

    }

    public List<TouristAttraction> getListOfAttractions(){
        return listOfAttractions;
    }

}
