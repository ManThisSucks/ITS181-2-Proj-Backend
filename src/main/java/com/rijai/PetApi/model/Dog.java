package com.rijai.PetApi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String breed;
    private int age;
    private String description;
    private boolean isAvailable;
    private String imageFilePath;

    public Dog() {
    }

    public Dog(long id, String name, String breed, int age, String description, boolean isAvailable, String imageFilePath) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.isAvailable = isAvailable;
        this.imageFilePath = imageFilePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String language) {
        this.breed = language;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String status) {
        this.description = status;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && age == dog.age && isAvailable == dog.isAvailable && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed) && Objects.equals(description, dog.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed, age, description, isAvailable);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", status='" + description + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}