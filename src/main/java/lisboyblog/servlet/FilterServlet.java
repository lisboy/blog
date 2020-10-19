package lisboyblog.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FAN BOY
 * @version 1.0
 * @date 2020/9/29 20:02
 */
@WebFilter(urlPatterns = "/addcomment")
public class FilterServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //将ServletRequest和ServletResponse强转成http协议的请求和响应对象
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        response.setContentType("text/html;charset=utf-8");
        //获取请求中的参数
        request.setCharacterEncoding("utf-8");
        if (httpServletRequest.getParameter("name").equals("傻逼")){
            httpServletResponse.encodeRedirectURL("/toreadblog?mess='请文明评论'");
        }
        chain.doFilter(new MyRequest(httpServletRequest), response);
    }
 static class MyRequest extends HttpServletRequestWrapper{
        List<String>list=null;
     public MyRequest(HttpServletRequest request) {
         super(request);
         String []strings={"傻逼","垃圾","SB","草尼玛","日你妈比","渣男","渣女","恶心","操B","操你妹","操你妹"};
         List<String> collect = Arrays.stream(strings).distinct().collect(Collectors.toList());
         list=new ArrayList<>(collect);
     }

     @Override
     public String getParameter(String name) {
         String parameter = super.getParameter(name);
         for (String str:list){
                 parameter=parameter.replace(str,"***");
         }
         return parameter;
     }
 }

    @Override
    public void destroy() {

    }
}
