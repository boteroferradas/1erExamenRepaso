package R4;

class Puerta {
    private boolean abierta = false;
    public synchronized void esperarApertura()
            throws InterruptedException {
        while (!abierta) {
            Thread.sleep(100); // espero a que la abran
        }
        System.out.println("El visitante entra");
    }
    public synchronized void abrir() {
        abierta = true;
        System.out.println("Puerta abierta");
    }
}
// Un hilo Visitante llama a esperarApertura().
// Un segundo después, un hilo Portero llama a abrir().