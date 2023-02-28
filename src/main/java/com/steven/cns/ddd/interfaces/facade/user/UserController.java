package com.steven.cns.ddd.interfaces.facade.user;

import com.steven.cns.infra.common.resp.Resp;
import com.steven.cns.log.annotation.ReqLog;
import com.steven.cns.ddd.interfaces.api.BaseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dr.panda
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseApi {

    @GetMapping("/{id}")
    @ReqLog
    public Resp<Void> get(@PathVariable("id") Long id) {
        return Resp.success();
    }

}
