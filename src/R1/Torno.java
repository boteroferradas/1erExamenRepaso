package R1;

import java.util.Random;

public class Torno implements Runnable{
private String nombre;
private int entradas = 0;

    public Torno(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Random random = new Random();
        entradas = random.nextInt(500, 1000);
        System.out.println(nombre + ": " + entradas + " entradas");
        try {
            Marcador.sumar(entradas);
        } catch (InterruptedException e) {
            System.out.println("Error al sumar en marcador: " + e.getMessage());
        }
    }

    public int getEntradas() {
        return entradas;
    }
}
