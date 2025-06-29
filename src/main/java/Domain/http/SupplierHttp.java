package Domain.http;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public record SupplierHttp
        (Long id, @NotEmpty String name, @NotEmpty String phone, @NotEmpty String email)
        implements Serializable {
}
