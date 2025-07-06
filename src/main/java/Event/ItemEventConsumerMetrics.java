package Event;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.vertx.ConsumeEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import static Utils.BusinessUtils.MTR_ITEM_TOTAL;

@ApplicationScoped
public class ItemEventConsumerMetrics {

    private final MeterRegistry meterRegistry;

    @Inject
    public ItemEventConsumerMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @ConsumeEvent("item-lote")
    public void countPedidosEmLote(Integer total) {
        Counter counter = meterRegistry.counter(MTR_ITEM_TOTAL);
        counter.increment(total);
    }


}
