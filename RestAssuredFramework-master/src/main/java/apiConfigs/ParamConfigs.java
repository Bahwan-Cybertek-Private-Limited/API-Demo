package apiConfigs;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

public class ParamConfigs 
{
	
	public ParamConfigs() {
			
		}
		
	
		public Map<String, String> params(){
			Map<String, String> defalutparams = new HashMap<String, String>();
			defalutparams.put("grant_type", "password");
			defalutparams.put("username", "admin");
			defalutparams.put("password", "admin");
			
			
			return defalutparams;
			
		}
		
		public JsonObject param()
		{
			 JsonObject requestParams = new JsonObject();
		     requestParams.addProperty("grant_type","password");
		     requestParams.addProperty("username", "admin");
		     requestParams.addProperty("password", "admin");
		     
		
		     return requestParams;
		}

}
