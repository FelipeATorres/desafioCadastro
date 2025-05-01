package services;

import entities.Pet;
import enums.PetSex;
import enums.PetType;
import exceptions.DomainException;
import utils.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FormData {

    public static void formWriter(Path direct, Path form) throws IOException, DomainException {
        Files.createDirectories(direct);
        try {
            if (!Files.exists(form)) {
                Files.createFile(form);
                String[] questions = new String[]{
                        "1 - Qual o nome e sobrenome do pet?\n" +
                        "2 - Qual o tipo do pet (Cachorro/Gato)?\n" +
                        "3 - Qual o sexo do animal?\n" +
                        "4 - Qual endereço e bairro que ele foi encontrado?\n" +
                        "5 - Qual a idade aproximada do pet?\n" +
                        "6 - Qual o peso aproximado do pet?\n" +
                        "7 - Qual a raça do pet?"};

                try (BufferedWriter bw = Files.newBufferedWriter(form)) {
                    for (String line : questions) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
                System.out.println("Formulário criado com sucesso!!\n");
            }
        }
        catch (IOException e) {
            throw new DomainException("IOException");
        }
    }

    public static void formReader(Scanner sc, Path form, Pet pet) throws IOException, DomainException {
        try(BufferedReader br = Files.newBufferedReader(form)) {
            String line = br.readLine();
            int i = 0;

            /// nome e sobrenome do pet
            System.out.println(line);
            sc.nextLine();
            String name = sc.nextLine().trim();
            PetName.verify(name);
            pet.setName(Capitalize.strings(name));
            line = br.readLine();

            /// tipo do pet cachorro/gato
            System.out.println(line);
            pet.setPetType(PetType.valueOf(sc.nextLine().toUpperCase()));
            line = br.readLine();

            /// sexo do pet
            System.out.println(line);
            pet.setPetSex(PetSex.valueOf(sc.nextLine().toUpperCase()));
            line = br.readLine();

            /// endereço do pet
            System.out.println(line);
            System.out.println("I. Número da casa: ");
            int numHouse= sc.nextInt();
            sc.nextLine();
            System.out.println("II. Cidade: ");
            String city = sc.nextLine();
            System.out.println("III. Rua: ");
            String street = sc.nextLine();
            String address = "";
            address = address.concat(street + ", " + numHouse + ", " + city);
            pet.setAddress(address);
            line = br.readLine();

            /// idade do pet
            System.out.println(line);
            double age = sc.nextDouble();
            sc.nextLine();
            AgeValidate.verify(age);
            pet.setAge(age);
            line = br.readLine();

            /// peso do pet
            System.out.println(line);
            double weight = sc.nextDouble();
            sc.nextLine();
            WeightValidate.verify(weight);
            pet.setWeight(weight);
            line = br.readLine();

            /// raça do pet
            System.out.println(line);
            String breed = sc.nextLine();
            SpecialCharacterString.verify(breed);
            pet.setBreed(Capitalize.strings(breed));
        }
    }
}
