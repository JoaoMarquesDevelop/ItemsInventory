package joao.academy.inventory.domain.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;


/**
 * Request sent by super user
 */
@Data
public class ProductRequestDTO {
    
    @NotBlank(message = "Product name is required")
    @Size(min = 1, max = 100, message = "Product name must be between 1 and 100 characters")
    private String name;
    
    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description;
    
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal price;
    
    private boolean available;
    
    @Min(value = 0, message = "Category ID must be positive")
    private long categoryId;
    
    @Min(value = 0, message = "Stock quantity cannot be negative")
    private int stockQuantity;
}

