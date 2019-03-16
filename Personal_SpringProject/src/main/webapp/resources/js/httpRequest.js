/**
 * 
 */

var xhr = null;

function createRequest(){
	
	// JavaScript 를 이용하여 서버로 정보를 보내는 
	// 'HTTP request'를 만들기 위해서는 이런 기능을 제공하는 객체가 필요하다.
	
	// 이런 클래스는 IE(Internet Explorer) 에서는 XMLHTTP 라고 불린느 ActiveX object
	// 다른 브라우저에서도 Microsoft 의 Active 객체의 method, property를 지원하기 위해
	// XMLHttpRequest 클래스를 구현하고 있다.
	// 브라우저 구분해서 객체 생성해야함
	
	if( xhr != null ) return;	// 이미 만들었다면, return;
	
	if(window.ActiveXObject == true){
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}else {
		xhr = new XMLHttpRequest();
	}
}

//		 sendRequest(url, param, resultFn, "GET"); 로 호출했음
function sendRequest( url, param, callBack, method ){
	
	createRequest();	//HTTP request 생성
	
	// (1) 전송 타입(Method) 구분
	var httpMethod = "GET";
	
	if(method == 'POST' || method == 'post'){
		httpMethod = "POST";
	}
	
	// (2) 파라미터 구분
	var httpParam = null;
	
	if(param != null && param != ''){
		httpParam = param;
	}
	
	// (3) url
	var httpURL = url;
	
	// (4) 요청 방식이 Get 이고, 파라미터가 있다면, url을 직접 만들어줘야한다.
	if( httpMethod == 'GET' && httpParam != null ) {
		httpURL = httpURL + "?" + httpParam;	// ~~.~?param1=a&...
	}
	
	xhr.open( httpMethod, httpURL, true );	//요청 방식, 접근할 URL, 비동기( true)
	
	// post라면 반드시 필요한 작업, 요청(request)에 MINE type 설정
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	// 작업이 완료되고, 호출될 콜백 함수 지정
	xhr.onreadystatechange = callBack;
	
	// 호출
	xhr.send( httpMethod == "POST" ? httpParam : null);
}