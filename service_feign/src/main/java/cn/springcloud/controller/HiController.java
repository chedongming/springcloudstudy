package cn.springcloud.controller;

import cn.springcloud.service.SayHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cityre
 * @date 2018/1/4
 */
@RestController
public class HiController {

    private final SayHiService sayHiService;

    @Autowired
    public HiController(SayHiService sayHiService) {
        this.sayHiService = sayHiService;
    }

    @RequestMapping(value = "/sayHi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return sayHiService.sayHi(name);
    }
}
