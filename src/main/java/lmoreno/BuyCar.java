package lmoreno;

public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        double ahorrado = 0;
        int meses = 0;
        double porcentaje = percentLossByMonth/100;
        double autoViejo = startPriceOld;
        double autoNuevo = startPriceNew;

        if(puedeComprar(autoViejo, autoNuevo)) {
            return new int[] { meses, (int) Math.round(autoViejo - autoNuevo)};
        }

        do{
            ahorrado += savingperMonth;
            meses++;
            if(cada2Meses(meses)){
                porcentaje += 0.005;
            }
            autoViejo -= autoViejo*porcentaje;
            autoNuevo -= autoNuevo*porcentaje;

        }
        while (noAlcanza(ahorrado, autoViejo, autoNuevo));

        return new int[] { meses, (int) Math.round(autoViejo + ahorrado - autoNuevo)};
    }

    private static boolean cada2Meses(int meses) {
        return meses % 2 == 0;
    }

    private static boolean puedeComprar(double autoViejo, double autoNuevo) {
        return autoViejo >= autoNuevo;
    }

    private static boolean noAlcanza(double ahorrado, double autoViejo, double autoNuevo) {
        return autoViejo + ahorrado <= autoNuevo;
    }
}
