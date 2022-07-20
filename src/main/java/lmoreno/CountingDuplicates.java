package lmoreno;

import java.util.Arrays;

/**
 * Contar el número de duplicados
 *
 * Escriba la función duplicateCount, que devuelva
 * el numero (entero) de letras duplicadas.
 *
 * String de entrada:
 * 1. distinct case-insensitive
 * 2. Acepta solo Alfanumericos
 *
 * Ejemplos de retornos de la funcion
 *
 * "abcde" -> 0 # ningún carácter se repite más de una vez
 * "aabbcde" -> 2 # 'a' y 'b'
 * "aabBcde" -> 2 # 'a' aparece dos veces y 'b' dos veces (`b` y` B`)
 * "indivisibility" -> 1 # 'i' aparece seis veces
 * "aA11" -> 2 # 'a' y '1'
 * "ABBA" -> 2 # 'A' y 'B' ocurren dos veces
 */
public class CountingDuplicates {

    public static int duplicateCount(String text) {
        String textLower = text.toLowerCase();
        char[] arrayList = textLower.toCharArray();
        Arrays.sort(arrayList);
        //String sortedString = new String(array);
        //char[] arrayList = sortedString.toCharArray();
        int cont=0;
        String repeat="";
        for (int j = 1; j < arrayList.length; j++) {
            if(arrayList[j-1] == arrayList[j]){
                CharSequence aux = new StringBuilder(1).append(arrayList[j]);
                if(!repeat.contains(aux)){
                    repeat+=arrayList[j];
                    cont++;
                }
            }
        }
        return cont;
    }
    public static void main(String []args){
        System.out.println(duplicateCount("aabbcc"));
    }
}

