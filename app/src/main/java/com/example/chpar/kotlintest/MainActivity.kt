package com.example.chpar.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // -- 단어 --
    // expression = 값을 반환하는 형태

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 로컬변수 정의
        // val = 변할 수 없는 상수(final), 읽기 전용
        // var = 일반적인 변수
        val a:Int = 1
        val b = 1   // Int 추론 가능
        val c : Int // 멤버 변수로는 사용 x, 로컬 변수 o, Int를 생성자에서 초기화해야함
        c =1        // 생성자에서 초기화안하면 문법상 오류 발생

        sum(a,b)
        sum2(a,b)

        printString("hello!")
        getMul(null,null)
    }

    fun sum(a: Int, b: Int): Int{
        return a + b
    }

    // expression 몸체를 갖고 리턴 타입을 추론하는 함수
    fun sum2(a: Int, b: Int) = a + b

    // 의미있는 값을 리턴하지 않는 함수
    fun printSum(a: Int, b: Int): Unit {
        print(a + b)
    }

    // Unit 리턴 타입은 생략 가능
    fun printSum2(a: Int, b: Int){
        print(a + b)
    }

    // 문자열 템플릿 사용
    // '$'기호를 이용하여 문자 조합 가능
    // ex) val name = "chan"
    //     print("Hello $name!")
    fun printString(str:String){
        print("message = $str 입니다")
    }

    //조건식 사용하기
    fun max(a:Int, b:Int):Int{
        if(a>b)
            return a
        else
            return b
    }

    //식에 if 사용하기
    fun max2(a:Int, b:Int) = if(a>b)a else b

    //nullable 값을 리턴하는 함수 사용하기
    fun getMul(a:Int, b: Int){
        if(a != null && b != null){
            //null 검사 후에 x와 y를 non-nullable로 자동 변환
            print(a * b)
        }
    }

    //null 허용 함수(타입에 ?)
    fun getMul(a:Int?, b: Int?){
        if(a != null && b != null){
            print(a * b)
        }
    }

    //타입 검사와 자동 변환
    //'is' 연산자는 검사할 대상이 원하는 타입의 인스턴스인지 검사. 불변 로컬 변수나
    //프로퍼티에 대해 특정 타입인지 검사하면 명시적으로 타입 변환 필요 없음
    fun getStringLength(obj:Any):Int?{
        if(obj !is String){
            return null
        }
        //'obj'는 이 브랜치에서 자동으로 String으로 변환
        return obj.length
    }

    fun getStringLength2(obj:Any):Int?{
        //'&&'의 우측에서 자동으로 String으로 변환
        if(obj is String && obj.length > 0){
            return obj.length
        }
        return null
    }

    //for 루프 사용
    fun testFor(args:Array<Int>){
        for (b in args){
            print(b)
        }

        for(i in args.indices)
            print(args[i])
    }

    //while 루프
    fun testWhile(args:Array<String>){
        var i = 0
        while (i < args.size){
            print(args[i++])
        }
    }

    //when 식
    fun cases(obj:Any){
        when(obj){
            1 -> print("One")
            "Hello" -> print("Greeting")
            is Long -> print("Long")
            !is String -> print("Not a string")
            else -> print("unknown")
        }
    }

    // 범위(range)사용
    // 'in' 연산자를 사용해서 숫자가 특정 범위 안에 있는지 검사
    fun range(x:Int, y:Int, array:Array<Int>){
        if(x in 1..y-1)
            print("ok")

        //숫자가 범위 밖인지 검사
        if(x !in 0..array.lastIndex)
            print(x)

        //범위에 속한 숫자 순회(iteration)
        for(x in 1..5)
            print(x)
    }

    // 콜렉션 사용(여러 데이터를 모아놓은 하나의 단위)
    // ex) hasSetOf(...), arrayListOf(...), hashMapOf(key to value, ...)
    fun collection(text : String, names : Array<String>){
        //콜렉션 반복
        for(name in names)
            println(name)

        // 'in' 연산자를 사용해서 콜렉션이 객체를 포함하고 있는지 검사
        if(text in names)
        print("Yes")
        //콜렉션을 필터링하고 변환(맵)할 때 람다식 사용하기
        names.filter { it.startsWith("A") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { print(it) }
    }


























}
