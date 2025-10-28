package poo.e20estadisticaArchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class OpArchivo {
    private static String pathPacientes = "c:\\sistema\\paciente.txt";
    private static String pathCarpeta = "c:\\sistema";
    private static File carpeta, archivo;
    public static void crearSistema() {
        try {
            carpeta = new File(pathCarpeta);
            archivo = new File(pathPacientes);
            if (!carpeta.exists()) {
                carpeta.mkdir();
                archivo.createNewFile();
                JOptionPane.showMessageDialog(null, "Sistema creado...");
            }else{
                //Si el archivo no está vacío, carga los datos
                //en arregloPacientes
                if (archivo.length() != 0 ) {
                    cargarDatos();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(OpArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void cargarDatos() throws FileNotFoundException, IOException {
        FileReader frPaciente = new FileReader(pathPacientes);
        BufferedReader brPaciente = new BufferedReader(frPaciente);
        Paciente paciente;
        //Mientras existan datos a leer en el archivo
        Stack<Paciente> pilaAux = new Stack<>();
        while(brPaciente.ready()){
            paciente = new Paciente();
            paciente.setExpediente(Integer.parseInt(brPaciente.readLine()));
            paciente.setNombre(brPaciente.readLine());
            paciente.setApPaterno(brPaciente.readLine());
            paciente.setApMaterno(brPaciente.readLine());
            paciente.setEdad(Integer.parseInt(brPaciente.readLine()));
            paciente.setEstatura(Float.parseFloat(brPaciente.readLine()));
            paciente.setPeso(Float.parseFloat(brPaciente.readLine()));
            paciente.setSexo(brPaciente.readLine().charAt(0));
            paciente.setEliminado(Boolean.parseBoolean(brPaciente.readLine()));
            //Se cargan los datos a la pilaAux
            pilaAux.push(paciente);
        }
        //Agregamos los daos a la pilaPacientes
        while(!pilaAux.empty()){
            OpPaciente.pilaPacientes.push(pilaAux.pop());
        }
        frPaciente.close();
        brPaciente.close();
    }
    
    public static void guardarExpediente() throws IOException {
        archivo.delete();
        archivo.createNewFile();
        FileWriter fwExpediente = new FileWriter(pathPacientes, true);
        PrintWriter pwExpediente = new PrintWriter(fwExpediente);
        Stack<Paciente> pilaAux = new Stack<>();
        while(!OpPaciente.pilaPacientes.empty()){
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getExpediente());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getNombre());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getApPaterno());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getApMaterno());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getEdad());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getEstatura());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getPeso());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().getSexo());
            pwExpediente.println(OpPaciente.pilaPacientes.peek().isEliminado());
            //Agregamos los datos a la pilaAux
            pilaAux.push(OpPaciente.pilaPacientes.pop());
        }
        //Devolvemos los valores de la pilaAux a pilaPacientes
        while (!pilaAux.empty()) {
            OpPaciente.pilaPacientes.push(pilaAux.pop());
        }
        pwExpediente.close();
        fwExpediente.close();
           
    }
}
