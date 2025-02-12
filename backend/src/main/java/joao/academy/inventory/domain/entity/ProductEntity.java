package joao.academy.inventory.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import joao.academy.inventory.domain.DTO.ProductRequestDTO;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean available;
    
    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
    
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
    
    public Boolean getAvailable() {
        return available;
    }
    
    public CategoryEntity getCategory() {
        return category;
    }
    
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    
    public void set(ProductRequestDTO productRequestDTO, CategoryEntity categoryEntity) {
        this.name = productRequestDTO.getName();
        this.description = productRequestDTO.getDescription();
        this.price = productRequestDTO.getPrice();
        this.available = productRequestDTO.isAvailable();
        this.stockQuantity = productRequestDTO.getStockQuantity();
        this.category = categoryEntity;
    }
    
}
