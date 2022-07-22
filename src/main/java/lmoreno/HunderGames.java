package lmoreno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  HunderGames {

    public static String[] whoEatsWho(final String zoo) {
        String[] divideString = zoo.split(","); //Convertir String a un Array separado por comas.
        ArrayList<String> animals= new ArrayList<>(Arrays.asList(divideString)); //Ingresar a ArrayList para uso dinámico (agregar y quitar posiciones).
        ArrayList<String> result= new ArrayList<>();
        result.add(zoo);
        int counter=0; //contador de referencia para escapar de ciclo while

        while (canEat(animals, counter)){
            for (int i = 0; i <= animals.size() - 1; i++) { //Recorrer Zoo
                boolean bool;
                switch (animals.get(i)) {
                    case "bear" -> {
                        List<String> alimento = new ArrayList<>(Arrays.asList("big-fish", "cow", "bug", "chicken", "sheep", "leaves"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    case "fox" -> {
                        List<String> alimento = new ArrayList<>(Arrays.asList("chicken", "sheep"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    case "lion" -> {
                        List<String> alimento = new ArrayList<>(Arrays.asList("antelope", "cow"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    case "panda", "bug", "giraffe" -> {
                        List<String> alimento = new ArrayList<>(List.of("leaves"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    case "chicken" -> {
                        List<String> alimento = new ArrayList<>(List.of("bug"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    case "cow", "antelope", "sheep" -> {
                        List<String> alimento = new ArrayList<>(List.of("grass"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    case "big-fish" -> {
                        List<String> alimento = new ArrayList<>(List.of("little-fish"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    case "leaves", "grass" -> {
                        List<String> alimento = new ArrayList<>(List.of("noeat"));
                        bool = eat(animals, result, i, alimento);
                        if (bool) {
                            counter = 0;
                        }
                    }
                    default -> {
                        bool = false;
                        counter++;
                        if (counter > animals.size()) {
                            bool = true;
                        }
                    }
                }
                if(bool){break;}
            }
        }
        String lastLineArray =String.join(",",animals); //pasamos el array a string
        result.add(lastLineArray); //lo agregamos a la ultima posicion
        String[] finalStateZoo= new String[result.size()]; //creamos un array con el largo
        finalStateZoo=result.toArray(finalStateZoo);//cambiamos la lista dinamica a un array
        return finalStateZoo;
    }

    private static boolean canEat(ArrayList<String> animals, int counter) {
        return animals.size() > 1 && counter < animals.size();
    }

    private static boolean eat(ArrayList<String> animals, ArrayList<String> resultado, int i, List<String> alimento) {
        boolean bool=false;
        if (i-1 >= 0 && alimento.contains(animals.get(i - 1))) {
            resultado.add(animals.get(i) + " eats " + animals.get(i - 1));
            animals.remove(i - 1);
            bool=true;
        }
        if (i+1 < animals.size() && alimento.contains(animals.get(i + 1))) {
            resultado.add(animals.get(i) + " eats " + animals.get(i + 1));
            animals.remove(i + 1);
            bool=true;
        }
        return bool;
    }
}
