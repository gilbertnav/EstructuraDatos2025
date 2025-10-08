
package estructuradatos.e2estructuradinamica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class OpArchivo {
    private static String pathAlumnos = "c:\\sistema\\alumnos_SIGEA.csv";
    private static String pathCarpeta = "c:\\sistema";
    private static File carpeta, archivo;
    
    public static void cargarDatos() throws FileNotFoundException, IOException {
        FileReader frAlumno = new FileReader(pathAlumnos);
        BufferedReader brAlumno = new BufferedReader(frAlumno);
        Alumno alumno;
        //Mientras existan datos a leer en el archivo
        boolean esPrimeraLinea = true; 
        //String datos;
        String[] detalleDatos;
        StringBuilder datosLimpios = new StringBuilder();
        while(brAlumno.ready()){
           
            if (!esPrimeraLinea) {
                 alumno = new Alumno();
                 datosLimpios.setLength(0);
                //Leemos los datos del archivo y lo limpiamos
                datosLimpios.append(brAlumno.readLine().replaceAll("\"", ""));
                //Separamos los datos limpios para procesarlos
                detalleDatos= datosLimpios.toString().split(",");
                //Guardamos solo los datos que nos interesan en el objeto
                alumno.setMatricula(detalleDatos[1]);
                alumno.setNombre(detalleDatos[4]);
                alumno.setApPaterno(detalleDatos[2]);
                alumno.setApMaterno(detalleDatos[3]);
                alumno.setCarrera(detalleDatos[6]);
                //Guardamos el objeto en la lista
                OpAlumno.listaAlumnos.add(alumno);
            }else{
                esPrimeraLinea=false;
                brAlumno.readLine();
            }
        }
        frAlumno.close();
        brAlumno.close();
    }
    
}
