package in.scalive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=NoSuchEmpExistsException.class)
    
    public ResponseEntity<ErrorResponse> handleNoSuchEmpExistsException(NoSuchEmpExistsException ex) {
    	ErrorResponse error=new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
    	return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value=EmpAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleEmpAlreadyExistsException(EmpAlreadyExistsException ex) {
    	ErrorResponse error=new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
    	return error;
    }
  
}

