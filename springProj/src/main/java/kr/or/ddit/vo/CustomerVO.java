package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CustomerVO {

	private String cumId; // 고객아이디
	private String cumName; // 고객이름
	private String cumJob; // 고객 직업
	private String cumLike; // 고객 취미
	private String cumSkil; // 고객 특기
	
	
	// 11/03 수업 진행중 추가함 과제랑 관련 x
	private String userId;
	private String password;
	private MultipartFile picture;
	private MultipartFile picture2;
	//.. name="pictureList[0]" 
	private List<MultipartFile> pictureList;
	//.. name="pictureArray" multiple
	private MultipartFile[] pictureArray;
	
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
	

	public MultipartFile getPicture2() {
		return picture2;
	}

	public void setPicture2(MultipartFile picture2) {
		this.picture2 = picture2;
	}

	
	
	
	public List<MultipartFile> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<MultipartFile> pictureList) {
		this.pictureList = pictureList;
	}

	public MultipartFile[] getPictureArray() {
		return pictureArray;
	}

	public void setPictureArray(MultipartFile[] pictureArray) {
		this.pictureArray = pictureArray;
	}

	@Override
	public String toString() {
		return "CustomerVO [cumId=" + cumId + ", cumName=" + cumName + ", cumJob=" + cumJob + ", cumLike=" + cumLike
				+ ", cumSkil=" + cumSkil + ", userId=" + userId + ", password=" + password + ", picture=" + picture
				+ ", picture2=" + picture2 + ", pictureList=" + pictureList + ", pictureArray="
				+ Arrays.toString(pictureArray) + "]";
	}

	

	
	

	

}
