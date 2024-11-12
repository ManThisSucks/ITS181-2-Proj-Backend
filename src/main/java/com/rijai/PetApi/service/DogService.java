package com.rijai.PetApi.service;

import com.rijai.PetApi.model.Dog;
import com.rijai.PetApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService implements IDogService {
    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> findAll() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public Dog getDog(int id) {
        Optional<Dog> dog = dogRepository.findById((long) id);
        return dog.orElse(null);
    }

    @Override
    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Dog updateDog(int id, Dog dog) {
        dog.setId(id);
        return dogRepository.save(dog);
    }

    @Override
    public void deleteDog(int id) {
        Optional<Dog> dog = dogRepository.findById((long) id);
        if(dog.isPresent()) {
            dogRepository.delete(dog.get());
        }
    }

    @Override
    public Dog reserveDog(int id) {
        Optional<Dog> dog = dogRepository.findById((long) id);
        if(dog.isPresent()) {
            Dog newDog = dog.get();
            newDog.setAvailable(false);
            return dogRepository.save(newDog);
        }
        return null;
    }

    public Dog unreserveDog(int id) {
        Optional<Dog> dog = dogRepository.findById((long) id);
        if(dog.isPresent()) {
            Dog newDog = dog.get();
            newDog.setAvailable(true);
            return dogRepository.save(newDog);
        }
        return null;
    }

    @Override
    public List<Dog> addDogs(List<Dog> dogs) {
        List<Dog> addedDogs = new ArrayList<>();
        for (Dog dog : dogs) {
            addedDogs.add(addDog(dog));
        }
        return addedDogs;
    }
}
