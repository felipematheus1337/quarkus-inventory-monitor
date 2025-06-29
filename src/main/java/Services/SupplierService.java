package Services;

import Domain.Supplier;
import Domain.http.SupplierHttp;
import Exceptions.ResourceNotFoundException;
import Mapper.SupplierMapper;
import Repositories.GenericRepository;
import Utils.BusinessUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class SupplierService {

    private final GenericRepository<Supplier> repository;
    private final SupplierMapper mapper;
    private final SupplierCacheService cacheService;

    @Inject
    public SupplierService(GenericRepository<Supplier>supplierRepository, SupplierMapper mapper, SupplierCacheService cacheService) {
        this.repository = supplierRepository;
        this.mapper = mapper;
        this.cacheService = cacheService;
    }

    @Transactional
    public void create(SupplierHttp supplierHttp) {
        Supplier supplierToCreate = this.mapper.toEntity(supplierHttp);
        this.repository.persist(supplierToCreate);
        cacheService.put(supplierToCreate);
    }

    @Transactional
    public void delete(Long id) {
        this.repository.deleteById(id);
        cacheService.invalidate(id);
    }

    public SupplierHttp get(Long id) {
        Optional<Supplier> cached = cacheService.get(id);
        if (cached.isPresent()) return mapper.toDto(cached.get());

        Supplier entity = getEntity(id);
        if (entity == null) throw new ResourceNotFoundException(BusinessUtils.SUPPLIER_NOT_FOUND_MESSAGE + "Id: " + id);

        cacheService.put(entity);
        return mapper.toDto(entity);
    }

    protected Supplier getEntity(Long id) {
        return repository.findById(id);
    }

    @Transactional
    protected void persist(Supplier supplier) {
        this.repository.persist(supplier);
    }

}
