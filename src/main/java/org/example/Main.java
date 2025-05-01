package org.example;

import services.FormData;
import exceptions.DomainException;
import services.InitialMenu;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DomainException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Path direct = Paths.get("src/main/java/arquivos");
        Path form = Paths.get(direct.toString(), "formulario.txt");

        while (true) {
            try {
                FormData.formWriter(direct, form);

                InitialMenu.print();
                InitialMenu.menuChoice(sc,form);

            }
            catch (IOException | DomainException e) {
                System.err.println("\nERRO: " + e.getMessage() + "\n");
            }
        }
    }
}