package Repositories;

import Domain.Supplier;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface SupplierRepository extends PanacheRepository<Supplier> {
}
