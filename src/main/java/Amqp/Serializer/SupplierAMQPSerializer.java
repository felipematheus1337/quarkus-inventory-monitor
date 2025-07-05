package Amqp.Serializer;

import Domain.amqp.SupplierAMQP;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class SupplierAMQPSerializer implements Serializer<SupplierAMQP> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, SupplierAMQP supplierAMQP) {
        try {
            return mapper.writeValueAsBytes(supplierAMQP);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error in the Supplier Serializer.", e);
        }
    }
}
