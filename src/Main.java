import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "val1");
        map.put("key2", "val2");

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(json);
    }
}
