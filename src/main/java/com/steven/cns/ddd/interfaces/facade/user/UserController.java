package com.steven.cns.ddd.interfaces.facade.user;

import com.steven.cns.ddd.application.service.IUserService;
import com.steven.cns.ddd.domain.vo.UserVO;
import com.steven.cns.ddd.infrastructure.base.constant.Constants;
import com.steven.cns.ddd.interfaces.api.BaseApi;
import com.steven.cns.ddd.application.dto.user.UserAddDTO;
import com.steven.cns.ddd.application.dto.user.UserEditDTO;
import com.steven.cns.infra.common.resp.Resp;
import com.steven.cns.log.annotation.ReqLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author steven.cao
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.WEB_URL_PREFIX + "/user")
public class UserController extends BaseApi {

    private final IUserService userService;

    @GetMapping("/{id}")
    @ReqLog
    public Resp<UserVO> findUserById(@PathVariable("id") Long id) {
        return Resp.success(userService.getUserById(id));
    }

    /**
     * <code>@ReqLog</code>
     * printHeader 默认日志不打印请求头信息，若需要请将其设置为true
     *
     * @param userAddDTO 添加用户
     * @return Resp<Void>
     */
    @PostMapping("/add")
    @ReqLog(printHeader = true)
    public Resp<Void> userAdd(@RequestBody @Validated UserAddDTO userAddDTO) {
        userService.userAdd(userAddDTO);
        return Resp.success();
    }

    /**
     * <code>@ReqLog</code>
     * printHeader 默认日志不打印请求头信息，若需要请将其设置为true
     *
     * @param userEditDTO 编辑用户
     * @return Resp<Void>
     */
    @PostMapping("/edit")
    @ReqLog(printHeader = true)
    public Resp<Void> userEdit(@RequestBody @Validated UserEditDTO userEditDTO) {
        userService.userEdit(userEditDTO);
        return Resp.success();
    }

}
