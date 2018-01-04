package cn.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author cityre
 * @date 2018/1/4
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * filterType过滤类型：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * 总共4中方式
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return --int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否开启过滤，再次可以对开启过滤的条件进行管理
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 实际过滤条件
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        Object token = httpServletRequest.getParameter("token");
        if (token==null){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
