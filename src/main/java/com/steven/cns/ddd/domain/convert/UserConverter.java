package com.steven.cns.ddd.domain.convert;

import com.steven.cns.ddd.domain.entity.User;
import com.steven.cns.ddd.domain.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author: steven
 * @date: 2023/2/28 22:46
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mappings({@Mapping(source = "id", target = "id"), @Mapping(source = "username", target = "username"), @Mapping(source = "avatar", target = "avatar"), @Mapping(source = "crtTime", target = "crtTime")})
    UserVO user2UserVO(User user);

}
