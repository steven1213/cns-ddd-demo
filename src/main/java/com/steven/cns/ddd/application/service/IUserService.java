package com.steven.cns.ddd.application.service;


import com.steven.cns.ddd.interfaces.dto.user.UserAddDTO;
import com.steven.cns.ddd.interfaces.dto.user.UserEditDTO;
import com.steven.cns.ddd.domain.vo.UserVO;

/**
 * @author dr.panda
 */
public interface IUserService {

    UserVO getUserById(Long id);

    void userAdd(UserAddDTO user);

    void userEdit(UserEditDTO user);
}
