package Amqp;

import Domain.amqp.SupplierAMQP;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class SupplyNotificationProducer {

    @Inject
    @Channel("gerar-notificacao")
    private Emitter<SupplierAMQP> emitter;

    public void enviarNotificacao(SupplierAMQP supplierAMQP) throws JsonProcessingException {
        emitter.send(supplierAMQP);
    }

}
