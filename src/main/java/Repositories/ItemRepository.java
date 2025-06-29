package Repositories;

import Domain.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ItemRepository extends PanacheRepository<Item> {
}
