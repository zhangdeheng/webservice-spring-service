
package demo.ws.soap_spring_cxf;

import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface HelloService {

    String say(@WebParam(name = "name") String name);
}
