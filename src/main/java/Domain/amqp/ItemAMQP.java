package Domain.amqp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemAMQP(String name, Integer actualQuantity, Integer minimalQuantity, LocalDateTime createdAt,
                       LocalDateTime updatedAt, BigDecimal price) {
}
