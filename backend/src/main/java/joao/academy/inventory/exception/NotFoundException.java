package joao.academy.inventory.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String message;
    
    
    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
