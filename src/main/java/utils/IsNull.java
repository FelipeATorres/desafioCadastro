package utils;

import enums.PetType;

import static enums.PetSex.FEMEA;
import static enums.PetSex.MACHO;

public class IsNull {
    private static final String NAO_INFORMADO = "Não informado";

    public static String verifyString (String stringToVerify){
        return (stringToVerify == null) ? NAO_INFORMADO : stringToVerify;
    }

    public static String verifyDouble (Double doubleToVerify){
        return (doubleToVerify <= 0) ? NAO_INFORMADO : String.format("%.1f",doubleToVerify);
    }

    public static String verifyInt (Integer intToVerify){
        return (intToVerify <= 0) ? NAO_INFORMADO : String.format("%d",intToVerify);
    }

}
