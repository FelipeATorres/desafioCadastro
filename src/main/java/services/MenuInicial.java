package services;

import entities.Pet;
import exceptions.DomainException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuInicial {
    public static void print(){
        System.out.println(
                "\nMENU INICIAL\n" +
                "1. Cadastrar um novo pet\n" +
                "2. Alterar os dados do pet cadastrado\n" +
                "3. Deletar um pet cadastrado\n" +
                "4. Listar todos os pets cadastrados\n" +
                "5. Listar pets por algum critério (idade, nome, raça)\n" +
                "6. Sair\n");
    }

    public static int escolhaMenu(Scanner sc, Path form, int escolha) throws DomainException {
        try {
            System.out.print("Digite uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    Pet pet = new Pet();
                    InfoFormulario.lerForm(sc,form,pet);
                    SalvarInformacoesPet.save(pet);
                    break;
                case 2:
                    List<Path> arquivosEncontrados = new ArrayList<>();
                    ProcurarPetInfo.menu();
                    ProcurarPetInfo.criterios(sc, arquivosEncontrados);
                    AlterarDadosPet.escolherDadosAlterar(sc, arquivosEncontrados);
                    break;
                case 3:
                    List<Path> arquivosEncont = new ArrayList<>();
                    ProcurarPetInfo.menu();
                    ProcurarPetInfo.criterios(sc, arquivosEncont);
                    ApagarPetCadastrado.apagar(sc, arquivosEncont);
                    break;
                case 4:
                    ListarPets.listar();
                    break;
                case 5:
                    List<Path> arquivosEncon = new ArrayList<>();
                    ProcurarPetInfo.menu();
                    ProcurarPetInfo.criterios(sc, arquivosEncon);
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    break;
            }
            if (escolha <= 0)
                throw new DomainException("Não é possível digitar um número 0 ou negativo.");
            if (escolha > 6)
                throw new DomainException(("Por favor digite apenas um número dentre as opções."));
        }
        catch (NoSuchElementException | IOException e){
            sc.nextLine();
            throw new DomainException("Digite um número válido!");
        }
        return escolha;
    }
}
