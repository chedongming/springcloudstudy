package cn.springcloud.controller;

import cn.springcloud.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cityre
 * @date 2018/1/3
 */
@RestController
public class SayHiController {
    private final HiService hiService;

    @Autowired
    public SayHiController(HiService hiService) {
        this.hiService = hiService;
    }

    @RequestMapping(value = "/sayHi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return hiService.sayHi(name);
    }

}
