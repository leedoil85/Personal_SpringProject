<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Table with Search Column Feature</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/Signup.js"></script>
<style type="text/css">
    body {
        color: #566787;
        background: #f7f5f2;
		font-family: 'Roboto', sans-serif;
	}
	.table-wrapper {
        background: #fff;
        padding: 20px 25px;
        margin: 30px auto;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
    .table-title {
		color: #fff;
		background: #40b2cd;		
		padding: 16px 25px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
        margin: 5px 0 0;
        font-size: 24px;
    }
	.search-box {
        position: relative;
        float: right;
    }
	.search-box .input-group {
		min-width: 300px;
		position: absolute;
		right: 0;
	}
	.search-box .input-group-addon, .search-box input {
		border-color: #ddd;
		border-radius: 0;
	}	
    .search-box input {
        height: 34px;
        padding-right: 35px;
        background: #f4fcfd;
        border: none;
        border-radius: 2px !important;
    }
	.search-box input:focus {
        background: #fff;
	}
	.search-box input::placeholder {
        font-style: italic;
    }
	.search-box .input-group-addon {
        min-width: 35px;
        border: none;
        background: transparent;
        position: absolute;
        right: 0;
        z-index: 9;
        padding: 6px 0;
    }
    .search-box i {
        color: #a0a5b1;
        font-size: 19px;
        position: relative;
        top: 2px;
    }
    table.table {
        table-layout: fixed;
        margin-top: 15px;
    }
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
    }
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }
    table.table th:first-child {
        width: 60px;
    }
    table.table th:last-child {
        width: 120px;
    }
    table.table td a {
        color: #a0a5b1;
        display: inline-block;
        margin: 0 5px;
    }
	table.table td a.view {
        color: #03A9F4;
    }
    table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #E34724;
    }
    table.table td i {
        font-size: 19px;
    }    
</style>
<script type="text/javascript">
$(document).ready(function(){
	// Activate tooltips
	$('[data-toggle="tooltip"]').tooltip();
    
	// Filter table rows based on searched term
    $("#search").on("keyup", function() {
        var term = $(this).val().toLowerCase();
        $("table tbody tr").each(function(){
            $row = $(this);
            var name = $row.find("td:nth-child(2)").text().toLowerCase();
            console.log(name);
            if(name.search(term) < 0){                
                $row.hide();
            } else{
                $row.show();
            }
        });
    });
});
</script>
</head>
<body>
  <form>
	<jsp:include page="../main.jsp" flush="false"/>
	
    <div class="container-fluid">
        <div class="table-wrapper">			
            <div class="table-title">
                <div class="row">
					<div class="col-sm-6">
						<h2>Member <b>Details</b></h2>
					</div>
                    <div class="col-sm-6">
                        <div class="search-box">
							<div class="input-group">								
								<input type="text" id="search" class="form-control" placeholder="Search by Name">
                                <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
							</div>
                        </div>
                    </div>
                </div>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th style="width: 15%;">ID</th>
                        <th style="width: 15%;">성명</th>
                        <th style="width: 18%;">이메일</th>
                        <th style="width: 10%;">주소</th>
                        <th style="width: 15%;">닉네임</th>
                        <th style="width: 13%;">주민등록번호</th>
                    </tr>
                </thead>
                <!--1. 개인정보중 민감한 주민등록번호 '*'로 replace
                	2. 멤버가 삭제될경우 idx가 뒤죽박죽 될 수도 있으므로 오름차순으로 정렬                	
                	3. 멤버가 많아질경우 스크롤이 길어질수있으므로 페이징 처리 * 
                	진행: 
                	1>결과값을 가지고 문자열을 jstl함수 fn:substring으로 잘라내어 7번째자리 까지 숫자를 출력하고 뒷자리는 직접 표시 하지않고'*'로 직접출력
                	2>오름차순 정렬
                	select 
                	mem_idx,mem_id,mem_email,mem_add,mem_nick,mem_idnumber 
                	where personal_member 
                	order by asc 
                	-->
                <tbody>
              
                <c:forEach var="vo" items="${list}">
                    <tr>
                        <td>${vo.mem_idx}</td>
                        <td id="mem_id">${vo.mem_id}</td>
                        <td>${vo.mem_name}</td>
                        <td>${vo.mem_email}</td>
                        <td>${vo.mem_add}</td>
                        <td>${vo.mem_nick}</td>
                        <td>${fn:substring(vo.mem_idnumber,0,fn:length(vo.mem_idnumber)-7 )}-${fn:substring(vo.mem_idnumber,6,7) }****** </td>
                        <td>
                            <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <a href="#" class="delete" title="Delete" data-toggle="tooltip" onclick='mem_del(this.form); return false'><i class="material-icons">&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!-- 훔.... 모르겠다... -->
            <div>
            	<ul class="pagination pagination-sm no-margin pull-right">
            		<li>
	            		<c:if test="${pageMaker.prev == true}" >
	            			<a href="/myboard/management.do?page=${pageMaker.startPage -1}&perPageNum=${pageMaker.pag.perPageNum}"></a>
	            		</c:if>
            		</li>
            		
            		<li>
            			<c:forEach items="">
            			</c:forEach>
            		</li>
            		
            		<li>
            			<c:if test="${pageMaker.next eq true and ${pageMaker.endPage > 0 }">
            				<a href="/myboard/management.do?page=${pageMaker.endPage + 1 }&prePageNum=${pageMaker.pag.perPageNum}"></a>
            			</c:if>
            		</li>
            		
            	</ul>
            </div>
        </div>
    </div>     
 </form>
</body>
</html>                                		                                                        