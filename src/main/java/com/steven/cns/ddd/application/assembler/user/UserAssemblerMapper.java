package com.steven.cns.ddd.application.assembler.user;


import com.steven.cns.ddd.domain.entity.User;
import com.steven.cns.ddd.application.dto.user.UserAddDTO;
import com.steven.cns.ddd.application.dto.user.UserEditDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author steven.cao
 */
@Mapper
public interface UserAssemblerMapper {

    UserAssemblerMapper INSTANCE = Mappers.getMapper(UserAssemblerMapper.class);

    @Mappings({@Mapping(source = "username", target = "username"), @Mapping(source = "avatar", target = "avatar")})
    User userAddDTO2User(UserAddDTO userAddDTO);

    @Mappings({@Mapping(source = "id", target = "id"), @Mapping(source = "username", target = "username"), @Mapping(source = "avatar", target = "avatar")})
    User userEditDTO2User(UserEditDTO userEditDTO);
}
