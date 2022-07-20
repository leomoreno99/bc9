package ahernandez;


/*Cuente el número de duplicados
Escriba una función que devuelva el recuento de caracteres alfabéticos y
 dígitos numéricos distintos que no distinguen entre mayúsculas y minúsculas
 que aparecen más de una vez en la cadena de entrada. Se puede suponer que la cadena
 de entrada contiene solo letras (tanto mayúsculas como minúsculas) y dígitos numéricos.

Ejemplo
"abcde" -> 0 # ningún carácter se repite más de una vez
"aabbcde" -> 2 # 'a' y 'b'
"aabBcde" -> 2 # 'a' ocurre dos veces y 'b' dos veces (`b` y `B`)
"indivisibilidad" -> 1 # 'i' aparece seis veces
"Indivisibilidades" -> 2 # 'i' ocurre siete veces y 's' ocurre dos veces
"aA11" -> 2 # 'a' y '1'
"ABBA" -> 2 # 'A' y 'B' cada uno ocurre dos veces*/




public class CountingDuplicates {
    public static int duplicateCount(String text) {

        int contador = 0; //
        text = text.toLowerCase(); // paso todo  el tex a minus
        while (text.length() > 0) { // recorre hasta quedar sin letras
            String primeraLetra = text.substring(0,1);//Substring toma el caracter dependiendo de la posicion (inicio/fin)
            text = text.substring(1);// numero de caracteres a tomar para comparar
            if (text.contains(primeraLetra)) contador ++; //constains comprueba que exista la letra (contains = valor booleano)

            text = text.replace(primeraLetra, ""); // remplazo por un espacio en blanco al terminar el ciclo de la letra

        }
        return contador;
    }
}
