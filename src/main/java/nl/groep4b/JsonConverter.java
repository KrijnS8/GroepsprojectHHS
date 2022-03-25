package nl.groep4b;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.groep4b.beans.StudentBean;

import java.io.File;
import java.io.IOException;

public class JsonConverter {
    /*
        This class is used to convert an object into json or json back into an object
     */

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void objectToJson(Object object, String filePath) {
        // Create file at given path
        File file = new File("data\\" + filePath);
        try {
            // Try to write value of object "object" to file "file"
            MAPPER.writeValue(file, object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentBean jsonToStudentBean(String filePath) {
        // Create file at given path
        File file = new File("data\\" + filePath);
        try {
            // Try to read json file and return data in StudentBean instance
            return MAPPER.readValue(file, StudentBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return empty StudentBean instance
        return new StudentBean();
    }

    public static <T> Object jsonToObject(String filePath, Class<T> objectType) {
        // Create file at given path
        File file = new File("data\\" + filePath);
        try {
            // Try to read json file and return data in an instance of given object type
            return MAPPER.readValue(file, objectType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return empty Object instance
        return new Object();
    }
}
