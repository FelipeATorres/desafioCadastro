package utils;

public class Capitalize {
    public static String strings(String toCapitalize) {
        String[] toCapitalizeList = toCapitalize.split(" ");
        String newString = "";
        for (int i = 0; i < toCapitalizeList.length; i++ ) {
            if (i > 0)
                newString = newString.concat(" ");
            toCapitalizeList[i] = toCapitalizeList[i].substring(0,1).toUpperCase() +
                    toCapitalizeList[i].substring(1).toLowerCase();
            newString = newString.concat(toCapitalizeList[i]);
        }
        return newString.trim();
    }
}