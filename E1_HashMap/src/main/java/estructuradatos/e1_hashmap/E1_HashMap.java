
package estructuradatos.e1_hashmap;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class E1_HashMap {

    public static void main(String[] args) {
        HashMap<Integer,String> dicExpediente = new HashMap<>();
        String menu = """
                      [1] Crear expediente
                      [2] Consulta individual
                      [3] Modificar paciente
                      [4] Eliminar expediente
                      [5] Mostrar expedientes
                      [6] Salir
                      
                      Elige una opción
                      """;
        int opcion;
        int numExp;
        String paciente;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1: numExp = Integer.parseInt(JOptionPane.showInputDialog("Expediente:"));
                        //Buscamos la clave en el HashMap
                        if (dicExpediente.containsKey(numExp)) {
                            JOptionPane.showMessageDialog(null, "Expediente dupplicado");
                        }else{
                            paciente = JOptionPane.showInputDialog("Paciente:");
                            dicExpediente.put(numExp, paciente);
                        }
                    break;
                case 2: numExp = Integer.parseInt(JOptionPane.showInputDialog("Expediente:"));
                        //Buscamos la clave en el HashMap
                        if (dicExpediente.containsKey(numExp)) {
                            JOptionPane.showMessageDialog(null, "Num de Exp. "+numExp+" = "
                                                          +dicExpediente.get(numExp));
                        }else{
                            JOptionPane.showMessageDialog(null, "Epediente no encontrado");
                        }
                    break;
                case 3: numExp = Integer.parseInt(JOptionPane.showInputDialog("Expediente a modificar:"));
                        if (dicExpediente.containsKey(numExp)) {
                           String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre");
                           dicExpediente.replace(numExp, nuevoNombre);
                           JOptionPane.showMessageDialog(null, "Expediente modificado");
                           JOptionPane.showMessageDialog(null, dicExpediente);
                        }else{
                            JOptionPane.showMessageDialog(null, "Epediente no encontrado");
                        }
                    break;
                case 4: numExp = Integer.parseInt(JOptionPane.showInputDialog("Expediente a eliminar:"));
                        if (dicExpediente.containsKey(numExp)) {
                           dicExpediente.remove(numExp); //Eliminación
                           JOptionPane.showMessageDialog(null, "Expediente eliminado");
                           JOptionPane.showMessageDialog(null, dicExpediente);
                        }else{
                            JOptionPane.showMessageDialog(null, "Epediente no encontrado");
                        }
                    break;
                case 5: Iterator<Integer> iterator = dicExpediente.keySet().iterator();
                        int key;
                        StringBuilder mensaje = new StringBuilder();
                        while(iterator.hasNext()){
                            key = iterator.next();
                            mensaje.append("Expediente: ").append(key);
                            mensaje.append(" -- Paciente: ").append(dicExpediente.get(key)+"\n");
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
            }
        } while (opcion != 6);
    }
}
