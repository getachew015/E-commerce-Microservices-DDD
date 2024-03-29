package meru.com.apigateway;


import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class APIGatewayFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(APIGatewayFilter.class);
	
	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = 
							RequestContext.getCurrentContext().getRequest();
		logger.info("request URI -> {} requesting server Port -> {}"
								,request.getRequestURI(), request.getRemotePort());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {

		return "pre";
	}

	
	
}
