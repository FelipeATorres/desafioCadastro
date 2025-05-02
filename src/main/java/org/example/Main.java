package org.example;

import services.InfoFormulario;
import exceptions.DomainException;
import services.MenuInicial;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DomainException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Path diretorio = Paths.get("src/main/java/arquivos");
        Path form = Paths.get(diretorio.toString(), "formulario.txt");

        while (true) {
            try {
                InfoFormulario.escreverForm(diretorio, form);

                MenuInicial.print();
                MenuInicial.escolhaMenu(sc,form);

            }
            catch (IOException | DomainException e) {
                System.err.println("\nERRO: " + e.getMessage() + "\n");
            }
        }
    }
}