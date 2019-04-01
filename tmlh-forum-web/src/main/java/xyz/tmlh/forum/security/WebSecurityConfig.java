package xyz.tmlh.forum.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import xyz.tmlh.forum.util.GetMapperUtil;
import xyz.tmlh.security.browser.BrowserSecurityConfig;

/**
 * <p>
 *    自定义请求处理
 * </p>
 *
 * @author TianXin
 * @since 2019年4月1日下午6:19:37
 */
@Configuration
public class WebSecurityConfig extends BrowserSecurityConfig {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(getUrls())
            .permitAll()//不拦截请求
        .anyRequest(); 
        
        super.configure(http);
    }
    
    private List<String> getUrlList(){
        List<String> urls = new ArrayList<>();
        urls.add("/asserts/**");
        return urls;
    }
    
    private String[] getUrls() {
        List<String> urls = getUrlList();
        urls.addAll(GetMapperUtil.getGetMapperValue());
        return urls.stream().toArray(String[]::new);
    }
    
}
