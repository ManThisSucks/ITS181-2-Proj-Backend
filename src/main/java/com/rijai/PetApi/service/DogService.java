package com.rijai.PetApi.service;

import com.rijai.PetApi.model.Dog;
import com.rijai.PetApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Dog updateDog(Dog dog) {
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
            dog.get().setAvailable(false);
            return dog.get();
        }
        return null;
    }

    public Dog unreserveDog(int id) {
        Optional<Dog> dog = dogRepository.findById((long) id);
        if(dog.isPresent()) {
            dog.get().setAvailable(true);
            return dog.get();
        }
        return null;
    }
}
