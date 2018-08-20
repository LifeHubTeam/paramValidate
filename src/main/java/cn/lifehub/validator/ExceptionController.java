package cn.lifehub.validator;


import cn.lifehub.validator.comp.ParameterException;
import cn.lifehub.validator.resp.BaseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ParameterException.class)
    @ResponseBody
    public ResponseEntity<Object> parameterException(HttpServletRequest request, ParameterException pe) {

        return new ResponseEntity<Object>(BaseResult.parameterError(pe.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<Object> notReadable(HttpServletRequest request, HttpMessageNotReadableException re) {
        return new ResponseEntity<Object>(BaseResult.parameterError(re.getMessage()), HttpStatus.OK);
    }


}
