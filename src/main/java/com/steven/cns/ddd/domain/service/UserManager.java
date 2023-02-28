package com.steven.cns.ddd.domain.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.steven.cns.ddd.domain.convert.UserConverter;
import com.steven.cns.ddd.domain.entity.User;
import com.steven.cns.ddd.domain.repository.UserRepository;
import com.steven.cns.ddd.domain.vo.UserVO;
import com.steven.cns.ddd.infrastructure.base.exception.BizException;
import com.steven.cns.infra.common.type.RespResult;
import com.steven.cns.infra.common.type.YesNoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @author: steven.cao
 * @date: 2023/2/28 22:41
 */
@Component
@RequiredArgsConstructor
public class UserManager extends ServiceImpl<UserRepository, User> {

    public UserVO findUserById(Long id) {
        User user = this.getById(id);
        if (Objects.isNull(user)) {
            return null;
        }
        return UserConverter.INSTANCE.user2UserVO(user);
    }

    public void userAdd(User user) {
        User record = this.lambdaQuery().eq(User::getUsername, user.getUsername()).one();
        if (Objects.nonNull(record)) {
            throw new BizException(RespResult.FAILURE.getCode(), "用户名重复");
        }
        record = new User();
        record.setUsername(user.getUsername());
        record.setAvatar(user.getAvatar());
        record.setCrtTime(new Date());
        record.setUptTime(new Date());
        record.setAccountStatus(0);
        record.setDel(YesNoEnum.NO.getCode().shortValue());
        this.save(record);
    }

    public void userEdit(User user) {
        User record = this.lambdaQuery().eq(User::getUsername, user.getUsername()).one();
        if (Objects.isNull(record)) {
            throw new BizException(RespResult.FAILURE.getCode(), "未找到用户");
        }
        record.setUsername(user.getUsername());
        record.setAvatar(user.getAvatar());
        this.updateById(record);
    }
}
