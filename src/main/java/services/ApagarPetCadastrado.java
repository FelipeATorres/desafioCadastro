package services;

import exceptions.DomainException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ApagarPetCadastrado {
    public static void apagar(Scanner sc, List<Path> arquivosEncontrados) throws DomainException {
        try{
            System.out.print("\nDigite o número do pet que deseja apagar o registro: ");
            int numPet = sc.nextInt();
            sc.nextLine();

            Path arquivoEscolhido = arquivosEncontrados.get(numPet-1);

            System.out.print("Você tem certeza que deseja apagar esse cadastro (Sim/Não)? ");
            String confirmarEscolha = sc.nextLine().toLowerCase().trim();

            if (confirmarEscolha.equals("sim")) {
                Files.delete(arquivoEscolhido);
                System.out.println("Cadastro apagado com sucesso!");
            }
            else {
                System.out.println("Exclusão do cadastro cancelada!");
            }

        } catch (IOException e) {
            throw new DomainException("IOException");
        }
    }
}
