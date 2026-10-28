package R1;

public class Marcador {
    private static int marcador;
    private static int accesos = 0;

    public static synchronized void sumar(int entradas) throws InterruptedException {
        marcador += entradas;
        accesos++;
        System.out.println("[Marcador] Hilo entra al synchronized. Acceso #" + accesos);
    }

    public static synchronized int getMarcador() {
        return marcador;
    }

    public static synchronized int getAccesos() {
        return accesos;
    }
}
