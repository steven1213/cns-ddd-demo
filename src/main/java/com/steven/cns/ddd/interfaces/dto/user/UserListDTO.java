package com.steven.cns.ddd.interfaces.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dr.panda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserListDTO implements Serializable {
    private String username;
}
