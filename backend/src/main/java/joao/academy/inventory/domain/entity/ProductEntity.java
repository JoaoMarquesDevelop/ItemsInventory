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
import java.util.Objects;
import joao.academy.inventory.domain.DTO.ProductRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    
    public void set(ProductRequestDTO productRequestDTO, CategoryEntity categoryEntity) {
        this.name = productRequestDTO.getName();
        this.description = productRequestDTO.getDescription();
        this.price = productRequestDTO.getPrice();
        this.available = productRequestDTO.isAvailable();
        this.stockQuantity = productRequestDTO.getStockQuantity();
        this.category = categoryEntity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
