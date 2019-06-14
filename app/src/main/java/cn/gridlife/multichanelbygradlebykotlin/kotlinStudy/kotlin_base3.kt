package cn.gridlife.multichanelbygradlebykotlin.kotlinStudy

/**
 * 基本数据类型
 */
fun main(args: Array<String>) {
    Chapter3When().printWhenDemo(7)
    println(Chapter3When().hasPrefix("1prefix111"))
    Chapter3CircleControl().printResult()
    Chapter3CircleControl().printWhile()
    Chapter3Six().printReaslut();
    Chapter3Seven().foo()
    Chapter3Seven().foo1()

    var person: Person = Person()

    person.lastName = "wang"

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")
}

/**
 * When   ：
 *
 * when 将它的参数和所有的分支条件顺序 比较，知道某个分支满足条件
 *
 * when既可以被当作表达式也可以被当作语句使用。如果它被当作表达式，符合条件的分支的值是整个表达式的值，如果当作语句使用，
 * 则忽略个别分支的值
 *
 * when类似其他语言的 switch操作符，
 */
class Chapter3When {
    fun printWhenDemo(x: Int) {
        when (x) {
            1 -> println("x==1")
            2 -> println("x==2")
            in 6..20 -> println("6--20")
            !in 20..30 -> println("不在20--30")
            2, 3, 5 -> println("3--5")
            else -> {
                println("x=$x")
            }
        }
    }

    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }
}

/**
 * 迭代
 */
class Chapter3CircleControl() {
    val array = arrayOf(10, 2, 39)
    fun printResult() {
        for (i in array.indices) {
            println(array[i])
        }

        for ((i, v) in array.withIndex()) {
            println("the element at $i is $v")
        }

    }

    fun printWhile() {
        println("---while 使用 -------")
        var x = 5
        while (x > 0) {
            println(x--)
        }
        println("-------do.. while 使用------")
        var y = 5
        do {
            println(y--)
        } while (y > 0)
    }

}

/**
 * 在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签。 要为一个表达式加标签，我们只要在其前加标签即可
 */
class Chapter3Six {
    fun printReaslut() {
        for (i in 1 until 100) {
            loop@ for (j in 1..100) {
                if (i % 10 == 5) {
                    println(i)
                    break@loop
                }
            }
        }
    }
}

/**
 * 标签处返回
 *
 * Kotlin 有函数字面量、局部函数和对象表达式。因此 Kotlin 的函数可以被嵌套。 标签限制的 return 允许我们从外层函数返回。 最重要的一个用途就是从 lambda 表达式中返回。回想一下我们这么写的时候
 */
class Chapter3Seven() {
    val ints = arrayOf(1, 2, 3, 4)
    fun foo() {
        ints.forEach lit@{
            if (it == 2) return@lit
            println(it)
        }
    }

    //它只会从 lambda 表达式中返回。通常情况下使用隐式标签更方便
    fun foo1() {
        ints.forEach {
            if (it == 3) return@forEach
            println(it)
        }
    }
}

/**
 *  构造函数
 */
class Chapter3Eight constructor(name: String) {
    val name: String

    init {// 初始化语块  构造函数初始化
        this.name = name
    }


    fun textConstructor() {
//        println(name)
    }
}

/**
 * getter 和 setter  field 后端变量
 */
class GetterAndSetter() {
    var superName: Int = 10
        get() = field   //后端变量
        set(value) {
            if (value < 10) {   //如果传入的值小于10返回该值
                field = value
            }else{
                field=-1    // 如果传入的值大于等于10 返回 -1
            }
        }
}

/**
 * getter 和 setter  field 后端变量
 */
class Person {

    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
}

/**
 * 使用 lateinit 关键字 延迟初始化
 */
class YanChiChuShiHua{
//    lateinit var subject: TestSubject

//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()  // dereference directly
//    }
}
class People(val firstName: String, val lastName: String) {
    //...
    fun printResult(){
        println("$firstName$lastName")
    }
}
class People1(var firstName: String, var lastName: String) {
    //...如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。在同一个类中代理另一个构造函数使用 this 关键字：(次 构造 要包含 主构造的参数)
    constructor(firstName: String,lastName: String,age:Int):this(firstName,lastName){

    }
//   var firstName=firstName
//    init {
//
//        println("FirstName is $firstName")
//    }
//    fun printResult(){
//        println("$firstName$lastName")
//    }
}

/**
 * 如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
 */
class DontCreateMe private constructor () {
}

/**
 * 注意：在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，这个构造函数会直接使用默认值。
 * 这使得 Kotlin 可以更简单的使用像 Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库。
 *
 */
class Customer(val customerName: String = "")


/**
 * 抽象类
 */
open class Base{
    open fun f(){}
}
abstract class Derived:Base(){
    override abstract fun f()
}

/**
 * 嵌套类
 */
class Outer {                  // 外部类
    private val bar: Int = 1
    class Nested {             // 嵌套类
        fun foo() = 2
    }

//    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
//    println(demo)    // == 2
}
/**
 * 内部类
 */
class Outer1{
    private val bar:Int=1
    var v="成员属性"
    /**
     * 嵌套内部类
     */
    inner class Inner{
        val b=bar
        fun  innerText(){
            var o=this@Outer1
            println("内部类可以引用 外部类的成员，例如："+ o.v)
        }
    }
}
/**
 * 匿名内部类
 */

class Test{
    var v="成员属性"
    fun setInterFace(test: TestInterface){
        test.test()
    }


    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例。
     */

//    var test = Test()
//    test.setInterFace(object : TestInterFace {
//        override fun test() {
//            println("对象表达式创建匿名内部类的实例")
//        }
//    })
}
/**
 * 定义接口
 */
interface TestInterface{
    fun test()
}

/**
 * 类的 修饰符
 */

//classModifier 类属性修饰符，标示类本身特性

/**
 * abstract 抽象类
 * final 类不可继承，默认属性
 * enum //枚举类
 * open  类可继承，类默认是 final的
 * annotation 注解类
 *
 */


// accessModifier: 访问权限 修饰符
/**
 * private  仅在同一个文件中课件
 * protected 同一个文件中或子类可见
 * public 所有调用的地方都可见
 * internal 同一个模块中 可见
 * 模块中使用修饰词
 *
 * 模块
在Kotlin编程中，模块是指一个项目，包含以下几种项目：

一个ide创建的 Module
一个Maven或者Gradle项目
通过一次调用Ant任务编译的一组文件
internal 修饰符是指成员的可见性是只在同一个模块中才可见的
        */