package kh.test.jdbckh.member.model.dto;

public class Member {

//	MID    NOT NULL VARCHAR2(20)  
//	MPWD   NOT NULL VARCHAR2(20)  
//	MNAME  NOT NULL VARCHAR2(50)  
//	MEMAIL NOT NULL VARCHAR2(150) 

	private String mid;
	private String mpwd;
	private String mname;
	private String memail;
	
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mpwd=" + mpwd + ", mname=" + mname + ", memail=" + memail + "]";
	}

}
