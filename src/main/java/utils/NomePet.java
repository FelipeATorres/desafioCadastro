package utils;

import exceptions.DomainException;

public class NomePet {
    public static void verificar(String nomePet) throws DomainException {
        String[] listaNome = nomePet.split(" ");
        if (listaNome.length < 2){
            throw new DomainException("É necessário digitar nome e sobrenome do pet.");
        }

        StringCaracterSpecial.verificar(nomePet);
    }
}
