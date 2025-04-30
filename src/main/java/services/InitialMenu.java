package services;

import entities.Pet;
import exceptions.DomainException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InitialMenu {
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

    public static void menuChoice(Scanner sc, Path form) throws DomainException {
        try {
            System.out.print("Digite uma opção: ");
            int choice = sc.nextInt();
            if (choice <= 0)
                throw new DomainException("Não é possível digitar um número 0 ou negativo.");
            switch (choice) {
                case 1:
                    Pet pet = new Pet();
                    FormData.formReader(sc,form,pet);
                    break;
                case 2:
                    System.out.println("Alterar dados");
                    break;
                case 3:
                    System.out.println("Deletar um pet");
                    break;
                case 4:
                    System.out.println("Listar todos os pets");
                    break;
                case 5:
                    System.out.println("Listar pets por algum critério");
                    break;
                case 6:
                    System.out.println("Sair");
                    break;
                default:
                    break;
            }
        }
        catch (NoSuchElementException | IOException e){
            sc.nextLine();
            throw new DomainException("Digite um número válido!");
        }
    }
}
