package tim21.PortalPoverenika.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class ViolationException extends RuntimeException {
    public ViolationException() {
        super();
    }
    public ViolationException(String message, Throwable cause) {
        super(message, cause);
    }
    public ViolationException(String message) {
        super(message);
    }
    public ViolationException(Throwable cause) {
        super(cause);
    }
}