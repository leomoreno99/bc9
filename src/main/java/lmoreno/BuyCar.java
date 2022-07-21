package lmoreno;

public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        double ahorrado = 0;
        int meses = 0;
        double percent = percentLossByMonth/100;
        double autoViejo = startPriceOld;
        double autoNuevo = startPriceNew;

        if(autoViejo >= autoNuevo) {
            return new int[] { meses, (int) Math.round(autoViejo - autoNuevo)};
        }

        do{
            ahorrado += savingperMonth;
            meses++;
            if(meses%2 == 0){
                percent += 0.005;
            }
            autoViejo -= autoViejo*percent;
            autoNuevo -= autoNuevo*percent;

        }
        while (autoViejo + ahorrado <= autoNuevo);
        
        return new int[] { meses, (int) Math.round(autoViejo + ahorrado - autoNuevo)};
    }
}
