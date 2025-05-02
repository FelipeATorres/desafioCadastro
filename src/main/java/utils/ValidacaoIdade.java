package utils;

import exceptions.DomainException;

public class ValidacaoIdade {
    public static void verificar(double idade) throws DomainException {
        if (idade > 20) {
            throw new DomainException("Não é possivel cadastrar uma idade maior que 20 anos.");
        }
    }
}
