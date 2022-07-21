package lmoreno;


public class VeryEven {
    public static boolean isVeryEvenNumber(int number) {
        String text;
        int suma = number;
        char[] array;

        while (suma > 9){
            text = String.valueOf(suma);
            array = text.toCharArray();
            suma = 0;
            for (char c : array) {
                suma += Character.getNumericValue(c);
            }
        }

        return (suma % 2 == 0);
    }
}
