package kh.test.jdbckh.board.model.dto;

public class BoardDto {

//	이름          널?       유형             
//			----------- -------- -------------- 
//			BNO         NOT NULL NUMBER         
//			BTITLE      NOT NULL VARCHAR2(300)  
//			BCONTENT             VARCHAR2(4000) 
//			BWRITE_DATE NOT NULL TIMESTAMP(6)   
//			MID         NOT NULL VARCHAR2(20)   
//			BREF        NOT NULL NUMBER         
//			BRE_LEVEL   NOT NULL NUMBER         
//			BRE_STEP    NOT NULL NUMBER   

	private int bno;
	private String bTitle;
	private String bContent;
	private String bWriteDate;
	private String mId;
	private int bref;
	private int breLevel;
	private int breStep;
	
	//public BoardDto() {} 기본생성자를 없애기도 함.
	
	//selectOne 일때 사용 dao-> controller -> view
	public BoardDto(int bno, String bTitle, String bContent, String bWriteDate, String mId, int bref, int breLevel,
			int breStep) {
		this.bno = bno;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bWriteDate = bWriteDate;
		this.mId = mId;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}	
	
	//selectList 상황으로 content없어도 됌. dao->controller->view
	public BoardDto(int bno, String bTitle, String bWriteDate, String mId, int bref, int breLevel, int breStep) {
		this.bno = bno;
		this.bTitle = bTitle;
		//content없음
		this.bWriteDate = bWriteDate;
		this.mId = mId;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}

	//원본글 등록 view -> controller -->dao
	public BoardDto(String bTitle, String bContent, String mId) {
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.mId = mId;
	}

	// 답글 등록 view -> controller -->dao
	public BoardDto(int bno, String bTitle, String bContent, String mId) {
		this.bno = bno;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.mId = mId;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bWriteDate=" + bWriteDate
				+ ", mId=" + mId + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep + "]";
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriteDate() {
		return bWriteDate;
	}
	public void setbWriteDate(String bWriteDate) {
		this.bWriteDate = bWriteDate;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getBref() {
		return bref;
	}
	public void setBref(int bref) {
		this.bref = bref;
	}
	public int getBreLevel() {
		return breLevel;
	}
	public void setBreLevel(int breLevel) {
		this.breLevel = breLevel;
	}
	public int getBreStep() {
		return breStep;
	}
	public void setBreStep(int breStep) {
		this.breStep = breStep;
	}

}
