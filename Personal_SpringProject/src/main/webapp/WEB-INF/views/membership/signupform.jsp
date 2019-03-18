<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Sign Up</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/Signup.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/PNvalidate.js"></script> 

<style type="text/css">
	body {
		color: #fff;
		background: #3598dc;
		font-family: 'Roboto', sans-serif;
		
	}
    .form-control {
		min-height: 41px;
		box-shadow: none;
		border-color: #ddd;
		
	}
	.form-control .btn {        
        border-radius: 3px;
    }
	.signup-form {
		width: 390px;
		margin: 0 auto;
		padding: 30px 0;
		
	}
	.signup-form form {
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #fff;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form h2 {
		color: #333;
		font-weight: bold;
        margin-top: 0;
    }
    .signup-form hr {
        margin: 0 -30px 20px;
    }
	.signup-form .form-group {
		margin-bottom: 20px;
	}
    .signup-form label {
		font-weight: normal;
		font-size: 13px;
	}
	.signup-form input[type="checkbox"] {
		margin-top: 2px;
	}    
    .signup-form .btn {        
        font-size: 16px;
        font-weight: bold;
		background: #3598dc;
		border: none;
		min-width: 100px;
    }
	.signup-form .btn:hover, .signup-form .btn:active {
		background: #2389cd;
		outline: none !important;
	}
	.signup-form a {
		color: #fff;
        text-decoration: underline;
	}
    .signup-form a:hover {
        text-decoration: none;
    }
    .signup-form form a {
		color: #3598dc;
        text-decoration: none;
	}
    .signup-form form a:hover {
		text-decoration: underline;
	}
	.form-group .btn{
		font-size: small;
	}
</style>
</head>
<body>
<div class="signup-form">
    <form>
		<h2>회원가입</h2>
		<!-- <p>Please fill in this form to create an account!</p> -->
		<hr>
		
        <div class="form-group">
			<label>이름</label>
        	<input type="text" class="form-control" name="mem_name" required="required"> 
        </div>
        
        <div class="form-group">
			<label>아이디</label>
        	<input type="text" class="form-control" name="mem_id" id="mem_id" required="required"> 
        </div>
        
        <div class="form-group">
        	<button type="button" class="btn btn-primary btn-sm" onclick="id_check(this.form);">중복확인</button>
        </div>
        
        <div class="form-group">
			<label>Email</label>
        	<input type="text" class="form-control" name="mem_email" id="email" required="required">
        </div>
        
        <div class="form-group">
			<label>별명</label>
        	<input type="text" class="form-control" name="mem_nick" required="required">
        </div>
        
        <div class="form-group">
			<label>주민등록 번호</label>
            <input type="text" class="form-control" name="mem_idnumber" id="mem_idnumber" required="required">
        </div> 
        
        <div class="form-group">
        	<button type="button" class="btn btn-primary btn-sm" onclick="validate();">주민등록번호 확인</button>
        </div>
        
		<div class="form-group">
			<label>비밀번호</label>
            <input type="password" class="form-control" name="mem_pw" id="pw1" required="required">
        </div>
        
		<div class="form-group">
			<label>비밀번호 확인</label>
            <input type="password" class="form-control" name="confirm_password" id="pw2" required="required">
        </div> 
               
		<div class="form-group">
			<label>주소</label>
            <input type="text" class="form-control" name="mem_add" required="required">
        </div>        
        <!-- <div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
		</div> -->
		<div class="form-group">
            <button type="button" class="btn btn-primary btn-lg" onclick="insert_send(this.form);">완 료</button>
        </div>
    </form>
	<div class="text-center">아이디가 있다면<a href="/myboard/login.do"> 클릭!</a></div>
</div>
</body>
</html>                            