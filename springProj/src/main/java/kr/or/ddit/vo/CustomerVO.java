package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class CustomerVO {
	// 필수 입력
	@NotBlank
	private String cumId; // 고객아이디
	// 필수 입력 + 최대 3글자 허용
	@NotBlank
	@Size(max=3)
	private String cumName; // 고객이름
	private String cumJob; // 고객 직업
	private String cumLike; // 고객 취미
	private String cumSkil; // 고객 특기
	
	
	
	
	// 11/03 수업 진행중 추가함 과제랑 관련 x
	private String userId;
	private String password;
	
	// 자기 소개
	private String introduction;
	private MultipartFile picture;
	private MultipartFile picture2;
	//.. name="pictureList[0]" 
	private List<MultipartFile> pictureList;
	//.. name="pictureArray" multiple
	private MultipartFile[] pictureArray;
	
	
	   //보유 코인
	   private int coin = 100;
	   //생일(기본 :  2022/11/01 => 변경 : 20221101)
	   @DateTimeFormat(pattern="yyyy-MM-dd")
	   private Date birth;
	   //성별
	   private String gender;
	   //국적
	   private String nationality;
	   //보유 자동차들
	   private String[] cars;
	   private String car;
	   //취미들
	   private String[] hobbyList;
	   private String hobby;
	   //결혼유무
	   private boolean marriaged;
	   //중첩된 자바빈(1:1)
	   private AddressVO addressVO;
	   //중접된 자바빈(1:N)
	   private List<CardVO> cardVOList;
	
	   // 개발자 여부(Y,null)
	   private String developer;
	   // 외국인 여부(boolean 형이 더좋더라)
	   private boolean foreigner;
	   
	   private List<AttachVO> attachVOList;
	
	
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String[] getCars() {
		return cars;
	}

	public void setCars(String[] cars) {
		this.cars = cars;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String[] getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(String[] hobbyList) {
		this.hobbyList = hobbyList;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public boolean isMarriaged() {
		return marriaged;
	}

	public void setMarriaged(boolean marriaged) {
		this.marriaged = marriaged;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public List<CardVO> getCardVOList() {
		return cardVOList;
	}

	public void setCardVOList(List<CardVO> cardVOList) {
		this.cardVOList = cardVOList;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public boolean isForeigner() {
		return foreigner;
	}

	public void setForeigner(boolean foreigner) {
		this.foreigner = foreigner;
	}
	
	

	public List<AttachVO> getAttachVOList() {
		return attachVOList;
	}

	public void setAttachVOList(List<AttachVO> attachVOList) {
		this.attachVOList = attachVOList;
	}

	@Override
	public String toString() {
		return "CustomerVO [cumId=" + cumId + ", cumName=" + cumName + ", cumJob=" + cumJob + ", cumLike=" + cumLike
				+ ", cumSkil=" + cumSkil + ", userId=" + userId + ", password=" + password + ", introduction="
				+ introduction + ", picture=" + picture + ", picture2=" + picture2 + ", pictureList=" + pictureList
				+ ", pictureArray=" + Arrays.toString(pictureArray) + ", coin=" + coin + ", birth=" + birth
				+ ", gender=" + gender + ", nationality=" + nationality + ", cars=" + Arrays.toString(cars) + ", car="
				+ car + ", hobbyList=" + Arrays.toString(hobbyList) + ", hobby=" + hobby + ", marriaged=" + marriaged
				+ ", addressVO=" + addressVO + ", cardVOList=" + cardVOList + ", developer=" + developer
				+ ", foreigner=" + foreigner + ", attachVOList=" + attachVOList + "]";
	}

	

	
	

	

	

	

	
	

	

}
