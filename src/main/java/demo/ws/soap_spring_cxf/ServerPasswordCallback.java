package demo.ws.soap_spring_cxf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 提供了两个用户：server和client，用户名和密码都放在userMap中，这里需要将JDK提供的javax.security.auth.
 * callback.Callback转型为WSS4J提供的org.apache.wss4j.common.ext.WSPasswordCallback，
 * 在handle方法中实现对客户端密码的验证，最终需要将密码放入到callback对象中
 * 
 * @author zdh
 *
 */
@Component
public class ServerPasswordCallback implements CallbackHandler {
//	@Autowired
//	private SignatureUser user;
	private static final Map<String, String> userMap = new HashMap<String, String>();

	static {
		userMap.put("ciecc", "cieccPassword");
	}
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];

		String clientUsername = callback.getIdentifier();
		String serverPassword = userMap.get(clientUsername);
		if (serverPassword != null) {
			callback.setPassword(serverPassword);
		}

	}

}
