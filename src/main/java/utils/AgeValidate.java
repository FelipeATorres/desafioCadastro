package utils;

import exceptions.DomainException;

public class AgeValidate {
    public static void verify(double age) throws DomainException {
        if (age > 20) {
            throw new DomainException("Não é possivel cadastrar uma idade maior que 20 anos.");
        }
    }
}
