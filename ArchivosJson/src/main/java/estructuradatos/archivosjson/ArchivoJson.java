package estructuradatos.archivosjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArchivoJson<T> implements IArchivo<T> {

    
     @Override
    public void guardar(ArrayList<T> datos, String rutaArchivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(datos, writer);
            System.out.println("Archivo JSON guardado en: " + rutaArchivo);
        }
    }

    @Override
    public ArrayList<T> leer(String rutaArchivo, Class<T> tipo) throws IOException {
        ArrayList<T> pacientes=null;
        try (FileReader reader = new FileReader(rutaArchivo)) {
            // 3. Crear una instancia de Gson
            Gson gson = new Gson();
            // Si el JSON es una lista de objetos Persona
            Type listOfPersonType = new TypeToken<ArrayList<tipo>>() {}.getType();
            pacientes = gson.fromJson(reader, listOfPersonType);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
}
