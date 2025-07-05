package Event;

import Utils.BusinessUtils;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.vertx.ConsumeEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.concurrent.CompletableFuture;

import static Utils.BusinessUtils.MTR_ITEM_TOTAL;

@ApplicationScoped
public class ItemEventConsumer {

    private final MeterRegistry meterRegistry;

    @Inject
    public ItemEventConsumer(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @ConsumeEvent("item-lote")
    public void countPedidosEmLote(Integer total) {
        Counter counter = meterRegistry.counter(MTR_ITEM_TOTAL);
        counter.increment(total);
    }


}
