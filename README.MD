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

## R2 - Cadena de montaje

### `Estacion.java`
Implementa Runnable para poder crear un hilo de tipo Estacion. Tiene un constructor para poder pasar el nombre del hilo y
una lista de objetos Thread por los que se quiera esperar a que terminen, en este caso Corte y Ensamblaje.

Cada estacion da 5 pasos y termina

### `Main.java`
Se crea una lista tipo Thread para los hilos por lo que se quiera esperar, en este caso Pintura quiere esperar a que
Corte y ensamblaje terminen.

## R3 - Cadena de montaje

### ¿Qué salida producirá este código? ¿Puede cambiar de una ejecución a otra? Justifica la respuesta.
El código imprime el nombre del hilo A y del hilo B del 1 al 3, durmiéndose 0.2s en cada iteración. Como el hilo
A tiene un join después del start, este no dejara que el hilo B empieze a imprimirse hasta que acabe. Por esto miosmo tambien. 
el print "Fin del main" se imprime antes de que el hilo B empieze aunque en el codigo este antes, ya que el hilo B sigue 
esperando a que el hilo A termine.

El codigo no puede cambiar entre ejecuciones porque al estar programado de esta manera, no hay concurrencia y el resultado
siempre es fijo.

## R4 - Cadena de montaje
### a) ¿Funciona este código? ¿Qué pasa al ejecutarlo? ¿Cómo lo arreglarías? Justifica la respuesta.
No, se quedaria en un bucle infinito ya que el Visitante al llamar a "esperarApertura()" con Thread.sleep,
el candado de synchonized nunca se libera, y el hilo Portero al querer acceder a abrir() se queda BLOCKED. 
La forma mas facil de arreglarlo seria cambiar el sleep por un wait() para que el Visitante suelte el candado
y el Portero pueda cambiar la condición del bucle a true

### b) Un compañero lo «arregla» así: cambia el sleep() por wait(), añade notifyAll() en abrir() y, de paso, quita los dos synchronized. ¿Funciona ahora? ¿Qué pasa al ejecutarlo? Justifica la respuesta.
Para empezar el codigo daria un error de ejecucion porque no se puede usar wait() ni notifyAll() 
sin que las funciones sean synchronized. Con eso corregido el codigo funcionaria sin problemas.