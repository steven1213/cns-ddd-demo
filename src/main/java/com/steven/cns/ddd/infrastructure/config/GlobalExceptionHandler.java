package com.steven.cns.ddd.infrastructure.config;

import com.google.common.base.Joiner;
import com.steven.cns.ddd.infrastructure.base.exception.BizException;
import com.steven.cns.infra.common.resp.Resp;
import com.steven.cns.infra.common.type.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author steven.cao
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 空指针异常异常
     *
     * @param ex NullPointerException
     * @return Resp
     */
    @ExceptionHandler(NullPointerException.class)
    public Resp<Void> handleNullPointerException(NullPointerException ex) {
        log.error(ex.getMessage(), ex);
        return Resp.failure(RespResult.FAILURE.getCode(), ex.getMessage());
    }

    /**
     * 处理 参数未通过验证异常
     *
     * @param ex MethodArgumentNotValidException
     * @return Resp
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Resp<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMsg = bindingResult.getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        String resultErrorMsg = Joiner.on(";").join(errorMsg);
        return Resp.failure(RespResult.FAILURE.getCode(), resultErrorMsg);
    }

    /**
     * 处理 参数绑定异常
     *
     * @param ex BindException
     * @return Resp
     */
    @ExceptionHandler(BindException.class)
    public Resp<Void> handleMethodArgumentNotValidException(BindException ex) {
        log.error(ex.getMessage(), ex);
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMsg = bindingResult.getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        String resultErrorMsg = Joiner.on(";").join(errorMsg);
        return Resp.failure(RespResult.FAILURE.getCode(), resultErrorMsg);
    }

    /**
     * 自定义异常处理
     *
     * @param ex 异常
     * @return Resp<String>
     */
    @ExceptionHandler(BizException.class)
    public Resp<Void> handleBizException(BizException ex) {
        log.error(ex.getMsg(), ex);
        return Resp.failure(ex.getCode(), ex.getMsg());
    }

    /**
     * 无效请求头异常
     */
    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public Resp<Void> handleMissingRequestHeaderException(MissingRequestHeaderException ex) {
        log.error(ex.getMessage(), ex);
        return Resp.failure(RespResult.FAILURE.getCode(), ex.getHeaderName());
    }

    /**
     * SQL 异常
     */
    @ExceptionHandler(value = SQLException.class)
    public Resp<Void> handleSQLException(SQLException ex) {
        log.error(ex.getMessage(), ex);
        return Resp.failure(RespResult.FAILURE.getCode(), "sql异常");
    }

    /**
     * SQL 异常
     */
    @ExceptionHandler(value = ServletException.class)
    public Resp<Void> handleSQLException(ServletException ex) {
        log.error(ex.getMessage(), ex);
        return Resp.failure(RespResult.FAILURE.getCode(), "服务异常");
    }
}
