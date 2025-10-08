package poo.e20estadisticaArchivo;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OpPaciente {

    //Almacena la posicion de los pacientes dentro del arreglo
    public static int pos = -1;
    //Declaración del objeto
    private Paciente paciente;
    //Para poder accederlo desde cualquier clase
    //se comporta como una variable global del sistema
    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private int expediente;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private int edad;
    private float estatura;
    private float peso;
    private char sexo;

    public void crearExpediente() throws IOException {
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente"));
        int posEnc;
        posEnc = buscarPaciente(expediente);
        if (posEnc == -1) {
            paciente = new Paciente();
            //Guardar valores en variables locales

            nombre = JOptionPane.showInputDialog("Nombre");
            apPaterno = JOptionPane.showInputDialog("Apellido Paterno");
            apMaterno = JOptionPane.showInputDialog("Apellido Materno");
            edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
            estatura = Float.parseFloat(JOptionPane.showInputDialog("Estatura"));
            peso = Float.parseFloat(JOptionPane.showInputDialog("Peso"));
            sexo = JOptionPane.showInputDialog("Sexo").charAt(0);

            //Guardar valores en el objeto
            paciente.setExpediente(expediente);
            paciente.setNombre(nombre);
            paciente.setApPaterno(apPaterno);
            paciente.setApMaterno(apMaterno);
            paciente.setEdad(edad);
            paciente.setEstatura(estatura);
            paciente.setPeso(peso);
            paciente.setSexo(sexo);
            //Aumentamos en 1 el valor de pos
            pos++;
            //Guardamos el objeto en el arreglo
            listaPacientes.add(paciente);
            //Guardando el arreglo en el archivo
            OpArchivo.guardarExpediente();
            JOptionPane.showMessageDialog(null, "Expediente generado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "El expediente ya existe");
        }
    }

    public void consultarPaciente() {
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

    private int buscarPaciente(int expediente) {
        //Posición donde encuentre el expediente en el arreglo
        int posEnc = -1;
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (listaPacientes.get(i).getExpediente() == expediente &&
                !listaPacientes.get(i).isEliminado()    ) {
                posEnc = i;
            }
        }
        return posEnc;
    }
 /*   
    private int buscarPacienteEliminado(int expediente) {
        //Posición donde encuentre el expediente en el arreglo
        int posEnc = -1;
        for (int i = 0; i <= pos; i++) {
            if (listaPacientes[i].getExpediente() == expediente &&
                listaPacientes[i].isEliminado()    ) {
                posEnc = i;
            }
        }
        return posEnc;
    }

    public void consultaIndividual() {
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente"));
        int posEnc;
        posEnc = buscarPaciente(expediente);
        if (posEnc != -1) {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("No de Expediente: ").append(listaPacientes[posEnc].getExpediente()).append("\n");
            mensaje.append("N o m b r e     : ").append(listaPacientes[posEnc].getNombre()).append("\n");
            mensaje.append("Apellido Paterno: ").append(listaPacientes[posEnc].getApPaterno()).append("\n");
            mensaje.append("Apellido Materno: ").append(listaPacientes[posEnc].getApMaterno()).append("\n");
            mensaje.append("E  d  a  d      : ").append(listaPacientes[posEnc].getEdad()).append("\n");
            mensaje.append("E s t a t u r a : ").append(listaPacientes[posEnc].getEstatura()).append("\n");
            mensaje.append("P  e  s  o      : ").append(listaPacientes[posEnc].getPeso()).append("\n");
            mensaje.append("S  e  x  o      : ").append(listaPacientes[posEnc].getSexo()).append("\n");
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "El expediente no existe");
        }
    }

    public void modificarPaciente() {
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente a modificar"));
        int posEnc;
        posEnc = buscarPaciente(expediente);
        if (posEnc != -1) {
            StringBuilder menu = new StringBuilder();
            int opc;
            do {
                menu.delete(0, menu.capacity());
                menu.append("Exp. Num. ").append(listaPacientes[posEnc].getExpediente() + "\n");
                menu.append("[1] Nombre: ").append(listaPacientes[posEnc].getNombre() + "\n");
                menu.append("[2] Ap Paterno: ").append(listaPacientes[posEnc].getApPaterno() + "\n");
                menu.append("[3] Ap Materno: ").append(listaPacientes[posEnc].getApMaterno() + "\n");
                menu.append("[4] Edad: ").append(listaPacientes[posEnc].getEdad() + "\n");
                menu.append("[5] Estatura: ").append(listaPacientes[posEnc].getEstatura() + "\n");
                menu.append("[6] Sexo: ").append(listaPacientes[posEnc].getSexo() + "\n");
                menu.append("[7] Peso: ").append(listaPacientes[posEnc].getPeso() + "\n");
                menu.append("[8] Salir \n\n ");
                menu.append("Elige una opción ");
                opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opc) {
                    case 1:
                        nombre = JOptionPane.showInputDialog("Nombre");
                        listaPacientes[posEnc].setNombre(nombre);
                        break;
                    case 2:
                        apPaterno = JOptionPane.showInputDialog("Apellido paterno");
                        listaPacientes[posEnc].setApPaterno(apPaterno);
                        break;
                    case 3:
                        apMaterno = JOptionPane.showInputDialog("Apellido materno");
                        listaPacientes[posEnc].setApMaterno(apMaterno);
                        break;
                }
            } while (opc != 8);
        }else{
            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
        }

    }
    
    public void bajaTemporal(){
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente a eliminar"));
        int posEnc;
        posEnc = buscarPaciente(expediente);
        if (posEnc != -1) {
            listaPacientes[posEnc].setEliminado(true);
            JOptionPane.showMessageDialog(null, "Expediente eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
        }
    }
    
    public void restaurarExpediente(){
        
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Exp.   N O M B R E\n");
        for (int i = 0; i <= pos; i++) {
            if (listaPacientes[i].isEliminado()) {
                mensaje.append(listaPacientes[i].getExpediente() + "-------");
                mensaje.append(listaPacientes[i].getNombre() + " ");
                mensaje.append(listaPacientes[i].getApPaterno()+ " ");
                mensaje.append(listaPacientes[i].getApMaterno()+ "\n");
            }
        }
        mensaje.append("\nExpediente a restaurar...");
        expediente = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        int posEnc;
        posEnc = buscarPacienteEliminado(expediente);
        if (posEnc != -1) {
            listaPacientes[posEnc].setEliminado(false);
            JOptionPane.showMessageDialog(null, "Expediente restaurado");
        }else{
            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
        }
    }
    
    public void eliminarExpediente(){
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente a eliminar"));
        int posEnc;
        posEnc = buscarPaciente(expediente);
        if (posEnc != -1) {
            //Si el expedientes es el último registrado en el  arreglo
            if (posEnc == pos) {
                listaPacientes[posEnc] = null;
                pos--;
            }else{
                for (int i = posEnc+1; i <=pos; i++) {
                    listaPacientes[i-1]=listaPacientes[i];
                }
                listaPacientes[pos] = null;
                pos--;
            }
            JOptionPane.showMessageDialog(null, "Expediente eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
        }
    }
    //Elimina los expedientes con baja temporal
    public void limpiarExpedientes(){
        int noEliminados=0;
        //Cuenta cuantos registros no están eliminados
        for (int i = 0; i <=pos; i++) {
            if (!listaPacientes[i].isEliminado()) 
                noEliminados++;
        }
        //Creamos arregloAux para los registros que no esté eliminados
        Paciente[] arregloAux = new Paciente[noEliminados];
        int indice=0;
        for (int i = 0; i <=pos; i++) {
            //Si el registro no está eliminado lo guardamos arregloAux
            if (!listaPacientes[i].isEliminado()) 
               arregloAux[indice++] = listaPacientes[i];
        }
        //Copiamos el arregloAux al arreglo original
        listaPacientes = arregloAux;
        //modificamos el valor de pos de acuerdo el numero de
        //registros que no estén eliminados.
        pos =noEliminados -1;
    }
*/
}
