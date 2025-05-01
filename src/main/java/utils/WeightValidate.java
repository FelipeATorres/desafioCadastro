package utils;

import exceptions.DomainException;

public class WeightValidate {
    public static void verify(double weight) throws DomainException {
        if (weight < 0.5 || weight > 60){
            throw new DomainException("O peso do pet deve estar de 60kg à 0.5kg");
        }
    }
}
