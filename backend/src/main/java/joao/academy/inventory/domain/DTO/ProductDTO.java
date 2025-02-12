package joao.academy.inventory.domain.DTO;

import java.math.BigDecimal;
import joao.academy.inventory.domain.entity.ProductEntity;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean available;
    private String categoryPath;
    private int stockQuantity;
    
    public ProductDTO(ProductEntity productEntity) {
        if (productEntity == null) {
            return;
        }
        this.id = productEntity.getId();
        this.name = productEntity.getName();
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        this.available = productEntity.getAvailable();
        if (productEntity.getCategory() != null) {
            this.categoryPath = productEntity.getCategory().getCategoryPath();
        }
        this.stockQuantity = productEntity.getStockQuantity();
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public String getCategoryPath() {
        return categoryPath;
    }
    
    public int getStockQuantity() {
        return stockQuantity;
    }
}