package com.example.chpar.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // -- 단어 --
    // expression = 값을 반환하는 형태

    // -- 기능 --
    // '$'기호를 이용하여 문자 조합 가능
    // ex) val name = "chan"
    //     print("Hello $name!")

    var a:Int = 1
    var b = 1

//    멤버 변수로는 사용 x, 로컬 변수 o
//    val c : Int
//    c =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sum(1,2)
        sum2(1,2)

        val c : Int
        c =1
    }

    fun sum(a: Int, b: Int): Int{
        return a + b
    }

    //expression 몸체를 갖고 리턴 타입을 추론하는 함수
    fun sum2(a: Int, b: Int) = a + b

    //의미있는 값을 리턴하지 않는 함수
    fun printSum(a: Int, b: Int): Unit {
        print(a + b)
    }

    //Unit 리턴 타입은 생략 가능
    fun printSum2(a: Int, b: Int){
        print(a + b)
    }
}
