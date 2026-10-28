package R3;

public class Orden {
    public static void main(String[] args)
            throws InterruptedException {
        Thread a = new Thread(new Tarea(), "A");
        Thread b = new Thread(new Tarea(), "B");
        a.start();
        a.join();
        b.start();
        System.out.println("Fin del main");
        b.join();
    }
    static class Tarea implements Runnable {
        public void run() {
            String nombre = Thread.currentThread().getName();
            for (int i = 1; i <= 3; i++) {
                System.out.println(nombre + " " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) { }
            }
        }
    }
}