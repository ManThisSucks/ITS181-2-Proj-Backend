package com.rijai.PetApi.service;

import com.rijai.PetApi.model.Dog;

import java.util.List;

public interface IDogService {
    List<Dog> findAll();

    Dog getDog(int id);

    Dog addDog(Dog dog);

    Dog updateDog(Dog dog);

    void deleteDog(int id);

    Dog reserveDog(int id);

    Dog unreserveDog(int id);

    List<Dog> addDogs(List<Dog> dogs);
}