package services;

import exceptions.DomainException;
import utils.Capitalizar;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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

    public static void criterios(Scanner sc, List<Path> arquivosEncontrados)
            throws IOException, DomainException {
        System.out.print("Primeiramente, qual o tipo do seu pet (Cachorro/Gato)? ");
        String tipoEscolhido = Capitalizar.strings(sc.nextLine());
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
        System.out.print(Capitalizar.strings(criterio1) + ": ");
        String escolha1 = Capitalizar.strings(sc.nextLine());
        String escolha2 = "";
        if(!criterio2.isEmpty()){
            System.out.print(Capitalizar.strings(criterio2) + ": ");
            escolha2 = Capitalizar.strings(sc.nextLine());
        }
        buscar(tipoEscolhido,criterio1, escolha1, criterio2, escolha2, arquivosEncontrados);
    }

    public static void buscar(String tipoEscolhido, String criterio1, String escolha1,
                              String criterio2, String escolha2, List<Path> arquivosEncontrados)
            throws IOException, DomainException {
        int numPetsEncontrados = 0;

        try (DirectoryStream<Path> arquivos = Files.newDirectoryStream(Path.of(pastaPets))) {

            for (Path arquivo : arquivos) {
                List<String> linhas = Files.readAllLines(arquivo);

                boolean temTipo = false;
                boolean temCriterio1 = false;
                boolean temCriterio2 = criterio2.isEmpty();
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

                /// verifica se o tipo do animal escolhido está presente.
                temTipo = tipoEscolhido.equalsIgnoreCase(tipoPet);

                /// verifica se o critério 1 é atendido.
                temCriterio1 = switch (criterio1.toLowerCase()) {
                    case "nome" -> nomePet.contains(escolha1);
                    case "sexo" -> sexoPet.contains(escolha1);
                    case "endereço" -> enderecoPet.contains(escolha1);
                    case "idade" -> idadePet.contains(escolha1);
                    case "peso" -> pesoPet.contains(escolha1);
                    case "raça" -> racaPet.contains(escolha1);
                    default -> false;
                };

                /// verifica se o critério 2 é atendido.
                if (!criterio2.isEmpty()) {
                    temCriterio2 = switch (criterio2) {
                        case "nome" -> nomePet.contains(escolha2);
                        case "sexo" -> sexoPet.contains(escolha2);
                        case "endereço" -> enderecoPet.contains(escolha2);
                        case "idade" -> idadePet.contains(escolha2);
                        case "peso" -> pesoPet.contains(escolha2);
                        case "raça" -> racaPet.contains(escolha2);
                        default -> false;
                    };
                }

                /// Se for encontrado algum pet, ele lança uma saida com as respectivas informações.
                if(temTipo && temCriterio1 && temCriterio2) {
                    if (numPetsEncontrados == 0)
                        System.out.println("\nLISTA DE PETS ENCONTRADOS");
                    numPetsEncontrados++;
                    arquivosEncontrados.add(arquivo);
                    String petEncontrado = String.format("%d. %s - %s - %s - %s - %s - %s - %s",
                            numPetsEncontrados,nomePet,tipoPet,sexoPet,enderecoPet,idadePet,pesoPet,racaPet);
                    System.out.println(petEncontrado);
                }

            }
            /// Caso não encontre nenhum pet com esses critérios, lança uma saida dizendo que não foi encontrado.
            if (numPetsEncontrados == 0) {
                throw new DomainException("Nenhum pet encontrado com base nos critérios digitados.");
            }
        }

        catch (IOException e){
            throw new DomainException("IOException");
        }
    }
}