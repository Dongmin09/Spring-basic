<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(function(){
   
});
</script>
<script type="text/javascript">
function fn_chk(){
   let userPw = document.getElementById("userPw").value;
   let userPwCheck = document.getElementById("userPwCheck").value;
   // 비밀번호가 다를 떄 보여주는 멘트 영역
   let spanPwCheck = document.getElementById("spanPwCheck");
   
   console.log("userPw : " + userPw + " | userPwCheck : " + userPwCheck);
   
   if(userPw == userPwCheck){
      return true;
   } else {
      spanPwCheck.innerHTML = "비밀번호가 다릅니다.";
      return false;
   }
}

$(function(){
      //전역변수[0][1]..
      var count=1; //let으로도 많이 씀
      $('#plusBtn').on('click', function(){
         count++;   //2
         event.preventDefault();
         var hs = $("div#att");
           
         hs.append('<div class="form-group ab" id="attach'+ count + '"><input id="attachVOList' + count + '.filename" name="attachVOList[' + count + '].filename" placeholder="첨부파일" class="form-control form-control-user" type="text"></div>');
      });
      
      $('#minusBtn').on('click', function(){
         event.preventDefault();
         var ab = document.querySelectorAll('.ab');
         console.log(ab);
         
         if(count>0){
            $('.ab:last').remove();
            count--;
         }
      });
   });
</script>
<div class="container">

   <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
         <!-- Nested Row within Card Body -->
         <div class="row">
            <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
            <div class="col-lg-7">
               <div class="p-5">
                  <div class="text-center">
                     <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                  </div>
                  <form:form modelAttribute="memVO" class="user" method="post"
                     action="/previews/writePost" onsubmit="return fn_chk()">
                     <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                           <!-- id="userId" name="userId" -> path="userId" -->
                           <form:input class="form-control form-control-user"
                              path="userId" placeholder="userId" />
                           <font color="red"> <form:errors path="userId" />
                           </font>
                        </div>
                        <div class="col-sm-6">
                           <form:input class="form-control form-control-user"
                              path="userName" placeholder="userName" />
                        </div>
                        <font color="red"> <form:errors path="userName" />
                        </font>
                     </div>
                     <div class="form-group">
                        <form:input class="form-control form-control-user"
                           path="userEmail" placeholder="userEmail" />
                     </div>
                     <font color="red"> <form:errors path="userEmail" />
                     </font>
                     <div class="form-group">
                        <form:input class="form-control form-control-user"
                           path="updDate" placeholder="변경일자(yyyyMMdd)" />
                     </div>
                     <font color="red"> <form:errors path="updDate" />
                     </font>
                     <input type="button" class="btn btn-success btn-circle btn-sm" name="plusBtn" id="plusBtn" value="+" />
                            <input type="button" class="btn btn-danger btn-circle btn-sm" name="minusBtn" id="minusBtn" value="-" />
                               
                               <div id="att">
                           <div class="form-group ab">
                              <!-- attachVOList     : List<AttachVO>
                                  attachVOList[0] : AttachVO  -->
                              <form:input class="form-control form-control-user"
                                 path="attachVOList[0].filename" placeholder="첨부파일명1" />
                           </div>
                           <font color="red"> <form:errors path="attachVOList[0].filename" />
                           </font>
                           
                           <div class="form-group ab">
                              <!-- attachVOList     : List<AttachVO>
                                  attachVOList[0] : AttachVO  -->
                              <form:input class="form-control form-control-user"
                                 path="attachVOList[1].filename" placeholder="첨부파일명2" />
                           </div>
                           <font color="red"> <form:errors path="attachVOList[1].filename" />
                           </font>
                        </div>
                     
                     <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                           <!-- input type="password -> form:password -->
                           <form:password class="form-control form-control-user"
                              path="userPw" placeholder="Password" />
                        </div>
                        <font color="red"> <form:errors path="userPw" />
                        </font>
                        <div class="col-sm-6">
                           <input type="password" class="form-control form-control-user"
                              id="userPwCheck" placeholder="Repeat Password" />
                        </div>
                        <font color="red">
                           <span id="spanPwCheck" ></span>
                        </font>
                     </div>
                     <input type="submit" class="btn btn-primary btn-user btn-block"
                        value="Register Account" />
                  </form:form>
                  <p></p>
                  <p></p>
                  <p></p>
                  <p></p>
                  <p></p>
                  <p></p>
                  <p></p>
               </div>
            </div>
         </div>
      </div>
   </div>

</div>