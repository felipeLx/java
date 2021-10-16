package br.com.scc4.tms.tenancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class TenancyInterceptor extends HandlerInterceptorAdapter {

    private final static String DEFAULT_DATA_SOURCE = "tms_main";
    private static Logger log = LoggerFactory.getLogger(TenancyInterceptor.class);
    private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("Pre handle method = check handling start time");
        long startTime = System.currentTimeMillis();

        request.setAttribute("executionTime", startTime);
        Map<String, Object> pathVars = (Map<String, Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        if (pathVars != null && pathVars.containsKey("tenantid")) {
            request.setAttribute("TENANT_ID", pathVars.get("tenantid"));
        }
        return true;
    }

    public static String getTenantId() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (requestAttributes != null) {
            return (String) requestAttributes.getAttribute("TENANT_ID", RequestAttributes.SCOPE_REQUEST);
        }

        return DEFAULT_DATA_SOURCE;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }

}
