package poo.e20estadisticaArchivo;

import java.io.IOException;
import java.util.Stack;
import javax.swing.JOptionPane;

public class OpPaciente {

    //Almacena la posicion de los pacientes dentro del arreglo
    public static int pos = -1;
    //Declaración del objeto
    private Paciente paciente;
    //Para poder accederlo desde cualquier clase
    public static Stack<Paciente> pilaPacientes = new Stack<>();
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
        if (buscarPaciente(expediente) == null) {
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
            //Guardamos el objeto en la pila
            pilaPacientes.push(paciente);
            //Guardando el arreglo en el archivo
            OpArchivo.guardarExpediente();
            JOptionPane.showMessageDialog(null, "Expediente generado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "El expediente ya existe");
        }
    }

    //Consuta general de los expedientes
    public void consultarPaciente() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Exp.       N O M B R E        EDAD   ESTATURA   PESO   SEXO\n");
        mensaje.append("____________________________________________________________\n");
        //Se crea la pila auxiliar
        Stack<Paciente> pilaAux = new Stack<>();
        //Se repite mientras la pilaPacientes no esté vacía
        while (!pilaPacientes.empty()) {
            //Quitamos el elmento de la cima y lo agregamos a la pila auxiliar
            pilaAux.push(pilaPacientes.pop());
            //Si elemento de la cima de la pila auxiliar no está eliminado
            //agregamos los datos al la variable mensaje
            if (!pilaAux.peek().isEliminado()) {
                //Obtenemos los valores de la cima sin eliminarlos
                mensaje.append(pilaAux.peek().getExpediente() + "----");
                mensaje.append(pilaAux.peek().getNombre() + " ");
                mensaje.append(pilaAux.peek().getApPaterno() + " ");
                mensaje.append(pilaAux.peek().getApMaterno() + " ---- ");
                mensaje.append(pilaAux.peek().getEdad() + " años ---- ");
                mensaje.append(pilaAux.peek().getEstatura() + " m ---- ");
                mensaje.append(pilaAux.peek().getPeso() + " Kg. ---- ");
                mensaje.append(pilaAux.peek().getSexo()).append("\n");
            }
        }
        //Devolvemos los valores de la pilaAux a pilaPacientes
        while (!pilaAux.empty()) {
            pilaPacientes.push(pilaAux.pop());
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private Paciente buscarPaciente(int expediente) {
        Paciente pacienteEncontrado = null;
            Stack<Paciente> pilaAux = new Stack<>();
            while (!pilaPacientes.empty()) {
                if (pilaPacientes.peek().getExpediente() == expediente
                        && !pilaPacientes.peek().isEliminado()) {
                    pacienteEncontrado = pilaPacientes.peek();
                    break;
                }
                pilaAux.push(pilaPacientes.pop());
            }
            //Devolvemos los valores de la pilaAux a pilaPacientes
            while (!pilaAux.empty()) {
                pilaPacientes.push(pilaAux.pop());
            }
        return pacienteEncontrado;
    }

    private int buscarPacienteEliminado(int expediente) {
        //Posición donde encuentre el expediente en el arreglo
        int posEnc = -1;
        for (int i = 0; i < pilaPacientes.size(); i++) {
            if (pilaPacientes.get(i).getExpediente() == expediente
                    && pilaPacientes.get(i).isEliminado()) {
                posEnc = i;
            }
        }
        return posEnc;
    }

    public void consultaIndividual() {
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente"));
        Paciente pacienteEnc = buscarPaciente(expediente);
        if (pacienteEnc != null) {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("No de Expediente: ").append(pacienteEnc.getExpediente()).append("\n");
            mensaje.append("N o m b r e     : ").append(pacienteEnc.getNombre()).append("\n");
            mensaje.append("Apellido Paterno: ").append(pacienteEnc.getApPaterno()).append("\n");
            mensaje.append("Apellido Materno: ").append(pacienteEnc.getApMaterno()).append("\n");
            mensaje.append("E  d  a  d      : ").append(pacienteEnc.getEdad()).append("\n");
            mensaje.append("E s t a t u r a : ").append(pacienteEnc.getEstatura()).append("\n");
            mensaje.append("P  e  s  o      : ").append(pacienteEnc.getPeso()).append("\n");
            mensaje.append("S  e  x  o      : ").append(pacienteEnc.getSexo()).append("\n");
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "El expediente no existe");
        }
    }

