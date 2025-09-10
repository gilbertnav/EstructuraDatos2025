
package estructuradatos.e1arreglostring;
        
import javax.swing.JOptionPane;

public class E1ArregloString {
    public static void main(String[] args) {
        String ciudad="   Ometepec, Guerrero ";
        String ciudad2="Ometepec";
        String vocales = "a,e,i,o,u";
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Tamaño: ").append(mensaje.length()+"\n");
        mensaje.append("Cadenas iguales: ").append(ciudad.equals(ciudad2)+"\n");
        mensaje.append("Ciudad con espacios: ").append(ciudad+"\n");
        mensaje.append("Ciudad sin espacios: ").append(ciudad.trim()+"\n");
        mensaje.append("Mayúsculas: ").append(ciudad2.toUpperCase()+"\n");
        mensaje.append("Minúsculas: ").append(ciudad2.toLowerCase()+"\n");
        String nombre = "\"1\",\"24060008\",\"ABARCA  VAZQUEZ  YULIANA\",\"Elija una OpciónSNJR\",\"INGENIERÍA EN TECNOLOGÍAS DE LA INFORMACIÓN Y COMUNICACIONES\"";
        String[] nuevaCadena = nombre.split(",");
        
        StringBuilder mensaje2 = new StringBuilder();
        for (String n : nuevaCadena) {
            mensaje2.append(n.replaceAll("\"", "")).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje2);
        
       mensaje2.delete(0, mensaje2.capacity());
        boolean bandera=true;
        for (int i = 0; i <ciudad2.length(); i++) {
            if (bandera) {
                mensaje2.append(Character.toUpperCase(ciudad2.charAt(i)));
                bandera = false;
            }else{
                mensaje2.append(Character.toLowerCase(ciudad2.charAt(i)));
                bandera = true;
            }
        }
       JOptionPane.showMessageDialog(null, mensaje2);
    }
}
