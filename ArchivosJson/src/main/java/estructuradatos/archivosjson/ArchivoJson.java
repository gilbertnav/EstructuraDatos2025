package estructuradatos.archivosjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoJson<T> implements IArchivo<T> {
    @Override
    public void guardar(List<T> datos, String rutaArchivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(datos, writer);
            System.out.println("Archivo JSON guardado en: " + rutaArchivo);
        }
    }
}
