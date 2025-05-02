package utils;

import exceptions.DomainException;

public class StringCaracterSpecial {
    public static void verificar(String string) throws DomainException {
        if (!string.matches("[a-zA-ZáéíóúÁÉÍÓÚãõâêîôûàèìòùçÇ\\s]+")) {
            throw new DomainException("Não é possivel digitar números ou caracteres especiais!");
        }
    }
}
