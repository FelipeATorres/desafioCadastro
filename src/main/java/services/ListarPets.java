package services;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ListarPets {
    public static void listar(){
        try (DirectoryStream<Path> arquivos =
                     Files.newDirectoryStream(Path.of("src/main/java/arquivos/petsCadastrados"))) {
            int numPetsEncontrados = 0;

            System.out.println("\nLISTA DE PETS");
            for (Path arquivo : arquivos) {
                List<String> linhas = Files.readAllLines(arquivo);
                String tipoPet = "", nomePet = "", sexoPet = "", enderecoPet = "",
                        idadePet = "", pesoPet = "", racaPet = "";

                /// Seta cada linha para sua respectiva variável.
                for (String linha : linhas){
                    if (linha.startsWith("1"))
                        nomePet = linha.substring(4).trim();
                    if (linha.startsWith("2"))
                        tipoPet = linha.substring(4).trim();
                    if (linha.startsWith("3"))
                        sexoPet = linha.substring(4).trim();
                    if (linha.startsWith("4"))
                        enderecoPet = linha.substring(4).trim();
                    if (linha.startsWith("5"))
                        idadePet = linha.substring(4).trim();
                    if (linha.startsWith("6"))
                        pesoPet = linha.substring(4).trim();
                    if (linha.startsWith("7"))
                        racaPet = linha.substring(4).trim();
                }

                numPetsEncontrados++;
                String petEncontrado = String.format("%d. %s - %s - %s - %s - %s - %s - %s",
                        numPetsEncontrados, nomePet, tipoPet, sexoPet, enderecoPet, idadePet, pesoPet, racaPet);
                System.out.println(petEncontrado);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
