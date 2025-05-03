package services;

import entities.Pet;
import exceptions.DomainException;
import utils.ENulo;
import utils.TipoESexoPet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalvarInformacoesPet {
    private static final Path cadastros = Paths.get("src/main/java/arquivos/petsCadastrados");
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");

    public static void save(Pet pet) throws IOException, DomainException {
        Files.createDirectories(cadastros);
        try{
            LocalDateTime registrarData = LocalDateTime.now();
            String stringNomeArquivo = fmt.format(registrarData) + "-" +
                    pet.getNome().toUpperCase().replace(" ","") +
                    ".txt";
            Path nomeArquivo = Paths.get(String.valueOf(cadastros), stringNomeArquivo);

            if (!Files.exists(nomeArquivo)){
                Files.createFile(nomeArquivo);
                String[] informacoes = new String[]{
                        "1 - " + ENulo.verificarString(pet.getNome()) + "\n" +
                        "2 - " + TipoESexoPet.verificarTipo(pet.getPetType()) + "\n" +
                        "3 - " + TipoESexoPet.verificarSexo(pet.getPetSex()) + "\n" +
                        "4 - " + pet.getEndereco() + "\n" +
                        "5 - " + String.format("%s anos", ENulo.verificarDouble(pet.getIdade())) + "\n" +
                        "6 - " + String.format("%skg", ENulo.verificarDouble(pet.getPeso())) + "\n" +
                        "7 - " + ENulo.verificarString(pet.getRaca())};

                try (BufferedWriter bw = Files.newBufferedWriter(nomeArquivo)){
                    for (String line : informacoes){
                        bw.write(line);
                        bw.newLine();
                    }

                }
            }
            System.out.println("\nPet cadastrado com sucesso!");
        }
        catch (IOException e){
            throw new DomainException("IOException");
        }
    }
}
