package kh.test.jdbckh.common.filter.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordWrapper extends HttpServletRequestWrapper {
	
//HttpServletRequestWrapper 클래스는 기본생성자가 없으므로 반드시 매개인자가 있는 생성자가 있어야함.
	public PasswordWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {  
		System.out.println("[냄쿵암호화 !전!] 크키: "+name.length()+", "+ name);
		
		if(name != null && name.equals("pwd")) {   //request.getParameter("pwd")가 호출되면
			name = getSha512(super.getParameter(name)); //88자 String
		}else {    //request.getParameter("pwd"외 다른이름)이 호출되면
			name = super.getParameter(name);
		}
		
		System.out.println("[냄쿵암호화 @후@] 크키: "+name.length()+", "+ name);
		return name;
	}
	
	private String getSha512(String pwd) {
		String result = null;
		//SHA512 암호화
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512"); //SingleTon
			byte[] pwdBytes = pwd.getBytes(Charset.forName("UTF-8")); // UTF-8 모양일테니 그것을 byte배열 형태로 만들어줌.
			md.update(pwdBytes); // 여기서 암호화.
			//암호회된 byte[]를 다시 String 형으로 변환
			result = Base64.getEncoder().encodeToString(pwdBytes);  //88자(String 형태)로 나오니 DB에 pwd는 90~100자로 만들어줌.
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
