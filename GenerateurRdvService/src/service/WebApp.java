package service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.web.bind.annotation.CrossOrigin;
@ApplicationPath("/")
@CrossOrigin(origins = "*")
public class WebApp extends Application{
	

}
