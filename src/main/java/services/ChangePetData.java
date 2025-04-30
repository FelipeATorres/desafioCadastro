package services;

import entities.Pet;

import java.util.Scanner;

public class ChangePetData {
    public static void setPetData(Scanner sc, int i, Pet pet){
        switch (i){
            case 1:
                sc.nextLine();
                String petName = sc.nextLine();
                pet.setName(petName);
                break;
            case 2:
                String petType = sc.nextLine();
                pet.setType(petType);
                break;
            case 3:
                String petSex = sc.nextLine();
                pet.setSex(petSex);
                break;
            case 4:
                String petAddress = sc.nextLine();
                pet.setAddress(petAddress);
                break;
            case 5:
                int petAge = sc.nextInt();
                sc.nextLine();
                pet.setAge(petAge);
                break;
            case 6:
                double petWeight = sc.nextDouble();
                sc.nextLine();
                pet.setWeight(petWeight);
                break;
            case 7:
                String petBreed = sc.nextLine();
                pet.setBreed(petBreed);
                break;
        }
    }
}
