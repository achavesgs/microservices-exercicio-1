package br.com.fiap.exercicio1.exception;

//import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;



public class Exceptions {

    public static String generateMessage(String entity, Map<String, String> searchParams) {
        return String.format("%s was not found for parameters %s",
                StringUtils.capitalize(entity), searchParams);
    }

    public static <K, V> Map<K, V> toMap(Class<K> keyType, Class<V> valueType, String... entries) {
        if (entries.length % 2 == 1) {
            throw new IllegalArgumentException("Invalid entries");
        }
        return IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
    }
}




