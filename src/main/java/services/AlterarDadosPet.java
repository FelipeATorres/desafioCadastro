package services;

import exceptions.DomainException;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AlterarDadosPet {
    public static void escolherDadosAlterar(Scanner sc, List<Path> arquivosEncontrados) throws DomainException {
        try {
            System.out.print("\nDigite o número do pet que deseja alterar alguma informação: ");
            int numPet = sc.nextInt();
            sc.nextLine();
            int sair = 0;
            Path arquivoParaEditar = arquivosEncontrados.get(numPet-1);

            while (sair != 6) {
                List<String> conteudoAntigo = Files.readAllLines(arquivoParaEditar);
                System.out.println(
                        "\nMENU DE ALTERAÇÕES\n" +
                                "1. Nome ou sobrenome\n" +
                                "2. Idade\n" +
                                "3. Peso\n" +
                                "4. Raça\n" +
                                "5. Endereço\n" +
                                "6. Sair\n");

                System.out.print("Qual opção deseja? ");
                String escolhaAlterar = sc.nextLine();
                int numeroLinha;
                String linhaAntiga;

                switch (escolhaAlterar.toLowerCase().trim()){
                    case "nome":
                        numeroLinha = 0;
                        System.out.print("Novo nome: ");
                        String nome = sc.nextLine().trim();
                        NomePet.verificar(nome);
                        nome = Capitalizar.strings(nome);
                        linhaAntiga = conteudoAntigo.get(numeroLinha);
                        modificarLinhaArquivo(arquivoParaEditar, numeroLinha,linhaAntiga, String.format("1 - %s",nome));
                        break;
                    case "idade":
                        numeroLinha = 4;
                        System.out.print("Nova idade: ");
                        double idade = sc.nextDouble();
                        sc.nextLine();
                        ValidacaoIdade.verificar(idade);
                        linhaAntiga = conteudoAntigo.get(numeroLinha);
                        modificarLinhaArquivo(arquivoParaEditar, numeroLinha,linhaAntiga, String.format("5 - %.1f anos",idade));
                        break;
                    case "peso":
                        numeroLinha = 5;
                        System.out.print("Novo peso: ");
                        double peso = sc.nextDouble();
                        sc.nextLine();
                        ValidacaoPeso.verificar(peso);
                        linhaAntiga = conteudoAntigo.get(numeroLinha);
                        modificarLinhaArquivo(arquivoParaEditar, numeroLinha,linhaAntiga, String.format("6 - %.1f kg",peso));
                        break;
                    case "raça":
                        numeroLinha = 6;
                        System.out.print("Nova raça: ");
                        String raca= sc.nextLine();
                        StringCaracterSpecial.verificar(raca);
                        raca = Capitalizar.strings(raca);
                        linhaAntiga = conteudoAntigo.get(numeroLinha);
                        modificarLinhaArquivo(arquivoParaEditar, numeroLinha,linhaAntiga, String.format("7 - %s",raca));
                        break;
                    case "endereço":
                        numeroLinha = 3;
                        System.out.println("Novo endereço: ");
                        System.out.print("I. Número da casa: ");
                        int numCasa = sc.nextInt();
                        sc.nextLine();
                        System.out.print("II. Cidade: ");
                        String cidade = sc.nextLine();
                        System.out.print("III. Rua: ");
                        String rua = sc.nextLine();
                        String endereco = "";
                        endereco = endereco.concat(rua + ", " + ENulo.verificarInt(numCasa) + ", " + cidade);
                        linhaAntiga = conteudoAntigo.get(numeroLinha);
                        modificarLinhaArquivo(arquivoParaEditar, numeroLinha,linhaAntiga, String.format("4 - %s",endereco));
                        break;
                    default:
                        sair = 6;
                        break;
                }
            }
        }
        catch (InputMismatchException | IOException e){
            throw new DomainException("IOException");
        }
    }
    public static void modificarLinhaArquivo(Path arquivoParaEditar, int numeroLinha,String linhaAntiga,
                                             String novoConteudo) throws IOException, DomainException {
        try {
            String conteudo = new String(Files.readAllBytes(arquivoParaEditar));
            String conteudoEditado = conteudo.replace(linhaAntiga,novoConteudo);
            Files.write(arquivoParaEditar, conteudoEditado.getBytes());
            System.out.println("\nSucesso ao editar o cadastro do pet!");
        }
        catch (IOException e) {
            throw new DomainException("IOException");
        }
    }
}
