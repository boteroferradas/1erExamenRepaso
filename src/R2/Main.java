package R2;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Thread> hilosAesperar = new ArrayList<>();


        Estacion corte = new Estacion("Corte");
        Thread hilo1 = new Thread(corte);
        hilosAesperar.add(hilo1);
        Estacion ensamblaje = new Estacion("Ensamblaje");
        Thread hilo2 = new Thread(ensamblaje);
        hilosAesperar.add(hilo2);
        Estacion pintura = new Estacion("Pintura", hilosAesperar);
        Thread hilo3 = new Thread(pintura);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("Producto terminado");
    }
}
