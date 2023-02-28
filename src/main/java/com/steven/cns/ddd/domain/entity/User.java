package com.steven.cns.ddd.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.steven.cns.infra.common.po.PO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author steven.cao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@TableName("t_cns_user")
public class User extends PO<User> implements Serializable {

    private String username;

    private String avatar;

    private Integer accountStatus;

}
