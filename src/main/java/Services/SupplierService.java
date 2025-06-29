package Services;

import Domain.Supplier;
import Domain.http.SupplierHttp;
import Mapper.SupplierMapper;
import Repositories.SupplierRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper mapper;

    @Inject
    public SupplierService(SupplierRepository supplierRepository, SupplierMapper mapper) {
        this.supplierRepository = supplierRepository;
        this.mapper = mapper;
    }

    @Transactional
    public void create(SupplierHttp supplierHttp) {
        Supplier supplierToCreate = this.mapper.toEntity(supplierHttp);
        this.supplierRepository.persist(supplierToCreate);
    }

    @Transactional
    public void delete(Long id) {
        this.supplierRepository.deleteById(id);
    }

    public SupplierHttp get(Long id) {
        Optional<Supplier> optSupplier =  this.supplierRepository.findByIdOptional(id);

        if (optSupplier.isPresent())
            return mapper.toDto(optSupplier.get());

        return null;
    }



}
