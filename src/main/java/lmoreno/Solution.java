package lmoreno;

public class Solution {

    public int solution(int number) {
        int suma = 0;
        for (int i = 0; i < number; i++){
            if(i % 3 == 0 || i % 5 == 0)
                suma += i;
        }
        return suma;
    }
}
