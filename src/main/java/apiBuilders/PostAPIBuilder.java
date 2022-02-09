package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {
	
	
	public Map<String, String> postRequestBody(String Wsr_token){
		
		Map<String, String> body = new HashMap<String, String>();
		body.put("id", Wsr_token);		
		
		return body;
		
	}
	
}
