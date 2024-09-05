package com.example.touristguideapi.service;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TouristService {


    private TouristRepository tr;

    public TouristService(TouristRepository tr){
        this.tr = tr;
    }

    public String getDescription(String name){
        return tr.getDescription(name);
    }

    public void addAttraction(String name, String description){
        tr.addAttraction(name,description);
    }

    public void deleteAttraction(String name){
        tr.deleteAttraction(name);
    }

    public List<TouristAttraction> getListOfAttraction(){
        return tr.getListOfAttractions();
    }


}
