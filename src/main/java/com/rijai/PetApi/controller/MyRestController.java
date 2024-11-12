package com.rijai.PetApi.controller;

import com.rijai.PetApi.model.Dog;
import com.rijai.PetApi.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        return allDogs.stream()
                .filter(Dog::isAvailable)
                .collect(Collectors.toList());
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
    @RequestMapping(value = "/api/add-dogs", method = RequestMethod.POST)
    public List<Dog> addDogs(@RequestBody List<Dog> dogs) {
        return dogService.addDogs(dogs);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/api/update-dog/{id}", method=RequestMethod.PUT)
    public Dog updateDog(@PathVariable int id, @RequestBody Dog dog) {
        return dogService.updateDog(id, dog);
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
