package nl.groep4b;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonConverter {
    /*
        This class is used to convert an object into json or json back into an object
     */

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void objectToJson(Object object, String filePath) {
        // Create file at given path
        File file = new File(filePath);
        try {
            // Try to write value of object "object" to file "file"
            MAPPER.writeValue(file, object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T jsonToObject(String filePath, Class<T> objectType) {
        // Create file at given path
        File file = new File(filePath);
        try {
            // Try to read json file and return data in an instance of given object type
            return MAPPER.readValue(file, objectType);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
