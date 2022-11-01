package kr.or.ddit.vo;

public class CustomerVO {

	private String cumId; // 고객아이디
	private String cumName; // 고객이름
	private String cumJob; // 고객 직업
	private String cumLike; // 고객 취미
	private String cumSkil; // 고객 특기
	
	// 기본생성자
	public CustomerVO() {}

	//getter/setter
	public String getCumId() {
		return cumId;
	}

	public void setCumId(String cumId) {
		this.cumId = cumId;
	}

	public String getCumName() {
		return cumName;
	}

	public void setCumName(String cumName) {
		this.cumName = cumName;
	}

	public String getCumJob() {
		return cumJob;
	}

	public void setCumJob(String cumJob) {
		this.cumJob = cumJob;
	}

	public String getCumLike() {
		return cumLike;
	}

	public void setCumLike(String cumLike) {
		this.cumLike = cumLike;
	}

	public String getCumSkil() {
		return cumSkil;
	}

	public void setCumSkil(String cumSkil) {
		this.cumSkil = cumSkil;
	}

	@Override
	public String toString() {
		return "CustomerVO [cumId=" + cumId + ", cumName=" + cumName + ", cumJob=" + cumJob + ", cumLike=" + cumLike
				+ ", cumSkil=" + cumSkil + "]";
	}

}
