package services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class dadadaa {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/arquivos/petsCadastrados/20250502T1621-JUNINHOBOMBA.txt");

        String conteudo = new String(Files.readAllBytes(path));
        String conteudoEditado = conteudo.replace("1 - Juninho Bomba", "Juninha Bombete");
        Files.write(path, conteudoEditado.getBytes());

    }
}
