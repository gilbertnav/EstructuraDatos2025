
package estructuradatos.e1_pilas;

import java.util.ArrayDeque;
import java.util.Deque;



public class E1_Pilas {

    public static void main(String[] args) {
       Deque<String> pilaAlumnos = new ArrayDeque<>();
       pilaAlumnos.push("Juan");
       pilaAlumnos.push("Maria");
       pilaAlumnos.push("Pedro");
       pilaAlumnos.push("Laura");
       pilaAlumnos.push("Cristian");
       System.out.println("Elementos: " + pilaAlumnos);
        System.out.println("Elemento en la cima: " + pilaAlumnos.peek());
        System.out.println("Elemento eliminado: " + pilaAlumnos.pop());
        System.out.println("Pila después de eliminar: " + pilaAlumnos);
    }
}
