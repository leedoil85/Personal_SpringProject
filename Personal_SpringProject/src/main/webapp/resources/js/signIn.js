/**
 * 
 */
function send(f){
				var mem_id = f.mem_id.value.trim();
				var mem_pw = f.mem_pw.value.trim();
				
				if(mem_id == '' || mem_pw == ''){
					alert("아이디  또는 비밀번호를 입력하세요!");
					return;
				}
				
				var url ="member_login.do";
				var param = "mem_id=" + encodeURIComponent(mem_id)+
							"&mem_pw=" + encodeURIComponent(mem_pw);
				//login.korea?=id=111&pwd=222 형태를 만든다.
				
				sendRequest(url, param, loginResultFn, "POST");
			}
			
			function loginResultFn(){ // id/pwd 체크 후 콜백될 함수
				if( xhr.readyState == 4 && xhr.status == 200 ){
					var data = xhr.responseText;
					//alert(data);
					var json = JSON.parse(data);
					
					if(json.jsonData == 'no_id'){
						alert("아이디가 존재하지 않습니다.");
					}else if(json.jsonData == 'no_pw'){						
						alert("비밀번호가 일치하지 않습니다.");
					}else if(json.jsonData == 'clear'){
						//정상이라면 페이지 이동
						//main 페이지를 보이기 전에 거쳐갈 컨트롤러 서블릿
						alert("로그인 완료");
						//location.href = "/quiz/main.korea";//메인 페이지 연결
					}
				}
			}
			
			function logout(){
				location.href="../quiz/logout.korea";
			}
			
			function test(){
				location.href="../quiz/test.korea";
			}
			
			function member_reg_go(){
				location.href="../quiz/member_reg.korea";
			}