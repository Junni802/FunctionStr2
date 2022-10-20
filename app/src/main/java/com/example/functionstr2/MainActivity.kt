package com.example.functionstr2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		var curYear = 2022

		Log.d("func", "${showMemberInfo(curYear, "880515-1234567")}")
		Log.d("func", "${showMemberInfo(curYear, "890515-2234567")}")
		Log.d("func", "${showMemberInfo(curYear, "000515-3234567")}")
		Log.d("func", "${showMemberInfo(curYear, "0105154234567")}")

		var f1 = "test.jpg"
		var f2 = "test.doc"
		var f3 = "test.gif"
		var f4 = "test.ppt"
		// 파일명을 isImagFile()함수를 이용하여 이미지인지 파일인지 여부를 받아와
		// 이미지 파일일 경우 'test.jpg는 파일입니다.'
		// 아니면 'test.dox는 이미지 파일이 아닙니다.' 라고 출력
		Log.d("fund", "${if(isImagFile(f1)) f1 + "이미지파일입니다" else  f1 + "이미지 파일이 아닙니다"}")
		Log.d("fund", "${if(isImagFile(f2)) f2 + "이미지파일입니다" else  f2 + "이미지 파일이 아닙니다"}")
		Log.d("fund", "${if(isImagFile(f3)) f3 + "이미지파일입니다" else  f3 + "이미지 파일이 아닙니다"}")
		Log.d("fund", "${if(isImagFile(f4)) f4 + "이미지파일입니다" else  f4 + "이미지 파일이 아닙니다"}")

		


	}
	// 현재 년도와 주민등록번호를 받아 생년월일과 성별, 나이를 출력하는 showMemberInfo() 함수 제작

	fun showMemberInfo(x : Int, x1 : String) : String{
		var first = if(x1.contains("-")) x1.substring(7, 8) else x1.substring(6, 7) // 하이픈이 있으면 한글자 더늘려서 짜르고 없으면 그대로 짜름
		var gender = if(first.equals("1") || first.equals("3")) "남자" else "여자"	// 1,3 이면 남자이므로 남자 else 여자로 저장
		var birth = if(first.equals("1") || first.equals("2")) "19" else "20"	// 1,2 이면 1900년도 나머지는 2000년도 저장을 위해 19, 20으로 나눔
		birth += x1.substring(0, 6)		// 생년월일 앞자리 2글자는 이미 저장되있고 나머지를 다더하는 식
		var age = x - birth.substring(0, 4).toInt()	// 나이는 지금 날짜에서 태어난 녀도 빼야 하므로 태어난년도를 구하기위해 생년월일에서 년도만 따로 빼서 나이를 구함
		var year = birth.substring(0, 4)
		var month = birth.substring(4, 6)
		var day = birth.substring(6)

		return "생년월일:" + year + "년" + month + "월" + day + "일생/성별:" + gender + "/나이:" + age + "살"
	}

	fun isImagFile(x : String) : Boolean{
		var str = x.substring(x.lastIndexOf('.') + 1)
		var arr = arrayOf("jpg", "png", "gif", "jpeg")
	return arr.contains(str.lowercase())
	}

}