package entities;

import enums.PetSex;
import enums.PetType;

public class Pet {
    private String name;
    private PetType petType;
    private PetSex petSex;
    private String address;
    private Double age;
    private Double weight;
    private String breed;

    private static final String NAO_INFORMADO = "Não informado";

    public Pet(){
    }

    public Pet(String name, PetType petType, PetSex petSex, String address, Double age, Double weight, String breed) {
        this.name = name;
        this.petType = petType;
        this.petSex = petSex;
        this.address = address;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetSex getPetSex() {
        return petSex;
    }

    public void setPetSex(PetSex petSex) {
        this.petSex = petSex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
