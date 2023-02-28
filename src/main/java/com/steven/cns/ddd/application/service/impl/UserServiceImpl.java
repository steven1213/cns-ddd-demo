package com.steven.cns.ddd.application.service.impl;

import com.steven.cns.ddd.application.assembler.user.UserAssemblerMapper;
import com.steven.cns.ddd.application.service.IUserService;
import com.steven.cns.ddd.domain.service.UserManager;
import com.steven.cns.ddd.domain.vo.UserVO;
import com.steven.cns.ddd.application.dto.user.UserAddDTO;
import com.steven.cns.ddd.application.dto.user.UserEditDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: steven
 * @date: 2023/2/28 22:42
 */
@Service
public class UserServiceImpl implements IUserService {

    private  UserManager userManager;

    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserVO getUserById(Long id) {
        return userManager.findUserById(id);
    }

    @Override
    public void userAdd(UserAddDTO userAddDTO) {
        userManager.userAdd(UserAssemblerMapper.INSTANCE.userAddDTO2User(userAddDTO));
    }

    @Override
    public void userEdit(UserEditDTO userEditDTO) {
        userManager.userEdit(UserAssemblerMapper.INSTANCE.userEditDTO2User(userEditDTO));
    }
}
