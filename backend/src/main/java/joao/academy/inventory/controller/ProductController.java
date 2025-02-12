package joao.academy.inventory.controller;

import java.util.List;
import joao.academy.inventory.domain.DTO.ProductDTO;
import joao.academy.inventory.domain.DTO.ProductRequestDTO;
import joao.academy.inventory.service.contracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private final ProductService productService;
    
    // TODO add caching mechanism
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> listProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }
    
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @PutMapping("/{productId}")
    public ResponseEntity<Void> editProduct(@PathVariable String productId,
                                            @RequestBody ProductRequestDTO product) {
        productService.updateProduct(productId, product);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<Void> addProduct(@RequestBody ProductRequestDTO product) {
        productService.addProduct(product);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
