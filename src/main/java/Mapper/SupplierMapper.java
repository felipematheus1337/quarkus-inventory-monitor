package Mapper;

import Domain.Supplier;
import Domain.http.SupplierHttp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "jakarta-cdi")
public interface SupplierMapper {

    SupplierHttp toDto(Supplier supplier);

    Supplier toEntity(SupplierHttp dto);

    List<SupplierHttp> toDto(List<Supplier> suppliers);

}
