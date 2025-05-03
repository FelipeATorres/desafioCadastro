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
        int escolha = 0;

        while (escolha != 6) {
            try {
                InfoFormulario.escreverForm(diretorio, form);

                MenuInicial.print();
                escolha = MenuInicial.escolhaMenu(sc,form, escolha);

            }
            catch (IOException | DomainException e) {
                System.err.println("ERRO: " + e.getMessage() + "\n");
            }
        }
    }
}