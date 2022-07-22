package lmoreno;
public class VeryEven {
    public static boolean isVeryEvenNumber(int number) {
        String numeroString;
        int suma = number;
        char[] digitos;

        while (tenga2Digitos(suma)){
            numeroString = String.valueOf(suma); //se convierte Integer en String
            digitos = numeroString.toCharArray(); //se convierte String en digitos de char
            suma = 0;
            for (char cadaDigito : digitos) { //
                suma += Character.getNumericValue(cadaDigito);
            }
        }

        return (suma % 2 == 0);
    }
    private static boolean tenga2Digitos(int suma) {
        return suma > 9;
    }

}
