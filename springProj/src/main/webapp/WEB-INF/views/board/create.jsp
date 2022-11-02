<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>

<script type="text/javascript">
$(function() {
   $("#aSubmit").on("click", function() {
      $("#frm").submit();
      alert("등록이 완료되었습니다.");    
   });
});
</script>
<script type="text/javascript">
$(function() {
	$("button").on("click",function(){
		//BookController의 /list의 URI에 매핑된 메소드를 실행
		location.href="/board/list";
	});
});  
</script>
<div class="card shadow mb-4">
   <!-- Card Header - Accordion -->
   <a href="#collapseCardExample" class="d-block card-header py-3"
      data-toggle="collapse" role="button" aria-expanded="true"
      aria-controls="collapseCardExample">
      <h6 class="m-0 font-weight-bold text-primary">Collapsable Card
         Example</h6>
   </a>
   <!-- Card Content - Collapse -->
   <div class="collapse show" id="collapseCardExample">
      <div class="card-body">
         <form id="frm" action="/board/create" method="post">
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumId
               </label> <input type="text" class="form-control" name="cumId" required="required"
                  placeholder="cumId">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumName
               </label> <input type="text" class="form-control" name="cumName"
                  required="required" placeholder="cumName">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumJob
               </label> <input type="text" class="form-control" name="cumJob" required="required"
                  placeholder="cumJob">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumLike
               </label> <input type="text" class="form-control" name="cumLike" required="required"
                  placeholder="cumLike">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumSkil
               </label> <input type="text" class="form-control" name="cumSkil" required="required"
                  placeholder="cumSkil">
            </div>
            <div class="mb-3">
               <a id="aSubmit" class="btn btn-primary btn-icon-split">
                  <span class="icon text-white-50"> <i class="fas fa-flag"></i>
               	  </span> 
               	  <span class="text">등록하기</span>
               </a>
               <button type="button">목록가기</button>
            </div>
         	</form>
          </div>
      </div>
   </div>