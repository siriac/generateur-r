package service;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
@Provider
@PreMatching
public class RESTCorsDemoResponseFilter implements ContainerResponseFilter {
	private final static Logger log = Logger.getLogger( RESTCorsDemoResponseFilter.class.getName() );
	 
    @Override
    public void filter( ContainerRequestContext requestCtx, ContainerResponseContext responseCtx ) throws IOException {
        log.info( "Executing REST response filter" );
 
        responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT,HEAD" );
        responseCtx.getHeaders().add("Access-Control-Allow-Headers"," Content-Type, Accept, Authorization, x-pingother");
        
    }


}
