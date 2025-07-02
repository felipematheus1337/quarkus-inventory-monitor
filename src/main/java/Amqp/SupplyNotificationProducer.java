package Amqp;

import Domain.amqp.SupplierAMQP;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class SupplyNotificationProducer {

    @Channel("gerar-notificacao")
    private Emitter<String> emitter;

    public void enviarNotificacao(SupplierAMQP supplierAMQP) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(supplierAMQP);
        emitter.send(json);
    }

}
