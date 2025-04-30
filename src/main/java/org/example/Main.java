package org.example;

import services.FormData;
import exceptions.DomainException;
import services.InitialMenu;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DomainException {

        Path direct = Paths.get("src/main/java/arquivos");
        Path form = Paths.get(direct.toString(), "formulario.txt");

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                FormData.formWriter(direct, form);

                InitialMenu.print();
                InitialMenu.menuChoice(sc,form);

            }
            catch (IOException | DomainException e) {
                System.err.println("ERRO: " + e.getMessage() + "\n");
            }
        }
    }
}