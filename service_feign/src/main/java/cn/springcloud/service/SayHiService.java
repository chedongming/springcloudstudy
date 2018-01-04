package cn.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cityre
 * @date 2018/1/4
 * 通过feign作为消费者，
 * 这种方式主要就是通过注解进行实现
 * feignclient标注要调用的服务名，
 * requestMapping标注要调用服务的接口的请求路径个请求方式，个普通项目中的controller差不多
 */
@FeignClient(value = "EUREKACLIENT")
public interface SayHiService {
    /**
     * 利用Feign作为消费者，实现sayHi接口
     * @param name --需要传递的参数这边是姓名
     * @return --string
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHi(@RequestParam("name") String name);

}
