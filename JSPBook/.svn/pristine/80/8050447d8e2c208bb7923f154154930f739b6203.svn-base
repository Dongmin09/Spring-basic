package BookMarket.dao;

import java.util.ArrayList;
import java.util.List;

import BookMarket.dto.Book;

public class BookRepository {
	
	// 도서 목록 리스트 생성!
	private List<Book> listOfBook = new ArrayList<Book>();
	
	
	public BookRepository() {
		
		// 점프 투 파이썬 (도서코드, 도서이름, 가격)
		Book book1 = new Book("B001", "점프 투 파이썬", 18800);
		
		// 저자 이름
		book1.setAuthor("박응용");
		
		// 도서 설명
		book1.setDesciption("프로그래밍을 처음 공부하려는 사람들이 배울 수 있는 프로그래밍 언어는"
				+"상당히많다. 하지만 처음 배울 언어를 선택할 때는 약간의 주의가 필요하다."
				+"너무 어려운 언어를 선택하거나 특정 기술에 특화된 언어를 선택할 경우"
				+"자칫 잘못하면 '우물 안 개구리'가 될 수도 있기 때문이다."
				+"이 책을 들고 있는 여러분은 아마 파이썬의 명성에 대해 들어본 적이 있을 것이다. 많은"
				+"사람들이 초보자가 배우기 좋은 언어로 파이썬을 추천한다."
				+"처음 프로그래밍의 세계에 발을 들인 사람들이 어려운 문법 때문에 포기하는 경우가"
				+"많은데, 파이썬은 프로그래밍의 핵심 개념을 아주 쉽게 배울 수 있기 때문이다."
				+"파이썬은 이제 C,C++,자바 등과 어께를 나란히 할 만큼 유명한 언어가 되었지만"
				+"파이썬이 자바보다 더 오래된 언어라는 것을 아는 사람은 드물다. 파이썬은 혜성처럼"
				+"갑자기 등장해서 유명해진 스타 언어가 아닌, 그 역사가 매우 오래되어 숙성된 언어이기도 하다.");
		
		// 도서 재고수
		book1.setUnitInStock(94);
		
		// 도서 페이지 수
		book1.setWholePage(356);
		
		// 도서 출판일
		book1.setPublicationDate("2019년6월20일");
		
		//----------------------------------------------------------------
		
		Book book2 = new Book("B002", "혼자 공부하는 자바", 24000);
		
		// 저자 이름
		book2.setAuthor("신용권");
				
		// 도서 설명
		book2.setDesciption("누구나 혼자 할 수 있습니다! 야심 찬 시작이 작심삼일이 도지 않도록"
				+"돕기 위해서<혼자 공부하는> 시리즈를 만들었습니다. 낯선 용어와 친해져서"
				+"책장을 술술 넘기며 이해하는 것, 그래서 완독의 기쁨을 경험 하고 다음 단계를 스스로"
				+"선택할 수 있게 되는 것이 목표입니다. 지금 시작하세요. <혼자 공부하는> 사람들이"
				+"'때론 혼자,때론 같이'하며 힘이 되겠습니다.");
				
		// 도서 재고수
		book2.setUnitInStock(173);
				
		// 도서 페이지 수
		book2.setWholePage(682);
				
		// 도서 출판일
		book2.setPublicationDate("2019년6월10일");
		
		
		//----------------------------------------------------------------------
		
		
		Book book3 = new Book("B003", "Oracle11g프로그래밍", 23000);
		
		// 저자 이름
		book3.setAuthor("성윤정");
				
		// 도서 설명
		book3.setDesciption("데이터베이스를 처음 학습하는 초보자가 매일 먼저 고민하게 되는 부분은"
				+"어떤 책으로 어떻게 공부하느냐? 하는 것입니다. 이 책을 쓰게 된 계기는 오라클을"
				+"보다 단시간에 효과적으로 학습하는 방법을 제시해 보자는 의미에서 쓰게 되었습니다."
				+"따라서 이 책은 데이터베이스에 대한 전반적인 개념과 함께 SQL을 처음 공부하는 초보자를"
				+"대상으로 구성하였습니다.");
				
		// 도서 재고수
		book3.setUnitInStock(49);
				
		// 도서 페이지 수
		book3.setWholePage(457);
				
		// 도서 출판일
		book3.setPublicationDate("2019년6월10일");
		
		
		
		listOfBook.add(book1);
		listOfBook.add(book2);
		listOfBook.add(book3);
		
	}
	
	public List<Book> getAllBook(){
		
		return listOfBook;
	}
	
	
	public Book getBookByCode(String bookCode) {
		
		Book bookByCode = null;
		
		for(Book book : listOfBook) {
			if(book.getBookCode().equals(bookCode)) {
				bookByCode = book;
				break;
			}
		}
		
		return bookByCode;
	}
}
