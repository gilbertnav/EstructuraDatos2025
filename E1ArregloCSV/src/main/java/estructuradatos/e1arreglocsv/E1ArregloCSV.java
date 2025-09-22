package estructuradatos.e1arreglocsv;

import javax.swing.JOptionPane;

public class E1ArregloCSV {
    public static void main(String[] args) {
        String nombre ="\"1\",\"24060008\",\"ABARCA,VAZQUEZ,YULIANA\",\"Elija una OpciónSNJR\",\"INGENIERÍA EN TECNOLOGÍAS DE LA INFORMACIÓN Y COMUNICACIONES\"";
        String[] listaAlumnos = nombre.split(",");
        
        StringBuilder datosAlumno = new StringBuilder();
        
        //Llenar a datosAlumnos con los datos guardados
        //en el arreglo listaAlumnos
        for (String dato : listaAlumnos) {
            datosAlumno.append(dato.replaceAll("\"", "")).append("\n");
        }
        JOptionPane.showMessageDialog(null, datosAlumno);
        
        //datosAlumno.setLength(0); //Limpiar el buffer
    }
}
