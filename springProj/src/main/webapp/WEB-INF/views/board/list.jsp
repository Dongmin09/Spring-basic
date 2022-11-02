<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("[name='show']").on("change",function(){
		let val = $(this).val();
		// EL 태그의 값을 J/S 변수로 가져옴

 		location.href="<%=request.getContextPath()%>/board/list?currentPage=1&show="+val; 
	});
});
</script>

<!DOCTYPE html>
<html>
<head>
<title>Customer List</title>
</head>
<body>
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<form name="frm" id="frm" action="/board/list" method="get">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<div class="dataTables_length" id="dataTable_length">
							<label>Show <select id="show" name="show"
								aria-controls="dataTable"
								class="custom-select custom-select-sm form-control form-control-sm">
								<option value="10"
									<c:if test='${param.show eq 10}'>selected</c:if>
									>10</option>
									<option value="25"
									<c:if test='${param.show eq 25}'>selected</c:if>
									>25</option>
									<option value="50"
									<c:if test='${param.show eq 50}'>selected</c:if>
									>50</option>
									<option value="100"
									<c:if test='${param.show eq 100}'>selected</c:if>
									>100</option></select> entries
							</label>
						</div>
					</div>
					<div class="col-sm-12 col-md-6">
						<div id="dataTable_filter" class="dataTables_filter">
							<label>
								<input type="search" name="keyword"
								class="form-control form-control-sm" 
								placeholder="검색어를 입력하세요"
								aria-controls="dataTable"
								value="${param.keyword}" />
							</label>
							<label>Search:
								<button type="submit" class="btn btn-primary btn-icon-split btn-sm">
                                 <span class="icon text-white-50">
                                     <i class="fas fa-flag"></i>
                                 </span>
                                 <span class="text">통합검색</span>
                               </button>
							</label>
						</div>
					</div>
				</div>
				</form>
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting sorting_asc" tabindex="0"
										aria-controls="dataTable" rowspan="1" colspan="1"
										aria-sort="ascending"
										aria-label="Name: activate to sort column descending"
										style="width: 100px;">아이디</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 149px;">이름</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Office: activate to sort column ascending"
										style="width: 72px;">직업</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Age: activate to sort column ascending"
										style="width: 31px;">취미</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Age: activate to sort column ascending"
										style="width: 31px;">특기</th>
								</tr>
							</thead>
			
							<tbody>
							<!-- 
							before => data : List<CustomerVO> list / row : CustomerVO
							페이징 처리 after => data : ArticlePage.content이므로 
											data.content 해야지만 List<CustomerVO> list가 나옴
							 -->
							<c:forEach var="row" items="${data.content}" varStatus="stat">
								<c:if test="${stat.count%2==0}">
									<tr class="even" style="background-color:#f0f8ff;">
								</c:if>
								<c:if test="${stat.count%2!=0}">
									<tr class="odd">
								</c:if>
									<td class="sorting_1">${row.cumId}</td>
									<td>${row.cumName}</td>
									<td>${row.cumJob}</td>
									<td>${row.cumLike}</td>
									<td>${row.cumSkil}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
			            <div class="col-sm-12 col-md-7">
			               <a href="/board/create" id="create" class="btn btn-success btn-icon-split">
			                  <span class="icon text-white-50"> 
			                  	<i class="fas fa-check"></i>
			               	  </span> 
			               	  <span class="text">회원등록</span>
			               </a>
			            </div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-5">
						<div class="dataTables_info" id="dataTable_info" role="status"
							aria-live="polite">
								<!-- /board/list 보정 -->
								<c:if test="${param.show==null}">
									<c:set var="show" value="10" />
								</c:if>
								<c:if test="${param.show!=null }">
									<c:set var="show" value="${param.show}" />
								</c:if>
								<c:if test="${param.currentPage==null}">
									<c:set var="currentPage" value="1"/>
								</c:if>
								<c:if test="${param.currentPage!=null}">
									<c:set var="currentPage" value="${param.currentPage}" />
								</c:if>
								
								
								<!-- 현 화면에 보여지는 행 수 : show  -->
								<c:set var="show" value="${show}"></c:set>
								<!-- 종료행번호 : currentPage * 10행 -->
								<c:set var="endRow" value="${currentPage *show}" />
								<!--  시작행번호 : 종료행번호 - (10-1) -->
								<c:set var="startRow" value="${endRow-(show-1)}" />
								<c:if test="${endRow>data.total}">
									<c:set var="endRow" value="${data.total}" />
								</c:if>
								Showing ${startRow} to  ${endRow} of  ${data.total} entries	
						</div>
					</div>
					<div class="col-sm-12 col-md-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="dataTable_paginate">
							<ul class="pagination">
								<li class="paginate_button page-item previous
									<c:if test='${data.startPage lt 6}'>disabled</c:if>
								"
									id="dataTable_previous"><a href="/board/list?currentPage=${data.startPage-5}&show=${show}"
									aria-controls="dataTable" data-dt-idx="0" tabindex="0"
									class="page-link">이전</a></li>
									
			 				<c:forEach var="pNo" begin="${data.startPage}" end="${data.endPage}">
									<!-- class=".... active => 현재 페이지를 파랑색으로 보임 -->
									
									<li class="paginate_button page-item
										<c:if test='${currentPage==pNo}'>active</c:if>
									">	
										<a href="/board/list?currentPage=${pNo}&show=${show}"
										aria-controls="dataTable" data-dt-idx="1" tabindex="0"
										class="page-link">${pNo}</a>
									</li>
								</c:forEach> 	
								<!--	EL태그 정리  
									== : eq(equal)
									!= : ne(not equal)
									<  : lt(less than)
									>  : gt(greater than)
									<= : le(less equal)
									>= : ge(greater equal) 
								
								-->
								<li class="paginate_button page-item next 
									<c:if test='${data.endPage ge data.totalPages}'>disabled</c:if>
								" id="dataTable_next"><a
									href="/board/list?currentPage=${data.startPage+5}&show=${show}" aria-controls="dataTable" data-dt-idx="7" tabindex="0"
									class="page-link">다음</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>