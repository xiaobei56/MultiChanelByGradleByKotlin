package cn.gridlife.multichanelbygradlebykotlin.kotlinStudy

/**
 * 基本数据类型
 */
fun main(args: Array<String>) {

    ChapterOne_2().printChangLiang()
    ChapterTwo_2().printChapterTwo()

    println("数组")
    CHapterThree_2().arrayTest()

    println("字符串")
    ChapterFour_2().printStr("hello world!!")
    println("")
    ChapterFour_2().printMulitLineText()
    println("字符串模板")
    ChapterFive_2().printModel()
}

fun getType(any: Any): String {
    if (any is Int)
        return "Int"
    else if (any is Long)
        return "Long"
    else if (any is Char)
        return "Char"
    else if (any is Float)
        return "Float"
    else if (any is Double)
        return "Double"
    else if (any is Byte) {
        return "Byte"
    } else if (any is Short) {
        return "Short"
    } else if (any is String) {
        return "String"
    } else if (any is Boolean) {
        return "Boolean"
    } else
        return "any other"
}

/**
 * 基本数据类型
 *
 * Double
 * Float
 * Long
 * Int
 * Short
 * Byte
 *
 */
class ChapterOne_2 {
    fun printChangLiang() {

        val oneMillion = 1_000_000
        println("oneMillion's Type: ${getType(oneMillion)}")

        val creditCardNumber = 8999234_5678_9012_2345L
        println("creditCardNumber's Type: ${getType(creditCardNumber)}")

        val socialSecurityNumber = 999_99_9999L
        println("socialSecurityNumber's Type : ${getType(socialSecurityNumber)}")

        val hexBytes = 0xFF_EC_DE_5E
        println("hexBytes's Type: ${getType(hexBytes)}")

        val bytes = 0b11010010_01101001_10010100_10010010
        println("bytes's Type: ${getType(bytes)}")

        val c = "a"  //  ""  包裹的 是 String 类型
        println("c's Type: ${getType(c)}")

        val b = bytes.toChar();
        println("b's Type: ${getType(b)}")

        val d = 'd'   // ‘’包裹的是 Char类型
        println("d's Type: ${getType(d)}")
    }
}

/**
 * 比较两个数字
 *
 *    === 比较地址
 *    ==  比较值
 */
class ChapterTwo_2 {
    fun printChapterTwo() {
        val a: Int = 10000
        println(a === a)//true值相等，对象地址相等

        //经过了封装， 创建了两个不通的对象
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        //虽然经过了封箱，但是值是相等的

        println(boxedA === anotherBoxedA)//false 地址不一样
        println(boxedA == anotherBoxedA)//true 值相等

    }
}

/**
 * 数组
 *
 * 数组用类Array实现，并且还有一个size 属性 及 get和set方法，由于使用[] 重载了get和set方法，所以我们可以通过下标很方便的获取
 * 或者设置数据对应的位置的值
 *
 * 数组的创建两种形式： 一种是使用函数 arrayOf();
 * 另一种是使用工厂函数
 */
class CHapterThree_2 {
    fun arrayTest() {
        //[1,2,3]
        val a = arrayOf(1, 2, 3)
        //[0,2,4]
        val b = Array(10,{ i -> (i * 2) })

        println(a[0])//1
        println(b[9])//2


        //

        val x: IntArray= intArrayOf(1,2,3,4)
        x[0] = x[1]+x[2]
        println(x[0])
    }
}

/**
 * 字符串
 */
class ChapterFour_2{
    fun printStr(str:String){
        for(c in str){
            print(c)
        }
    }

    fun printMulitLineText(){
        val text="""
            多行字符
            多行字符啊
            多行 多习惯

            ABC
            ddA
              ddd
        """.trimIndent()// trimIndent() 去除前面多余的 空格
        println(text)
    }
}

/**
 * 字符串模板
 */
class ChapterFive_2{

    fun printModel(){
        val i=10
        val s="i=$i"
        println(s)

        val ss="runoob"
        val str="$s.length is ${s.length}"
        println(str)
    }
}
