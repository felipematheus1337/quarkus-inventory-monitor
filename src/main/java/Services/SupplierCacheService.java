package Services;

import Domain.Supplier;


import io.quarkus.redis.client.RedisClient;
import io.vertx.core.json.Json;
import io.vertx.redis.client.Response;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.quarkus.redis.client.*;

import java.util.Arrays;
import java.util.Optional;

@ApplicationScoped
public class SupplierCacheService {

    private static final Long TTL_SECONDS = 600L;
    private static final String SUPPLIER_KEY_STR = "supplier:";
    private final RedisClient redis;

    @Inject
    public SupplierCacheService(RedisClient redis) {
        this.redis = redis;
    }

    private String key(Long id) {
        return SUPPLIER_KEY_STR + id;
    }

    public Optional<Supplier> get(Long id) {
        String key = key(id);
        Response response =  redis.get(key);
        if (response == null) return Optional.empty();
        String json = response.toString();
        return Optional.of(Json.decodeValue(json, Supplier.class));
    }

    public void put(Supplier supplier) {
        String key = key(supplier.getId());
        String json = Json.encode(supplier);
        redis.setex(key, TTL_SECONDS.toString(), json);
    }

    public void invalidate(Long id) {
        redis.del(Arrays.asList(key(id)));
    }

}
