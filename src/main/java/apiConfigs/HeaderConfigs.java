package apiConfigs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
	
	public HeaderConfigs() {
		
	}
	
	public Map<String, String> defaultHeaders(){
		Map<String, String> defalutHeaders = new HashMap<String, String>();
		defalutHeaders.put("Content-Type", "application/json");
		
		
		return defalutHeaders;
		
	}
	
	
	public Map<String, String> headersWithToken(){
		Map<String, String> defalutHeaders = new HashMap<String, String>();
		defalutHeaders.put("Content-Type", "application/json");
		defalutHeaders.put("Acess_Token", "sdjhvbshjdvbjhsdvbhjsdvbljhdsbv");
		defalutHeaders.put("jwt_token", "sdjhvbshjdvbjhsdvbhjsdvbljhdsbv");
		defalutHeaders.put("Tenet_user", "test");
		
		return defalutHeaders;
		
	}
	
	public Map<String, String> wsr_headers(){
		Map<String, String> defalutHeaders = new HashMap<String, String>();
		//defalutHeaders.put("Content-Length", "0");
		defalutHeaders.put("Accept", "application/json");
		//defalutHeaders.put("Accept", "*/*");
		defalutHeaders.put("Accept-Encoding", "gzip, deflate, br");
		defalutHeaders.put("Accept-Language", "en-US,en;q=0.9");
		defalutHeaders.put("Connection", "keep-alive");
		//defalutHeaders.put("Authorization", "Basic czVPYXkzUXNJbWdMSE5scGxhenl6Q2hTRWVzYTpxVWY1U3JPYXdpV1VKV1VycExJa0RreTFQck1h");
		defalutHeaders.put("Authorization", "Basic czVPYXkzUXNJbWdMSE5scGxhenl6Q2hTRWVzYTpxVWY1U3JPYXdpV1VKV1VycExJa0RreTFQck1h");
		defalutHeaders.put("Content-Type", "application/x-www-form-urlencoded");
		defalutHeaders.put("Host", "192.168.1.77:8280");
		defalutHeaders.put("Content-Length", "49");
		defalutHeaders.put("Origin", "http://192.168.1.76:7001");
		
		return defalutHeaders;
		
	}
	
	
	public Map<String, String> getAlertDetails_headers(){
		Map<String, String> defalutHeaders = new HashMap<String, String>();
		//defalutHeaders.put("Content-Length", "0");
		defalutHeaders.put("Accept", "*/*");
		defalutHeaders.put("Accept-Encoding", "gzip, deflate, br");
		defalutHeaders.put("Connection", "keep-alive");
		defalutHeaders.put("Authorization", "Bearer eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF1dCI6IkFQUExJQ0FUSU9OX1VTRVIiLCJhdWQiOiJzNU9heTNRc0ltZ0xITmxwbGF6eXpDaFNFZXNhIiwibmJmIjoxNjQ0MzgwNzEyLCJhenAiOiJzNU9heTNRc0ltZ0xITmxwbGF6eXpDaFNFZXNhIiwic2NvcGUiOiJkZWZhdWx0IiwiaXNzIjoiaHR0cHM6XC9cL2xvY2FsaG9zdDo5NDQzXC9vYXV0aDJcL3Rva2VuIiwiZXhwIjoxNjQ0Mzg0MzEyLCJpYXQiOjE2NDQzODA3MTIsImp0aSI6IjJhNjU0OGQyLTVjYTEtNDhmYi1iOTcyLTY3ZDJjY2I3NjY2NSJ9.DXtBMbHtAjtCE0aHp5e1H0Y4Pt--k-JjQapCKCLKlMDsb6R8gq4outPqGs8ByPbA1XLvGfoprHE2jxgCrIisbCtIK2Mgsh5BBQEW84kuocg8FL7Vf834cYdmYMk_cbQNRCvcPONt_hvVqnU1fm-ysQv5ZvCalhYh4lBSbNiSaT-JTJJdFEERU7dYislv9XSL6et3rK3VJjVx3qmgWY9Rx_iYJGUamC8-Kd9V7WI6MDh2ILNQPiMGzg51TwpuBnQ4ySPe5vuZYOoHylnszSr6H9U4dwNGXGPtLqrTLefdQTpCJL1DholJ4QYOTmOBhl9rMaw-E24Cr4g7FSFG4JR1Ww");
		defalutHeaders.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJsYXN0TG9naW4iOjE2NDQzMTI3MDQwMDAsInVzZXJfbmFtZSI6Im1zZDIwIiwiaXNBbHJlYWR5TG9nSW4iOmZhbHNlLCJtYW5hZ2VySWQiOiJXRlUyMjIyMiIsImRlcGFydG1lbnRUeXBlIjpudWxsLCJob21lUGFnZSI6Ikdyb3VwIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9OT1RJRklDQVRJT05fV1JJVEUiLCJST0xFX0FETUlOX1JFQUQiLCJST0xFX0dBUERBVEFfV1JJVEUiLCJST0xFX0NIQVJUX0NVU1RfUklTS19DTEFTU0ZJQ19SRUFEIiwiUk9MRV9SRVBFWFREQVRBX1dSSVRFIiwiUk9MRV9DSEFSVF9aT05FX1dJU0VfQUxFUlRfUkVBRCIsIlJPTEVfQ0hBUlRfTU9TVF9HRU5fQUxFUlRfUkVBRCIsIlJPTEVfV09SS0ZMT1dfV1JJVEUiLCJST0xFX0dBUERBVEFfUkVBRCIsIlJPTEVfR1JPVVBfV1JJVEUiLCJST0xFX1JFUEFMRVJUU1RBVFNfUkVBRCIsIlJPTEVfUkVQU01BX1dSSVRFIiwiUk9MRV9EQVNIQk9BUkRfUkVBRCIsIlJPTEVfUkVQSU5UREFUQV9SRUFEIiwiUk9MRV9BTEVSVENPTkZJR19SRUFEIiwiUk9MRV9BTEVSVExJQlJBUllfUkVBRCIsIlJPTEVfUkVQQUxFUlRTVEFUU19XUklURSIsIlJPTEVfUkVQRE9DQkFTRURfV1JJVEUiLCJST0xFX0NIQVJUX0FMRVJUX0NSSVRJQ0FMSVRZX1dSSVRFIiwiUk9MRV9VU0VSX1dSSVRFIiwiUk9MRV9SRVBIT19XUklURSIsIlJPTEVfQ05GR19SRUFEIiwiUk9MRV9SRVBJTlREQVRBX1dSSVRFIiwiUk9MRV9DSEFSVF9BTEVSVF9TVEFUVVNfU1RBVElTVElDU19XUklURSIsIlJPTEVfT1BFUkFUSU9OU19XUklURSIsIlJPTEVfUkVQU01BX1JFQUQiLCJST0xFX0dST1VQX1JFQUQiLCJST0xFX0RBU0hCT0FSRF9XUklURSIsIlJPTEVfUkVQRE9DQkFTRURfUkVBRCIsIlJPTEVfQUxFUlRMSUJSQVJZX1dSSVRFIiwiUk9MRV9DSEFSVF9NT1NUX0dFTl9BTEVSVF9XUklURSIsIlJPTEVfQ0hBUlRfQ1VTVF9SSVNLX0NMQVNTRklDX1dSSVRFIiwiUk9MRV9BTEVSVENPTkZJR19XUklURSIsIlJPTEVfUkVQRVhUREFUQV9SRUFEIiwiUk9MRV9BRE1JTl9XUklURSIsIlJPTEVfQ0hBUlRfQUxFUlRfQ1JJVElDQUxJVFlfUkVBRCIsIlJPTEVfVVNFUl9SRUFEIiwiUk9MRV9PUEVSQVRJT05TX1JFQUQiLCJST0xFX0NVU1QzNjBfV1JJVEUiLCJST0xFX05PVElGSUNBVElPTl9SRUFEIiwiUk9MRV9DSEFSVF9CUkFOQ0hfV0lTRV9BTEVSVF9SRUFEIiwiUk9MRV9DVVNUMzYwX1JFQUQiLCJST0xFX1dPUktGTE9XX1JFQUQiLCJST0xFX0NIQVJUX0FMRVJUX1NUQVRVU19TVEFUSVNUSUNTX1JFQUQiLCJST0xFX0NORkdfV1JJVEUiLCJST0xFX1JFUEhPX1JFQUQiXSwiY2xpZW50X2lkIjoiYmN0YmZzaSIsImlzTm9uU3BlY2lhbGlzZWQiOmZhbHNlLCJicmFuY2hDb2RlIjoiNDk1ODAiLCJsb2dpblVzZXJOYW1lIjoic2VzaGFkcmkiLCJ1c2VyTGV2ZWwiOiJMMSIsInBob25lIjoiOTY3NjMzMTMzMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJmb3JjZUNoYW5nZVBhc3N3b3JkIjpmYWxzZSwic2Vzc2lvblRpbWVPdXQiOjEwMCwiZXhwIjoxNjQ0Mzg5OTIwLCJkZXBhcnRtZW50IjpudWxsLCJzdWJvcmRpbmF0ZXMiOm51bGwsImp0aSI6ImE4OWVmNWMyLTI0Y2UtNDc5MS05Y2U0LWRkYjQxYWZhMjVhNSIsImVtYWlsIjoicmFtZXNoLnJAYmFod2FuY3liZXJ0ZWsuY29tIiwidXNlcm5hbWUiOiJtc2QyMCJ9.e0-usdbkfj-rnic0vAQsp5490QRryhLhF6is_qdT0-dWiN6GIrdh0FH6rTt0U2U9CwaqSCT7WqZiJNRjwNYfYBiEr_K45Zjfen1wlR61mWMCWdTQlIBz2PTMZWfed35qN3FMgk3jga9e6JGe_QgHVbfgKbuQY_Cln0crmAe1JdyonNxrHx2P-eFwCh07uEmU8UR3n78fWdy6JAx5WiTZatZ5SAPNcOb-nwBILy8rMBzHYyeLeCOtJyldznEwYkR3JiQnVcWoDcWIRTF0N-c1EaH9DwzvoYmduqyqMQ7bAkBS7Cs0oljrqs41ikQDZeOKgudJbbLCi5_KToKL5NK3eA");
		return defalutHeaders;
		
	}
	
	

}
