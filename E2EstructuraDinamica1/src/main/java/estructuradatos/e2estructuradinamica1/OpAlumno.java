package estructuradatos.e2estructuradinamica1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OpAlumno {

    private static Alumno alumno;
    private static String matricula;
    private static String nombre;
    private static String apPaterno;
    private static String apMaterno;
    private static String carrera;
    public static ArrayList<Alumno> listaAlumnos = new ArrayList<>();

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
    
    private static int buscarAlumno(String matricula){
        int posEnc = -1;
        int indice=0;
        for (Alumno alum : listaAlumnos) {
            if (alum.getMatricula().equals(matricula)){
                posEnc = indice;
            }
            indice++;
        }
        return posEnc;
    }
    
    public static void consultaIndividual(){
        String matricula;
        matricula = JOptionPane.showInputDialog("Matricula a buscar");
        int pos = buscarAlumno(matricula);
        if (pos != -1) {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append(listaAlumnos.get(pos).getMatricula() +"\n");
            mensaje.append(listaAlumnos.get(pos).getNombre()+"\n");
            JOptionPane.showMessageDialog(null, mensaje);
        }else{
            JOptionPane.showMessageDialog(null, "Matricula no encontrada");
        }
    }
    
    public static void agregarAlumno(){
        matricula = JOptionPane.showInputDialog("Matricula:");
        int pos = buscarAlumno(matricula);
        if (pos == -1) {
            alumno = new Alumno();
            nombre = JOptionPane.showInputDialog("Nombre:");
            apPaterno = JOptionPane.showInputDialog("Apellido paterno:");
            apMaterno = JOptionPane.showInputDialog("Apellido materno:");
            carrera = JOptionPane.showInputDialog("Carrera");
            //Guardamos dentro del objeto
            alumno.setMatricula(matricula);
            alumno.setNombre(nombre);
            alumno.setApPaterno(apPaterno);
            alumno.setApMaterno(apMaterno);
            alumno.setCarrera(carrera);
            //Agregamos el alumno a la lista
            listaAlumnos.add(alumno);
            //Guardar objeto dentro del archivo alumnos_SIGEA
        }else{
            JOptionPane.showMessageDialog(null, "La matricula ya está registrada");
        }
        
    }
}
