package joao.academy.inventory.service.implementation;

import java.util.List;
import joao.academy.inventory.domain.DTO.ProductDTO;
import joao.academy.inventory.domain.DTO.ProductRequestDTO;
import joao.academy.inventory.domain.entity.CategoryEntity;
import joao.academy.inventory.domain.entity.ProductEntity;
import joao.academy.inventory.exception.BadRequestException;
import joao.academy.inventory.exception.NotFoundException;
import joao.academy.inventory.repository.CategoryRepository;
import joao.academy.inventory.repository.ProductRepository;
import joao.academy.inventory.service.contracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).toList();
    }
    
    @Override
    public ProductDTO getProductById(String productId)
            throws NotFoundException, BadRequestException{
        long id = validateProductId(productId);
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
        return new ProductDTO(product);
    }
    
    @Override
    public void updateProduct(String productId, ProductRequestDTO productDTO)
            throws NotFoundException, BadRequestException {
        long id = validateProductId(productId);
        
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
        
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with id " + id));
        
        product.set(productDTO, category);
        productRepository.save(product);
    }
    
    @Override
    public void addProduct(ProductRequestDTO productDTO) throws NotFoundException {
        CategoryEntity category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category not found with id " + productDTO.getCategoryId()));
        
        ProductEntity product = new ProductEntity();
        product.set(productDTO, category);
        productRepository.save(product);
    }
    
    @Override
    public void deleteProduct(String productId) {
        
        long id = validateProductId(productId);
        
        try {
            productRepository.deleteById(id);
        } catch (DataAccessException e) {
            // If there is a database-related issue, handle it appropriately
            // notify developers
            throw new RuntimeException("Database error occurred while trying to delete the product", e);
        }
        productRepository.deleteById(id);
    }
    
    private Long validateProductId(String productId) throws BadRequestException {
        long id;
        try {
            id = Long.parseLong(productId);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid product id: " + productId);
        }
        return id;
    }
}
