
package estructuradatos.archivosjson;

import java.io.IOException;
import java.util.List;

public interface IArchivo<T> {
    void guardar(List<T> datos, String rutaArchivo) throws IOException;
    List<T> readFromJson(String rutaArchivo) throws IOException;
}
