function CheckAddCustomer(){
	//<input type="text" id="productId" name="productId" />
	let cumId = document.getElementById("cumId");
	let cumName = document.getElementById("cumName");

	// 회원 아이디 정규식
	if(!check(/^(?=.*[a-zA-z])(?=.*[0-9]).{5,16}$/, cumId, "아이디를 확인하세요 숫자+문자로 작성해주세요")){
      	return false;   //함수 멈춰
   }

	 //regExp : 정규식 / e : 대상객체 / msg : 메시지
   function check(regExp, e, msg){
      //test() : 맞니?틀리니? / exec() : 찾자
      //i) e.value => P1234
      //ii) e.value => S1234
      //iii) e.value => 1200000.35(o)
      //iv) e.value => 1200000.357(x)
      if(regExp.test(e.value)){
         return true;
      }
      alert(msg);
      e.select();   //글자선택
      e.focus();   //커서위치
      return false; //check()를 호출한곳으로 false를 리턴
   }
	

	//<form name="newProduct" ...
	document.frm.submit();
}
	










