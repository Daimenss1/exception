package pro.sky.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNabException extends RuntimeException {
    public InvalidNabException(String message) {
        super(message);
    }
}
