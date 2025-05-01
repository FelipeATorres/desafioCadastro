package utils;

import enums.PetSex;
import enums.PetType;

import static enums.PetSex.MACHO;

public class PetTypeAndSex {
    public static String verifyType (PetType type){
        return (type.equals(PetType.CACHORRO)) ? "Cachorro" : "Gato";
    }

    public static String verifySex (PetSex sex){
        return (sex.equals(MACHO)) ? "Macho" : "Femea";
    }
}
