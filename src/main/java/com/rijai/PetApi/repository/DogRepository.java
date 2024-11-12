package com.rijai.PetApi.repository;

import com.rijai.PetApi.model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository <Dog, Long> {
}