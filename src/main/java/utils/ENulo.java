package utils;

public class ENulo {
    private static final String NAO_INFORMADO = "Não informado";

    public static String verificarString(String stringParaVerificar){
        return (stringParaVerificar == null) ? NAO_INFORMADO : stringParaVerificar;
    }

    public static String verificarDouble(Double doubleParaVerificar){
        return (doubleParaVerificar <= 0) ? NAO_INFORMADO : String.format("%.1f", doubleParaVerificar);
    }

    public static String verificarInt(Integer intParaVerificar){
        return (intParaVerificar <= 0) ? NAO_INFORMADO : String.format("%d", intParaVerificar);
    }

}
