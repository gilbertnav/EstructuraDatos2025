package estructuradatos.e2estructuradinamica1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OpAlumno {

    private static Alumno alumno;
    private String matricula;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String carrera;
    public static ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public static void cargarDatos() {
        alumno = new Alumno();
        String nombre = "\"1\",\"24060008\",\"ABARCA,VAZQUEZ,YULIANA\",\"Elija una OpciónSNJR\",\"INGENIERÍA EN TECNOLOGÍAS DE LA INFORMACIÓN Y COMUNICACIONES\"";
        String[] datosAlumno = nombre.split(",");
        alumno.setMatricula(datosAlumno[1]);
        alumno.setNombre(datosAlumno[4]);
        alumno.setApPaterno(datosAlumno[2]);
        alumno.setApMaterno(datosAlumno[3]);
        alumno.setCarrera(datosAlumno[6]);
        //Agregando el objeto a la lista
        listaAlumnos.add(alumno);
        
        nombre = "\"2\",\"24060001\",\"ALVARADO,BUSTOS,EDSON ALEXANDER\",\"Elija una OpciónSNJR\",\"INGENIERÍA EN TECNOLOGÍAS DE LA INFORMACIÓN Y COMUNICACIONES\"";
        datosAlumno = nombre.split(",");
        alumno = new Alumno();
        alumno.setMatricula(datosAlumno[1]);
        alumno.setNombre(datosAlumno[4]);
        alumno.setApPaterno(datosAlumno[2]);
        alumno.setApMaterno(datosAlumno[3]);
        alumno.setCarrera(datosAlumno[6]);
        //Agregando el objeto a la lista
        listaAlumnos.add(alumno);
    }

    public static void consultarAlumnos() {
        StringBuilder mensaje = new StringBuilder();
        for (Alumno alum : listaAlumnos) {
            mensaje.append(alum.getMatricula()).append("--");
            mensaje.append(alum.getNombre()).append("--");
            mensaje.append(alum.getApPaterno()).append("--");
            mensaje.append(alum.getApMaterno()).append("--");
            mensaje.append(alum.getCarrera()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
