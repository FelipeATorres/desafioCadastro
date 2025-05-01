package services;

import entities.Pet;
import enums.PetType;
import exceptions.DomainException;
import utils.IsNull;
import utils.PetTypeAndSex;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetData {
    private static final Path cadastros = Paths.get("src/main/java/arquivos/petsCadastrados");
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");

    public static void save(Pet pet) throws IOException, DomainException {
        Files.createDirectories(cadastros);
        try{
            LocalDateTime registerDate = LocalDateTime.now();
            String fileName = fmt.format(registerDate) + "-" +
                    pet.getName().toUpperCase().replace(" ","") +
                    ".txt";
            Path archiveName = Paths.get(String.valueOf(cadastros), fileName);

            if (!Files.exists(archiveName)){
                Files.createFile(archiveName);
                String[] data = new String[]{
                        "1 - " + IsNull.verifyString(pet.getName()) + "\n" +
                        "2 - " + PetTypeAndSex.verifyType(pet.getPetType()) + "\n" +
                        "3 - " + PetTypeAndSex.verifySex(pet.getPetSex()) + "\n" +
                        "4 - " + pet.getAddress() + "\n" +
                        "5 - " + String.format("%s anos",IsNull.verifyDouble(pet.getAge())) + "\n" +
                        "6 - " + String.format("%skg",IsNull.verifyDouble(pet.getWeight())) + "\n" +
                        "7 - " + IsNull.verifyString(pet.getBreed())};

                try (BufferedWriter bw = Files.newBufferedWriter(archiveName)){
                    for (String line : data){
                        bw.write(line);
                        bw.newLine();
                    }

                }
            }
            System.out.println("Pet cadastrado com sucesso!");
        }
        catch (IOException e){
            throw new DomainException("IOException");
        }
    }
}
