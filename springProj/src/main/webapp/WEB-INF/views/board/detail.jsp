<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/validation.js"></script>

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
         <form id="frm" action="/board/create" name="frm" method="post" enctype="multipart/form-data">
           <label for="exampleFormControlInput1" class="form-label">cumId</label> 
            <div class="mb-3 abc">
               <input type="text" class="form-control" id="cumId" name="cumId" required="required"
                  placeholder="cumId" value="${customerVO.cumId}" readonly="readonly">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumName
               </label> <input type="text" class="form-control" name="cumName" id="cumName"
                  readonly="readonly" placeholder="cumName" value="${customerVO.cumName}">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumJob
               </label> <input type="text" class="form-control" name="cumJob" id="cumJob" readonly="readonly"
                  placeholder="cumJob" value="${customerVO.cumJob}">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumLike
               </label> <input type="text" class="form-control" name="cumLike"  id="cumlike" readonly="readonly"
                  placeholder="cumLike" value="${customerVO.cumLike}">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">cumSkil
               </label> <input type="text" class="form-control" name="cumSkil"  id="cumSkil" readonly="readonly"
                  placeholder="cumSkil" value="${customerVO.cumSkil}">
            </div>
            <div class="mb-3">
               <label for="exampleFormControlInput1" class="form-label">증명사진
			    <input class="form-control" type="file" id="productImage" 
			    name="pictureArray"	multiple style="display: none;" />
            </div>
            <div class="mb-3">
              <div class="imgs_wrap">
              	<!-- 컨트롤러에서 직접 가져오기  -->
              	<c:forEach var="attachVO" items="${attachVOList}">
              		<img src="/resources/upload${attachVO.attachName}" style="width: 100px;"/>
              	</c:forEach>
              	
              	<hr/>
              	<!-- attachVO 객체의 멤버변수를 끄집어냄  -->
              	<c:forEach var="attachVO" items="${customerVO.attachVOList}">
              		<img src="/resources/upload${attachVO.attachName}" style="width: 100px;"/>
              	</c:forEach>
              	
              	
              </div>
            </div>
            <div class="mb-3">
               <button type="button" id="btnSubmit" onclick="CheckAddCustomer()" class="btn btn-primary btn-icon-split" disabled>
                  <span class="icon text-white-50"> <i class="fas fa-flag"></i>
               	  </span> 
               	  <span class="text">등록하기</span>
               </button>
         		<a href="/board/list" type="button"
                  class="btn btn-secondary btn-icon-split" >
                  <span class="icon text-white-50"> <i class="fas fa-flag"></i>
                  </span> <span class="text">취소</span>
               </a>
            </div>
         	</form>
          </div>
      </div>
   </div>