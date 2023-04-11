package OOP_LR6;

import OOP_LR6.Abiturient.Abiturient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class IO {
    public void writeObjectsJSON(List<Abiturient> abiturients){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("target/abiturients.json"), abiturients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Abiturient> readObjectsJSON(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("target/abiturients.json"), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
