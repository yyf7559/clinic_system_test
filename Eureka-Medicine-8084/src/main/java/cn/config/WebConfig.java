package cn.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String HEADER_NAME = "Authorization";
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                // 判断请求头部中是否包含token信息，如果需要,可以使用公钥验证Jwt
                String header = request.getHeader(HEADER_NAME);
                boolean next = !StringUtils.isEmpty(header);
                if(!next) {
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    Map<String, String> error = new HashMap<>();
                    error.put("code","401");
                    error.put("msg","请先登录再访问");
                    response.getWriter().print(new ObjectMapper().writeValueAsString(error));
                }
                return next;
            }
        }).addPathPatterns("/**");
    }

}
