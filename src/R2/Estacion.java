package R2;

import java.util.List;

public class Estacion implements Runnable{
private String nombre;
private List<Thread> hilosAesperar;

    public Estacion(String nombre){
        this.nombre = nombre;
    }

    public Estacion(String nombre, List<Thread> hilosAesperar){
        this.nombre = nombre;
        this.hilosAesperar = hilosAesperar;
    }

    @Override
    public void run() {
        if(hilosAesperar != null) {
            try {
                for (Thread h: hilosAesperar) {
                    h.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 1; i <= 5; i++){
            System.out.println(nombre +" - paso" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getNombre (){
        return nombre;
    }
}
