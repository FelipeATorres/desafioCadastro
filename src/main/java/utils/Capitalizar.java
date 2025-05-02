package utils;

public class Capitalizar {
    public static String strings(String paraCapitalizar) {
        String[] listaParaCapitalizar = paraCapitalizar.split(" ");
        String stringNova = "";
        for (int i = 0; i < listaParaCapitalizar.length; i++ ) {
            if (i > 0)
                stringNova = stringNova.concat(" ");
            listaParaCapitalizar[i] = listaParaCapitalizar[i].substring(0,1).toUpperCase() +
                    listaParaCapitalizar[i].substring(1).toLowerCase();
            stringNova = stringNova.concat(listaParaCapitalizar[i]);
        }
        return stringNova.trim();
    }
}