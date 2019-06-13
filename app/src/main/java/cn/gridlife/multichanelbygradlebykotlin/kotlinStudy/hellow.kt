package cn.gridlife.multichanelbygradlebykotlin.kotlinStudy

fun main(args: Array<String>) {
    Greeter("world!").greet();
    Greeter("").greet("china")
}

class Greeter(var name:String){
    fun greet(){
        println("hello,$name")
    }

    fun greet(str:String){
        println("hello, $str")
    }

}