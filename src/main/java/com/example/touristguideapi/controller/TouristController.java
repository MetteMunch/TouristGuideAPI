package com.example.touristguideapi.controller;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("attractions")

public class TouristController {


    private TouristService ts;

    public TouristController(TouristService ts){
        this.ts = ts;
    }

    @GetMapping //denne get Endpoint hentes og metoden køres, når der bare skrives /attractions i browseren
    public ResponseEntity<List<TouristAttraction>> getAllAttractions(){
        List<TouristAttraction> getAllAttractions = ts.getListOfAttraction();
        return new ResponseEntity<>(getAllAttractions, HttpStatus.OK);
    }

    @GetMapping("/{name}") //denne get Endpoint hentes og metoden køres, når der angives et name i browseren fx attractions/hærvejen
    public ResponseEntity<String> getDescriptionByName(@PathVariable String name){
        return new ResponseEntity<String>(ts.getDescription(name),HttpStatus.OK);
    }
    @PostMapping("/add") //denne post Endpoint hentes og metoden køres, når der skrives attractions/add i browseren
    public ResponseEntity<Void> addAttraction(@RequestParam String name, @RequestParam String description){
        ts.addAttraction(name,description);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/update") //denne post Endpoint hentes og metoden køres, når der skrives attractions/update
    public ResponseEntity<Void> updateAttraction(@RequestParam String name, @RequestParam String description){
        ts.updateAttraction(name, description);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete") //denne post Endpoint hentes og metoden køres, når der skrives attractions/delete
    public ResponseEntity<Void> deleteAttraction(@RequestParam String name){
        ts.deleteAttraction(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
