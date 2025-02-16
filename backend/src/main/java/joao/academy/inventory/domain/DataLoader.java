package joao.academy.inventory.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import joao.academy.inventory.domain.entity.CategoryEntity;
import joao.academy.inventory.domain.entity.ProductEntity;
import joao.academy.inventory.repository.CategoryRepository;
import joao.academy.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
    @Value("${spring.profiles.active:default}")
    private String activeProfile;
    
    @Autowired
    public DataLoader(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public void run(ApplicationArguments args) {
        if (Objects.equals(activeProfile, "dev")){
            loadCategoriesAndProducts();
        }
    }
    
    private void loadCategoriesAndProducts() {
        // Create Categories
        CategoryEntity electronics = createCategory("Electronics", "All things electronics", null);
        CategoryEntity mobiles = createCategory("Mobile Phones", "Smartphones and mobile devices", electronics);
        CategoryEntity computers = createCategory("Computers", "Laptops, desktops, and accessories", electronics);
        CategoryEntity accessories = createCategory("Accessories", "Accessories for electronics", null);
        CategoryEntity wearables = createCategory("Wearables", "Smartwatches, fitness trackers, and wearables", accessories);
        
        // Save categories first
        categoryRepository.saveAll(List.of(electronics, mobiles, computers, accessories, wearables));
        
        // Create Products
        List<ProductEntity> products = List.of(
                createProduct("Laptop", "High-performance laptop for work and gaming.", BigDecimal.valueOf(1200.00), 50, computers),
                createProduct("Smartphone", "Latest model with high-end features.", BigDecimal.valueOf(800.00), 100, mobiles),
                createProduct("Wireless Mouse", "Ergonomic design with long battery life.", BigDecimal.valueOf(25.00), 200, accessories),
                createProduct("Bluetooth Headphones", "Noise-canceling headphones with deep bass.", BigDecimal.valueOf(60.00), 150, accessories),
                createProduct("Power Bank 10000mAh", "Fast-charging power bank with dual USB output.", BigDecimal.valueOf(40.00), 120, accessories),
                createProduct("Tablet", "Portable tablet with high-resolution display.", BigDecimal.valueOf(600.00), 80, mobiles),
                createProduct("Gaming Monitor", "4K UHD monitor with 144Hz refresh rate.", BigDecimal.valueOf(350.00), 60, computers),
                createProduct("Mechanical Keyboard", "RGB backlit keyboard with tactile switches.", BigDecimal.valueOf(100.00), 90, accessories),
                createProduct("Smartwatch", "Fitness tracker with heart rate monitor.", BigDecimal.valueOf(150.00), 75, wearables),
                createProduct("External Hard Drive", "2TB USB 3.0 external storage.", BigDecimal.valueOf(90.00), 110, computers)
        );
        
        // Save products
        productRepository.saveAll(products);
    }
    
    private CategoryEntity createCategory(String name, String description, CategoryEntity parent) {
        return CategoryEntity.builder()
                .name(name)
                .description(description)
                .parentCategory(parent)
                .build();
    }
    
    private ProductEntity createProduct(String name, String description, BigDecimal price, int stock, CategoryEntity category) {
        return ProductEntity.builder()
                .name(name)
                .description(description)
                .price(price)
                .available(true)
                .stockQuantity(stock)
                .category(category)
                .build();
    }
}