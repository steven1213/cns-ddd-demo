package com.steven.cns.ddd.application.service;


import com.steven.cns.ddd.domain.vo.UserVO;
import com.steven.cns.ddd.application.dto.user.UserAddDTO;
import com.steven.cns.ddd.application.dto.user.UserEditDTO;

/**
 * @author steven.cao
 */
public interface IUserService {

    UserVO getUserById(Long id);

    void userAdd(UserAddDTO userAddDTO);

    void userEdit(UserEditDTO userEditDTO);
}
