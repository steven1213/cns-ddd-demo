package com.steven.cns.ddd.application.dto.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class UserAddDTO implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Length(max = 30, message = "用户名最多为30个字符")
    private String username;

    @Length(max = 256, message = "头像最多为256个字符")
    private String avatar;
}
