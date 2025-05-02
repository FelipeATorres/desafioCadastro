package services;

import entities.Pet;
import enums.SexoPet;
import enums.TipoPet;
import exceptions.DomainException;
import utils.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InfoFormulario {

    public static void escreverForm(Path direct, Path form) throws IOException, DomainException {
        Files.createDirectories(direct);
        try {
            if (!Files.exists(form)) {
                Files.createFile(form);
                String[] questoes = new String[]{
                        "1 - Qual o nome e sobrenome do pet?\n" +
                        "2 - Qual o tipo do pet (Cachorro/Gato)?\n" +
                        "3 - Qual o sexo do animal?\n" +
                        "4 - Qual endereço e bairro que ele foi encontrado?\n" +
                        "5 - Qual a idade aproximada do pet?\n" +
                        "6 - Qual o peso aproximado do pet?\n" +
                        "7 - Qual a raça do pet?"};

                try (BufferedWriter bw = Files.newBufferedWriter(form)) {
                    for (String line : questoes) {
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

    public static void lerForm(Scanner sc, Path form, Pet pet) throws IOException, DomainException {
        try(BufferedReader br = Files.newBufferedReader(form)) {
            String linha = br.readLine();
            int i = 0;

            /// nome e sobrenome do pet
            System.out.println(linha);
            String nome = sc.nextLine().trim();
            NomePet.verificar(nome);
            nome = Capitalizar.strings(nome);
            pet.setNome(nome);
            linha = br.readLine();

            /// tipo do pet cachorro/gato
            System.out.println(linha);
            pet.setPetType(TipoPet.valueOf(sc.nextLine().toUpperCase()));
            linha = br.readLine();

            /// sexo do pet
            System.out.println(linha);
            pet.setPetSex(SexoPet.valueOf(sc.nextLine().toUpperCase()));
            linha = br.readLine();

            /// endereço do pet
            System.out.println(linha);
            System.out.println("I. Número da casa: ");
            int numCasa = sc.nextInt();
            sc.nextLine();
            System.out.println("II. Cidade: ");
            String cidade = sc.nextLine();
            System.out.println("III. Rua: ");
            String rua = sc.nextLine();
            String endereco = "";
            endereco = endereco.concat(rua + ", " + ENulo.verificarInt(numCasa) + ", " + cidade);
            pet.setEndereco(endereco);
            linha = br.readLine();

            /// idade do pet
            System.out.println(linha);
            double idade = sc.nextDouble();
            sc.nextLine();
            ValidacaoIdade.verificar(idade);
            pet.setIdade(idade);
            linha = br.readLine();

            /// peso do pet
            System.out.println(linha);
            double peso = sc.nextDouble();
            sc.nextLine();
            ValidacaoPeso.verificar(peso);
            pet.setPeso(peso);
            linha = br.readLine();

            /// raça do pet
            System.out.println(linha);
            String raca= sc.nextLine();
            StringCaracterSpecial.verificar(raca);
            raca = Capitalizar.strings(raca);
            pet.setRaca(raca);
        }
    }
}
