package com.sample;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sooyoung on 2016-07-29.
 */
@Controller
public class TestController {
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String home(Model model
            , Locale locale
            , HttpServletRequest request
            , HttpServletResponse response
    ) {
        System.out.println("client locale is "+locale);
        model.addAttribute("hello", "Hello World");
    
        if (request.getParameter("lang") == null || "".equals(request.getParameter("lang"))) {
            setLocaleInfo(request.getLocale(), request, response);
        } else {
            setLocaleInfo(locale, request, response);
        }
    
    
        /**
         *  프론트엔드에서 사용할수 있도록 locale 값이 바뀔때마다 사용함.
         */
        
        HttpSession session = request.getSession(false);
        session.setAttribute("locale", locale);
        return "test";
    }
    
    /**
     * locale 값을 변경
     * @param locale
     * @param request
     * @param response
     */
    private void setLocaleInfo(final Locale locale, HttpServletRequest request, HttpServletResponse response) {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        LocaleContext localeContext = new LocaleContext() {
            @Override
            public Locale getLocale() {
                return locale;
            }
        };
        sessionLocaleResolver.setLocaleContext(request, response, localeContext);
    }
    
    /**
     *
     * jquery.i18n.properties 라이브러리 사용시 path 로 설정된 url.
     * Ajax로 호출되고, messages.properties를 읽어 key를 찾아 값을 리턴한다.
     *
     * @param propertiesName
     * @param response
     * @throws IOException
     */
    @RequestMapping("/locale/{propertiesName}")
    public void getProperties(@PathVariable String propertiesName, HttpServletResponse response) throws IOException {
        OutputStream outputStream = response.getOutputStream();
        Resource resource = new ClassPathResource("/locale/" + propertiesName + ".properties");
        InputStream inputStream = resource.getInputStream();
        
        List<String> readLines = IOUtils.readLines(inputStream, "UTF-8" );
        IOUtils.writeLines(readLines, null, outputStream, Charsets.toCharset("UTF-8"));
        
        IOUtils.closeQuietly(inputStream);        IOUtils.closeQuietly(outputStream);
    
    }
    
}