    public void modificarPaciente() throws IOException {
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente a modificar"));
        Paciente pacienteEnc = buscarPaciente(expediente);
        if (pacienteEnc != null) {
            StringBuilder menu = new StringBuilder();
            int opc;
            do {
                menu.delete(0, menu.capacity());
                menu.append("Exp. Num. ").append(pacienteEnc.getExpediente() + "\n");
                menu.append("[1] Nombre: ").append(pacienteEnc.getNombre() + "\n");
                menu.append("[2] Ap Paterno: ").append(pacienteEnc.getApPaterno() + "\n");
                menu.append("[3] Ap Materno: ").append(pacienteEnc.getApMaterno() + "\n");
                menu.append("[4] Edad: ").append(pacienteEnc.getEdad() + "\n");
                menu.append("[5] Estatura: ").append(pacienteEnc.getEstatura() + "\n");
                menu.append("[6] Sexo: ").append(pacienteEnc.getSexo() + "\n");
                menu.append("[7] Peso: ").append(pacienteEnc.getPeso() + "\n");
                menu.append("[8] Salir \n\n ");
                menu.append("Elige una opción ");
                opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opc) {
                    case 1:
                        nombre = JOptionPane.showInputDialog("Nombre");
                        pacienteEnc.setNombre(nombre);
                        break;
                    case 2:
                        apPaterno = JOptionPane.showInputDialog("Apellido paterno");
                        pacienteEnc.setApPaterno(apPaterno);
                        break;
                    case 3:
                        apMaterno = JOptionPane.showInputDialog("Apellido materno");
                        pacienteEnc.setApMaterno(apMaterno);
                        break;
                    case 4:
                        edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
                        pacienteEnc.setEdad(edad);
                        break;
                    case 5:
                        estatura = Float.parseFloat((JOptionPane.showInputDialog("Estatura")));
                        pacienteEnc.setEstatura(estatura);
                        break;
                    case 6:
                        sexo = JOptionPane.showInputDialog("Sexo").charAt(0);
                        pacienteEnc.setSexo(sexo);
                        break;
                    case 7:
                        peso = Float.parseFloat(JOptionPane.showInputDialog("Peso"));
                        pacienteEnc.setPeso(peso);
                        break;
                }
            } while (opc != 8);

            Stack<Paciente> pilaAux = new Stack<>();
            while (!pilaPacientes.empty()) {
                if (pilaPacientes.peek().getExpediente() != expediente) {
                    //Si el expediente de la cima es distinto al que deseamo
                    //modificar lo agregamos a la pilaAux y lo eliminamos de la pilaPacentes
                    pilaAux.push(pilaPacientes.pop());
                } else {
                    //Si el se encuntra el expediente a modificar lo eliminamos de la pilaPacientes
                    //y le agregamos el pacienteModificado "pacienteEnc#
                    pilaPacientes.pop();
                    pilaPacientes.push(pacienteEnc);
                    break;
                }
            }
            //Devolvemos los valores de la pilaAux a pilaPacientes
            while (!pilaAux.empty()) {
                pilaPacientes.push(pilaAux.pop());
            }
            OpArchivo.guardarExpediente();
        } else {
            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
        }

    }

//    public void bajaTemporal() throws IOException {
//        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente a eliminar"));
//        int posEnc;
//        posEnc = buscarPaciente(expediente);
//        if (posEnc != -1) {
//            pilaPacientes.get(posEnc).setEliminado(true);
//            JOptionPane.showMessageDialog(null, "Expediente eliminado");
//            OpArchivo.guardarExpediente();
//        } else {
//            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
//        }
//    }
    public void restaurarExpediente() throws IOException {

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Exp.   N O M B R E\n");
        for (int i = 0; i <= pos; i++) {
            if (pilaPacientes.get(i).isEliminado()) {
                mensaje.append(pilaPacientes.get(i).getExpediente() + "-------");
                mensaje.append(pilaPacientes.get(i).getNombre() + " ");
                mensaje.append(pilaPacientes.get(i).getApPaterno() + " ");
                mensaje.append(pilaPacientes.get(i).getApMaterno() + "\n");
            }
        }
        mensaje.append("\nExpediente a restaurar...");
        expediente = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        int posEnc;
        posEnc = buscarPacienteEliminado(expediente);
        if (posEnc != -1) {
            pilaPacientes.get(posEnc).setEliminado(false);
            JOptionPane.showMessageDialog(null, "Expediente restaurado");
            OpArchivo.guardarExpediente();
        } else {
            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
        }
    }

    public void eliminarExpediente() throws IOException {
        expediente = Integer.parseInt(JOptionPane.showInputDialog("Expediente a eliminar"));
        Paciente pacienteEnc = buscarPaciente(expediente);
        Stack<Paciente> pilaAux = new Stack<>();
        if (pacienteEnc != null) {
            while (!pilaPacientes.empty()) {
                if (pilaPacientes.peek().getExpediente() != expediente
                        && !pilaPacientes.peek().isEliminado()) {
                    pilaAux.push(pilaPacientes.pop());

                } else {
                    //Si el paciente a eliminar se encuentra se elimina de la pila
                    //pero no se agrega a pilaAux y se termina el ciclo con el break
                    pilaPacientes.pop();
                    break;
                }
            }
            //Devolvemos los valores de la pilaAux a pilaPacientes
            while (!pilaAux.empty()) {
                pilaPacientes.push(pilaAux.pop());
            }
            //Se guarda la pila en el archivo
            OpArchivo.guardarExpediente();
            JOptionPane.showMessageDialog(null, "Expediente eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Expediente no encontrado");
        }
    }

    //Elimina los expedientes con baja temporal
    public void limpiarExpedientes() throws IOException {
        int eliminados = 0;
        //Borra y cuenta cuantos lod registros eliminados
        for (int i = 0; i < pilaPacientes.size(); i++) {
            if (pilaPacientes.get(i).isEliminado()) {
                eliminados++;
                pilaPacientes.remove(i); //Se elimina el paciente
            }
        }
        OpArchivo.guardarExpediente();
        JOptionPane.showMessageDialog(null, "Se eliminaron " + eliminados + " registros");
    }
}
