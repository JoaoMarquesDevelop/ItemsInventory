package joao.academy.inventory.service.contracts;

import java.util.List;
import joao.academy.inventory.domain.DTO.ProductDTO;
import joao.academy.inventory.domain.DTO.ProductRequestDTO;
import joao.academy.inventory.exception.BadRequestException;
import joao.academy.inventory.exception.NotFoundException;
import org.springframework.stereotype.Service;

public interface ProductService {
    
    /**
     * Get all products with their category paths
     */
    List<ProductDTO> getAllProducts();
    
    /**
     * Get a product by its id
     */
    ProductDTO getProductById(String productId) throws NotFoundException, BadRequestException;
    
    /**
     * Edit an existing product
     */
    void updateProduct(String productId, ProductRequestDTO productDTO) throws NotFoundException, BadRequestException;
    
    /**
     * Add a new product
     */
    void addProduct(ProductRequestDTO productDTO) throws NotFoundException;
    
    /**
     * Delete a product
     */
    void deleteProduct(String productId) throws NotFoundException, BadRequestException;
}
