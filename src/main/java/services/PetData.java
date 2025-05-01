package services;

import entities.Pet;
import exceptions.DomainException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetData {
    private static final Path cadastros = Paths.get("src/main/java/arquivos/petsCadastrados");
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMddTHHmm");

    public static void save(Pet pet) throws IOException, DomainException {
        Files.createDirectories(cadastros);
        try{
            String registerDate = String.valueOf(LocalDateTime.now());
            String fileName = "";
            fileName = fileName.concat(
                    String.valueOf(LocalDateTime.parse(registerDate,fmt)) +
                    "-" +
                    pet.getName().toUpperCase().replace(" ","") +
                    ".txt");
            Path archiveName = Paths.get(String.valueOf(cadastros), fileName);

            if (!Files.exists(archiveName)){
                Files.createFile(archiveName);
                String[] data = new String[]{
                        "1 - " + pet.getName() + "\n" +
                        "2 - " + pet.getPetType() + "\n" +
                        "3 - " + pet.getPetSex() + "\n" +
                        "4 - " + pet.getAddress() + "\n" +
                        "5 - " + pet.getAge() + "\n" +
                        "6 - " + pet.getWeight() + "\n" +
                        "7 - " + pet.getBreed() + "\n"};

                try (BufferedWriter bw = Files.newBufferedWriter(archiveName)){
                    for (String line : data){
                        bw.write(line);
                        bw.newLine();
                    }

                }
            }
        }
        catch (IOException e){
            throw new DomainException("IOException");
        }
    }
}
