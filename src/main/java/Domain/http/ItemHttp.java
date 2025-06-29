package Domain.http;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ItemHttp (Long id, @NotEmpty String name,
                        @NotNull Integer actualQuantity,
                        @NotNull Integer minimalQuantity,
                        @Nullable LocalDateTime createdAt,
                        @Nullable LocalDateTime updatedAt,
                        @NotNull Long supplierId) implements Serializable {}
