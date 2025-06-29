package Services;

import Domain.Item;
import Domain.Supplier;
import Domain.http.ItemHttp;
import Exceptions.ResourceNotFoundException;
import Mapper.ItemMapper;
import Repositories.GenericRepository;
import Utils.BusinessUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ItemService {

    private final SupplierService supplierService;
    private final ItemMapper mapper;
    private final GenericRepository<Item> repository;

    @Inject
    public ItemService(SupplierService supplierService, ItemMapper mapper, GenericRepository<Item> repository) {
        this.supplierService = supplierService;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Transactional
    public void createItem(ItemHttp itemHttp) {
        Item item = mapper.toEntity(itemHttp);

        Supplier supplier = this.supplierService.getEntity(itemHttp.supplierId());

        if (supplier == null)
            throw new ResourceNotFoundException(BusinessUtils.SUPPLIER_NOT_FOUND_MESSAGE +
                    "Id: " + itemHttp.supplierId());

        supplier.addItem(item);

        this.supplierService.persist(supplier);
    }

    public ItemHttp getById(Long id) {
        return this.repository.findByIdOptional(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(
                        BusinessUtils.SUPPLIER_NOT_FOUND_MESSAGE + "Id: " + id));
    }

    @Transactional
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
