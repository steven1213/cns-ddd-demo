package com.steven.cns.ddd.application.dto.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
public class UserEditDTO extends UserAddDTO implements Serializable {

    @NotNull(message = "用户ID不能为空")
    private Long id;
}
