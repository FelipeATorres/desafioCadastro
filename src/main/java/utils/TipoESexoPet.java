package utils;

import enums.SexoPet;
import enums.TipoPet;

import static enums.SexoPet.MACHO;

public class TipoESexoPet {
    public static String verificarTipo(TipoPet type){
        return (type.equals(TipoPet.CACHORRO)) ? "Cachorro" : "Gato";
    }

    public static String verificarSexo(SexoPet sex){
        return (sex.equals(MACHO)) ? "Macho" : "Femea";
    }
}
