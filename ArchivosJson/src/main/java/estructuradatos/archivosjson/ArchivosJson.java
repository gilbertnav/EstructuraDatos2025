package estructuradatos.archivosjson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivosJson {
    public static List<Paciente> listaPacientes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Paciente paciente = new Paciente();
        paciente.setExpediente(12);
        paciente.setNombre("Luis");
        paciente.setApPaterno("Galeana");
        paciente.setApMaterno("Jimenez");
        paciente.setEdad(21);
        paciente.setEstatura(1.65f);
        paciente.setPeso(67);
        paciente.setSexo('M');
        paciente.setEliminado(false);
        
        listaPacientes.add(paciente);
       
        paciente = new Paciente();
        paciente.setExpediente(10);
        paciente.setNombre("Laura");
        paciente.setApPaterno("Galeana");
        paciente.setApMaterno("Jimenez");
        paciente.setEdad(22);
        paciente.setEstatura(1.60f);
        paciente.setPeso(60);
        paciente.setSexo('F');
        paciente.setEliminado(false);
        
        listaPacientes.add(paciente);
        
        ArchivoJson archivoJson = new ArchivoJson();
        
        archivoJson.guardar(listaPacientes, "c:\\sistema\\paciente.json");
    }
}
