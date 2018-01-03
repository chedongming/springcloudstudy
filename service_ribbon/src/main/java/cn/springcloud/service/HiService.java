package cn.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author cityre
 * @date 2018/1/3
 */
@Service
public class HiService {

    private final RestTemplate restTemplate;

    @Autowired
    public HiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sayHi(String name){
        return restTemplate.getForObject("http://EUREKACLIENT/hi?name="+name,String.class);
    }
}
