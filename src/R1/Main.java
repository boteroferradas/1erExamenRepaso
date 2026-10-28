package R1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int suma = 0;
        ArrayList<Torno> listaTornos = new ArrayList<>();
        ArrayList<Thread> listaHilos = new ArrayList<>();
        for (int i = 1; i <= 4;i++){
            Torno t = new Torno("Torno-" + i);
            Thread hilo = new Thread(t);
            listaTornos.add(t);
            listaHilos.add(hilo);
        }

        for (Thread h : listaHilos) {
            h.start();
            h.join();
        }

//        for (Thread h : listaHilos) {
//            try {
//                h.join();
//            } catch (InterruptedException e) {
//                System.out.println("Error al hacer join: " +e.getMessage());
//            }
//        }

        for(Torno t : listaTornos) {
            suma += t.getEntradas();
        }

        System.out.println("Marcador del estadio: " + Marcador.getMarcador());
        System.out.println("Suma de los tornos: " + suma);
    }
}
