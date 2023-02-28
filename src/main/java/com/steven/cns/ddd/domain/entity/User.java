package com.steven.cns.ddd.domain.entity;

import com.steven.cns.infra.common.po.PO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author dr.panda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "t_cns_user")
public class User extends PO<User> implements Serializable {

    private String username;

    private String avatar;

    private Integer accountStatus;
}
