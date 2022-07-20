package ahernandez;

public class Solution {

/*
    Si enumeramos todos los números naturales debajo de 10 que son múltiplos de 3 o 5,
    obtenemos 3, 5, 6 y 9. La suma de estos múltiplos es 23.
    Termina la solución para que devuelva la suma de todos los múltiplos de 3 o 5 por debajo del número pasado.
    Nota: si el número es un múltiplo de 3 y 5,
    solo cuéntelo una vez. Además, si un número es negativo, devuelva 0 (para los idiomas que los tienen) */



    public int solution(int numero) {
// obtener los numero divicibles por 3 y 5
// sumar numeros divicibles  \ tope numero 10

        int contador =0;
        for(int i=3; i<numero;i++){

            if(i %3 ==0 || i %5 ==0){
                contador += i;
            }
        }
        return contador;


    }
}
