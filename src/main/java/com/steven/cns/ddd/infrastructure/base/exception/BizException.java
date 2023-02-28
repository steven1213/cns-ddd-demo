package com.steven.cns.ddd.infrastructure.base.exception;

import com.steven.cns.infra.common.type.BaseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dr.panda
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {
    private Integer code;
    private String msg;

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BaseEnum errorEnum) {
        super(errorEnum.getValue());
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getValue();
    }
}
