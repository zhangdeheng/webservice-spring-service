package demo.ws.soap_spring_cxf;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

@Component
@WebService(endpointInterface = "demo.ws.soap_spring_cxf.HelloService",targetNamespace="http://soap_spring_cxf.ws.demo/")
public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}