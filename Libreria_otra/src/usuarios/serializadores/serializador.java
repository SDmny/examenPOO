package usuarios.serializadores;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public abstract class UsuarioSerializer {
    /**
     * Serialización de datos
     *
     * Se encarga de serializar los datos de JAVA y convertirlos a un JSON
     *
     * @throws FileNotFoundException Si el archivo no puede crearse debido a que el directorio no exista
     * @throws IOException Alguna excpeción de lectura
     * @throws Exception Otras excepciones
     */
    public static void serialize() {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(Sistema.usuarios, writer);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}