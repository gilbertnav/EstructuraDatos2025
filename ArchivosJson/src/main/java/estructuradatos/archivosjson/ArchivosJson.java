package estructuradatos.archivosjson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ArchivosJson {
    public static List<Paciente> listaPacientes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//        Paciente paciente = new Paciente();
//        paciente.setExpediente(12);
//        paciente.setNombre("Luis");
//        paciente.setApPaterno("Galeana");
//        paciente.setApMaterno("Jimenez");
//        paciente.setEdad(21);
//        paciente.setEstatura(1.65f);
//        paciente.setPeso(67);
//        paciente.setSexo('M');
//        paciente.setEliminado(false);
//        
//        listaPacientes.add(paciente);
//       
//        paciente = new Paciente();
//        paciente.setExpediente(10);
//        paciente.setNombre("Laura");
//        paciente.setApPaterno("Galeana");
//        paciente.setApMaterno("Jimenez");
//        paciente.setEdad(22);
//        paciente.setEstatura(1.60f);
//        paciente.setPeso(60);
//        paciente.setSexo('F');
//        paciente.setEliminado(false);
//        
//        listaPacientes.add(paciente);
        
        ArchivoJson archivoJson = new ArchivoJson();
        listaPacientes = archivoJson.leer("c:\\sistema\\paciente.json");
        //archivoJson.guardar(listaPacientes, "c:\\sistema\\paciente.json"); StringBuilder mensaje = new StringBuilder();
         StringBuilder mensaje = new StringBuilder();
        mensaje.append("Exp.       N O M B R E        EDAD   ESTATURA   PESO   SEXO\n");
        mensaje.append("____________________________________________________________\n");
        for (Paciente paciente : listaPacientes) {
             if (!paciente.isEliminado()) {
                mensaje.append(paciente.getExpediente() +"----");
                mensaje.append(paciente.getNombre() + " ");
                mensaje.append(paciente.getApPaterno() +" ");
                mensaje.append(paciente.getApMaterno() + " ---- ");
                mensaje.append(paciente.getEdad()+" años ---- ");
                mensaje.append(paciente.getEstatura()+ " m ---- ");
                mensaje.append(paciente.getPeso()+ " Kg. ---- ");
                mensaje.append(paciente.getSexo()).append("\n");
            }
        }              
        JOptionPane.showMessageDialog(null, mensaje);
        
        
    }
}
