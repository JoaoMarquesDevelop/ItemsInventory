package joao.academy.inventory.exception;

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String message;
    
    
    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }
    
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);  // Call to the parent RuntimeException constructor with cause
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
