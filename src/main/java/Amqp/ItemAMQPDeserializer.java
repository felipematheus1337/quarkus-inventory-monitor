package Amqp;

import Domain.amqp.ItemAMQP;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;

public class ItemAMQPDeserializer implements Deserializer<List<ItemAMQP>> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<ItemAMQP> deserialize(String topic, byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        try {
            return mapper.readValue(bytes, new TypeReference<List<ItemAMQP>>() {});
        } catch (Exception e) {
            Log.error("Erro ao deserializar ItemAMQP: " + e.getMessage(), e);
            return null;
        }
    }
}
