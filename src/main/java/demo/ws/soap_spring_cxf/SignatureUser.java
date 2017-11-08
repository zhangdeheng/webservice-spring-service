package demo.ws.soap_spring_cxf;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignatureUser {

    private Map<String, String> userMap;

    public Map<String, String> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, String> userMap) {
        this.userMap = userMap;
    }
}