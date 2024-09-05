package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("attractions")

public class TouristController {


    private TouristService ts;

    public TouristController(TouristService ts){
        this.ts = ts;
    }

    @GetMapping //denne get Endpoint hentes, når der bare skrives /attractions i browseren
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> getAllAttractions = ts.getListOfAttraction();
        return new ResponseEntity<>(getAllAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}") //denne get Endpoint hentes, når der angives et name i browseren fx welcome/hærvejen
    public ResponseEntity<String> getDescriptionByName(@PathVariable String name){
        return new ResponseEntity<String>(ts.getDescription(name),HttpStatus.OK);
    }



}
