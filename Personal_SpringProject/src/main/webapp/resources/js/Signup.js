/**
 * 
 */
	var IDcheck = false; //id 체크 flag
	
	function back() {
		if (confirm("이전페이지로 이동하시겠습니까?") == false) {
			return;
		}
		location.href = "/membership/login.do";
	}
	//-------아이디 체크----------------------
	function id_check(f) {
		
		var mem_id = document.getElementById("mem_id"); 
		
		if (f.mem_id.value == '') {
			alert("아이디를 입력하세요");
			f.mem_id.focus();
			return;
		}
		
		// 첫글자는 반드시 영문소문자, 4~12자로 이루어지고, 숫자가  하나 이상 포함되어야한다.
        // 영문소문자와 숫자로만 이루어져야 한다.
        // \d : [0-9]와 같다. {n,m} : n에서 m사이
		if(!chk(/^[a-z][a-z\d]{3,11}$/, mem_id, "잘못된 형식의 ID입니다.(문자형식)")){
			//chk() 함수에서 리턴받은 결과가 false
			f.mem_id.focus();
			return false;
		} 
		if(!chk(/[\d]/, mem_id, "잘못된 형식의 ID입니다.(영문자와 숫자 하나이상 포함되어있는 4글자이상 12자이하)"))	{
			f.mem_id.focus();
			return false;
		} else {
			if (confirm(mem_id.value + " 가 맞습니까?") == true) {
				IDcheck = true;
				
				var url = "id_check.do";
	
				var param = "mem_id=" + encodeURIComponent(mem_id.value);

				sendRequest(url, param, idResult, "POST");
			}
		}
		
		
	}

	function idResult() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			var json = JSON.parse(data);

			// [{'reg_check':'yes'}]
			if (json.id_check == 'yes') {
				alert("사용할수 있는 아이디입니다.");
			} else if (json.id_check == 'no') 
			{
				alert("이미 등록되어있는 아이디입니다.");
			}

		}
	}
	//-------------------------------------
	
	//-------회원등록 체크----------------------
	function insert_send(f) {

		var mem_id = f.mem_id.value.trim();
		var mem_name = f.mem_name.value.trim();
		var mem_pw = f.mem_pw.value.trim();
		var pw1 = document.getElementById("pw1");
		var pw2 = document.getElementById("pw2");
		var mem_email = f.mem_email.value.trim();
		var email = document.getElementById("email");
		var mem_add = f.mem_add.value.trim();
		var mem_idnumber = f.mem_idnumber.value.trim();
		var mem_nick = f.mem_nick.value.trim();
		
		if(!chk(/^[\w-]{4,}@[\w-]+(\.\w+){1,3}$/, email, "이메일 형식이 잘못되었습니다."));
		
		// /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/ 
		//  => 8~15자의 특수문자가 포함된 비밀번호 정규식
		// 매개변수값에 .value를 사용해서 잘못된 결과가 나오게됨
		// =>.value를 넣게 되면 아래쪽에서 .value를 사용시pw1.value.value의 형태가 되어버림
		 /*if((pw1.value.value == pw2.value.value) && re.test(pw1.value.value)){
	        	return true;
	       }*/ 
		if(!pwchk(
			/^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/,
			pw1,
			pw2,
			"비밀번호 형식 맞지않거나  다릅니다.")){}
		else {

			if (IDcheck == false) {
				alert("아이디 중복을 먼저 체크 해주세요");
				return;
			}else{
				
				if (confirm("등록 하시겠습니까?") == true) {
					
					var url = "member_insert.do";
					
					var param = 
					"mem_name=" + encodeURIComponent(mem_name) 
					+ "&mem_id=" + encodeURIComponent(mem_id) 
					+ "&mem_pw=" + encodeURIComponent(mem_pw) 
					+ "&mem_email="	+ encodeURIComponent(mem_email)
					+ "&mem_idnumber="	+ encodeURIComponent(mem_idnumber)
					+ "&mem_add="	+ encodeURIComponent(mem_add)
					+ "&mem_nick="	+ encodeURIComponent(mem_nick);
					
					sendRequest(url, param, resultFn, "POST");
				}
			}
		}

	}
	
	//정규식 아이디 체크 함수(re: 정규식, e:태그아이디, msg:표시 메시지)
	//test() 함수는 매개변수에 대입되어있는 값의 문자열 패턴에 해당되는 문자열이 있으면 true, 없으면 false를 리턴한다.
	function chk(re, e, msg){
        if(re.test(e.value)){
        	return true;
        } 
        alert(msg);
        return false;
		
	}
	
	//패스워드 체크 함수
	function pwchk(re, pw1, pw2, msg){
		alert(pw1.value+"/"+pw2.value);
		
        if((pw1.value == pw2.value) && re.test(pw1.value)){
        	return true;
        } 
        alert(msg);
        return false;
	}

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			var json = JSON.parse(data);
			
			
			// [{'member_insert':'s'}]
			if (json.member_insert == 's') {
				location.href = "/myboard/login.do"
				alert("회원등록 성공 로그인페이지로 이동합니다.");
			} 
			else {
				alert("회원 등록 실패");
			}
			
		}
	}
	
	/* var pattern1 = /[0-9]/;	// 숫자 
	var pattern2 = /[a-zA-Z]/;	// 문자 
	var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/;	// 특수문자 */
	
	