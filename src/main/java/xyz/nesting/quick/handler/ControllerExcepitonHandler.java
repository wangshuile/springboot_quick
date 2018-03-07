package xyz.nesting.quick.handler;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.nesting.quick.constant.ErrorCode;
import xyz.nesting.quick.exception.BusinessException;
import xyz.nesting.quick.util.ZcApiResponse;

/**
 * 控制层拦截器，捕捉所有异常
 * 
 */
@ControllerAdvice
public class ControllerExcepitonHandler {

    private static final Logger logger =  LoggerFactory.getLogger(ControllerExcepitonHandler.class);

    /**
     * 系统异常处理
     * @param e
     * @return
     */
    @ExceptionHandler({ Throwable.class })
    public @ResponseBody ZcApiResponse processThrowable(Throwable e) {
    		logger.error("", e);
        return ZcApiResponse.error(ErrorCode.FAILED, "系统错误", e.getMessage());
    }
    
    /**
     * 手动异常处理
     * @param e
     * @return
     */
    @ExceptionHandler({ BusinessException.class })
    public @ResponseBody ZcApiResponse processBusinessException(BusinessException e) {
    		logger.warn("BusinessException: [errorCoe:{},errorMessage:{},stackTrace:{}]", e.getErrorCode(), e.getErrorMessage(), e.getStackTrace()[1]);
        return ZcApiResponse.error(ErrorCode.FAILED, e.getMessage(), null);
    }
    
    /**
	 * 捕获参数验证异常
	 * @param ce
	 * @return
	 */
	@ExceptionHandler({ ConstraintViolationException.class, MethodArgumentNotValidException.class, BindException.class })
	public @ResponseBody ZcApiResponse apiParamExceptionHandler(Exception ce) {
		String message = "";
		try {
			if (ce instanceof MethodArgumentNotValidException) {
				message = ((MethodArgumentNotValidException)ce).getBindingResult().getAllErrors().get(0).getDefaultMessage();
				
			} else if (ce instanceof BindException) {
				message = ((BindException)ce).getAllErrors().get(0).getDefaultMessage();
				
			} else if (ce instanceof ConstraintViolationException) {
				ConstraintViolationException cve = (ConstraintViolationException)ce;
				Set<ConstraintViolation<?>> cs = cve.getConstraintViolations();
				if (cs.iterator().hasNext()) {
					message = cs.iterator().next().getMessage();
				}
			}
		}catch (Exception e) {
			message = "apiParamExceptionHandler error";
		}
		logger.warn("API请求参数错误:[{}]", message);
		return ZcApiResponse.error(ErrorCode.FAILED, message, "");
	}

}
