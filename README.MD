# Repaso 1er Examen

## R1 - Tornos del estadio

### `Torno.java`
Implementa Runnable, se encarga de generar un número aleaotrio entre 500 y 1000 para hacer una suma en el main con una 
suma que se saca del propio valor y al mismo tiempo se suma dentro de la clase `Marcador` con synchronized
### `Marcador.java`
Tiene un método synchronized que se encarga de sumar los valores de todos los tornos
### `Main.java`
Se crea una lista de Tornos, otra de hilos y una suma para los tornos. Primero se crean los hilos (4 en este caso),
se añaden a su lista y al mismo tiempo se crea un hilo nuevo con cada uno y se añade a su lista respectiva.

Se inician todos los hilos con un bucle .start y esperan a que acaben su proceso con otro bucle .join. Al acabar
se hace la suma en otro bucle que itera sobre la lista de tornos y se sacan los resultados finales, tanto de la suma
como de la clase marcador son synchronized

### Preguntas
#### -  ¿Qué pasa si haces start() y join() dentro del mismo bucle? ¿Sigue dando el total bien? ¿Siguen siendo concurrentes los tornos?
Matematicamente seguira dando bien da igual cuantas veces se ejecuten, pero se perdera la concurrencia ya
que al hacer un .join justo después del .start, el main esperara a que el primer hilo termine de ejecutarse para iniciar
el siguiente, y asi sucesivamente.

#### -  ¿Cuántas veces entra cada torno en el synchronized? ¿Podrías hacer que entrara una sola vez, al final?
