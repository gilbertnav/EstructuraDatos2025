
package estructuradatos.archivosjson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public interface IArchivo<T> {
    void guardar(ArrayList<T> datos, String rutaArchivo) throws IOException;
    ArrayList<T> leer(String rutaArchivo) throws IOException;
}
