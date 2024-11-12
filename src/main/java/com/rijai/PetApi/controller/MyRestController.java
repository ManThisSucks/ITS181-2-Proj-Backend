package com.rijai.PetApi.controller;

import com.rijai.PetApi.model.Dog;
import com.rijai.PetApi.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private IDogService dogService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/api/dogs/all")
    public List<Dog> getAllDogs() {
        return dogService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/api/dogs/available")
    public List<Dog> getAvailableDogs() {
        List<Dog> allDogs = dogService.findAll();
        return null; // TODO: only return dogs where dog.isAvailable == true
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api/dog/{id}", method=RequestMethod.GET)
    public Dog getDog(@PathVariable int id) {
        return dogService.getDog(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api/dog/{id}", method=RequestMethod.DELETE)
    public void deleteDog(@PathVariable int id) {
        dogService.deleteDog(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api/add-dog", method=RequestMethod.POST)
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api/update-dog", method=RequestMethod.PUT)
    public Dog updateDog(@RequestBody Dog dog) {
        return dogService.updateDog(dog);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api/reserve-dog/{id}", method=RequestMethod.GET)
    public Dog reserveDog(@PathVariable int id) {
        return dogService.reserveDog(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api/unreserve-dog/{id}", method=RequestMethod.GET)
    public Dog unreserveDog(@PathVariable int id) {
        return dogService.unreserveDog(id);
    }
}
