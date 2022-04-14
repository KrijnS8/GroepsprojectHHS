package nl.groep4b.Menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonConverter {
    /**
     * This class is used to convert an object into json or json back into an object
     */

    //Variables:
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //Methods:
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

    public static <T> ArrayList<T> jsonToObjectArrayList(String filePath, Class<T> objectType) {
        // Create file at given path
        File file = new File(filePath);
        try {
            // Try to read json file and return data in an instance of given object type
            CollectionType listType =
                    MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, objectType);
            return MAPPER.readValue(file, listType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
