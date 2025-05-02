package services;

import utils.Capitalizar;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.newDirectoryStream;

public class ProcurarPetInfo {
    public static final String pastaPets = "src/main/java/arquivos/petsCadastrados";

    public static void menu(){
        System.out.println(
                "\nCRITÉRIOS DE BUSCA\n" +
                "1. Nome ou sobrenome\n" +
                "2. Sexo\n" +
                "3. Idade\n" +
                "4. Peso\n" +
                "5. Raça\n" +
                "6. Endereço\n");
    }

    public static void criterios(Scanner sc) throws IOException {
        System.out.print("Qual o critério de busca? ");
        String criterio1 = sc.nextLine();
        System.out.print("Deseja adicionar outro critério à busca? ");
        String adicionarEscolha = sc.nextLine().toLowerCase().trim();
        String criterio2= "";
        if (adicionarEscolha.equals("sim")) {
            System.out.print("Qual o segundo critério de busca? ");
            criterio2 = sc.nextLine();
        }

        System.out.println("Digite as informações de busca: ");
        System.out.print("Tipo: ");
        String escolha1 = Capitalizar.strings(sc.nextLine());
        System.out.print(Capitalizar.strings(criterio1) + ": ");
        String escolha2 = Capitalizar.strings(sc.nextLine());
        String escolha3 = "";
        if(!criterio2.isEmpty()){
            System.out.print(Capitalizar.strings(criterio2) + ": ");
            escolha3 = Capitalizar.strings(sc.nextLine());
        }
        buscar(escolha1, escolha2, escolha3);
    }

    public static void buscar(String escolha1, String escolha2, String escolha3) throws IOException {

        try (DirectoryStream<Path> arquivos = Files.newDirectoryStream(Path.of(pastaPets))) {
            for (Path arquivo : arquivos) {
                List<String> linhas = Files.readAllLines(arquivo);
                System.out.println(linhas);
            }
        }

    }
}
