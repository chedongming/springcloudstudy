package cn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cityre
 * @date 2018/1/3
 */
@RestController
public class HiController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("welcome").append(" ").append(name).append(" port is ").append(port).toString();
    }
}
