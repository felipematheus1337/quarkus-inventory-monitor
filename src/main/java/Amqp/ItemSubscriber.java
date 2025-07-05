package Amqp;

import Domain.amqp.ItemAMQP;
import Services.ItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.kafka.IncomingKafkaRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.List;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ItemSubscriber {

    @Inject
    private ItemService itemService;

    @Incoming("receber-itens")
    @RequestScoped
    @ActivateRequestContext
    public CompletionStage<Void> consumir(IncomingKafkaRecord<String, List<ItemAMQP>> payload) {
        List<ItemAMQP> itens = payload.getPayload();
        itemService.consume(itens);
        return payload.ack();
    }
}
