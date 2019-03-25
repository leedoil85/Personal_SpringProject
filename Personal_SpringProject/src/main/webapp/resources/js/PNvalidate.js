/**
 * 
 */
function validate() {

	var num = document.getElementById("mem_idnumber");
	// var num2 = document.getElementById("unum2");
	var arrNum = new Array(); // 주민번호 숫자 13개를 담을 배열
	// var arrNum2 = new Array(); // 주민번호 뒷자리숫자 7개를 담을 배열

	// -------------- 주민번호 -------------
	// 한칸에서 전부 처리
	for (var i = 0; i < num.value.length; i++) {
		arrNum[i] = num.value.charAt(i);
	} // 주민번호를 배열에 순서대로 담는다.
	
	//캐시 삭제하니 코드 제대로 적용됨
	var tempSum = 0;
	var mulNum = 2;
	var index = 0;
	for (var i = 0; i < num.value.length; i++) {
		if (mulNum+i > 9) {// mulNum이 9를 초과하게 되었을때 2부터 다시 시작
			i = 0;
		}
		if (index == 12) {//배열num의 12자리이면 반복문 break 
			//alert("누적값"+tempSum);
			index = 0;
			break;
		}else{
			tempSum += arrNum[index] * (mulNum + i);// 각 자리에 대한 값을 tempSum에 누적
			//alert(arrNum[index]+" "+(mulNum+i));
			index++;
		}
	} // 주민번호 검사방법을 적용하여 번호를 모두 계산하여 더함

	/*for (var i = 0; i < num2.value.length - 1; i++) {
		if (i >= 2) {
			tempSum += arrNum2[i] * i;
		} else {
			tempSum += arrNum2[i] * (8 + i);
		}
	}*/ // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함
		
	//alert(lastNum +"!="+ arrNum[12])
	if ( (11-(tempSum % 11)) % 10 != arrNum[12] ) {//인덱스는 12까지
		alert("올바른 주민번호가 아닙니다.");
		num.value = "";
		num.focus();
		return false;
	} else {
		alert("올바른 주민등록번호 입니다.");
	}
}
