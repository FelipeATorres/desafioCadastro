package utils;

import exceptions.DomainException;

public class ValidacaoPeso {
    public static void verificar(double peso) throws DomainException {
        if (peso < 0.5 || peso > 60){
            throw new DomainException("O peso do pet deve estar de 60kg à 0.5kg");
        }
    }
}
