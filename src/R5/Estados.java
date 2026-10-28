package R5;

class Dormilon extends Thread {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }
    }
}
class Esperador extends Thread {
    private final Thread otro;
    public Esperador(Thread otro) { this.otro = otro; }
    public void run() {
        try {
            otro.join();
        } catch (InterruptedException e) { }
    }
}
public class Estados {
    public static void main(String[] args)
            throws InterruptedException {
        Dormilon d = new Dormilon();
        Esperador e = new Esperador(d);
        System.out.println("(1) " + d.getState());
        d.start();
        e.start();
        Thread.sleep(500);
        System.out.println("(2) " + d.getState());
        System.out.println("(3) " + e.getState());
        e.join();
        System.out.println("(4) " + d.getState() + " " + e.getState());
    }
}
