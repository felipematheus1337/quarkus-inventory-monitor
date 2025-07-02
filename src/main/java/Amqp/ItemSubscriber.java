package Amqp;

import Domain.amqp.ItemAMQP;
import Services.ItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.List;

@ApplicationScoped
public class ItemSubscriber {

    @Inject
    private ItemService itemService;

    @Incoming("receber-itens")
    public void consumir(String payload) {
        ObjectMapper mapper = new ObjectMapper();
        List<ItemAMQP> itens = mapper.convertValue(mapper, new TypeReference<List<ItemAMQP>>(){});
        itemService.consume(itens);
    }
}
