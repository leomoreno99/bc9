package lmoreno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HunderGames {

    public static String[] whoEatsWho(final String zoo) {
        String[] bajada = zoo.split(",");
        ArrayList<String> animals= new ArrayList<>(Arrays.asList(bajada));
        ArrayList<String> resultado= new ArrayList<>();
        resultado.add(zoo);

        while (animals.size() > 1){
            for (int i = 0; i < animals.size() - 1; i++) {
                switch (animals.get(i)){
                    case "bear": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("big-fish", "cow", "bug", "chicken", "sheep", "leaves"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "fox": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("chicken","sheeps"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "lion":{
                        List<String> alimento = new ArrayList<String>(Arrays.asList("antelope","cow"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "panda": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("leaves"));
                        come(animals, resultado, i, alimento);
                    }
                    case "chicken": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("bug"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "bug": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("leaves"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "cow": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("grass"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "big-fish": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("little-fish"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "sheep": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("grass"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "giraffe": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("leaves"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                    case "antelope": {
                        List<String> alimento = new ArrayList<String>(Arrays.asList("grass"));
                        come(animals, resultado, i, alimento);
                        break;
                    }
                }
            }
        }

        return new String[]{zoo, zoo};
    }

    private static void come(ArrayList<String> animals, ArrayList<String> resultado, int i, List<String> alimento) {
        if (i-1 >= 0 && alimento.contains(animals.get(i - 1))) {
            resultado.add(animals.get(i) + " eats " + animals.get(i - 1));
            animals.remove(i - 1);
        }
        if (i+1 < animals.size() && alimento.contains(animals.get(i + 1))) {
            resultado.add(animals.get(i) + " eats " + animals.get(i + 1));
            animals.remove(i + 1);
        }
    }
}
