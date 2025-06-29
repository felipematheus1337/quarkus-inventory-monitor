package Repositories;

import Domain.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ItemRepository extends PanacheRepository<Item> {
}
