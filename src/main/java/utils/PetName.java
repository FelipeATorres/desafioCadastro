package utils;

import exceptions.DomainException;

public class PetName {
    public static void verify(String petName) throws DomainException {
        String[] nameList = petName.split(" ");
        if (nameList.length < 2){
            throw new DomainException("É necessário digitar nome e sobrenome do pet.");
        }
        if (!petName.matches("[a-zA-ZáéíóúÁÉÍÓÚãõâêîôûàèìòùçÇ\\s]+")){
            throw new DomainException("O nome do pet não pode conter números ou caracteres especiais!");
        }
    }
}
