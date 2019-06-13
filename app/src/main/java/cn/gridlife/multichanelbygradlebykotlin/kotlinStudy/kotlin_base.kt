package cn.gridlife.multichanelbygradlebykotlin.kotlinStudy

fun main(args:Array<String>) {
    //测试可变参数函数
//    ChapterOne().vars(10,19,2,2,2,3,4,56,6);
    /**
     * lambda(匿名函数)
     */
//    println(ChapterOne().sumLambda(10,20))

    // 字符模板

    ChapterThree().charactorTemp()

    println("Null 检查机制")
//    ChapterFour(null).printResult()
//    if (args.size < 2) {
//        print("Two integers expected")
//        return
//    }
//    val x = parseInt(args[0])
//    val y = parseInt(args[1])
//    // 直接使用 `x * y` 会导致错误, 因为它们可能为 null.
//    if (x != null && y != null) {
//        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
//        print(x * y)
//    }

    //类型检测 及 自动类型转换
    ChapterFive().getStringLength("nihao")
    ChapterSix().printRangeData();
}
class ChapterOne{
    /**
     * Int 参数  返回值 为 Int类型
     */
    fun sum(a:Int,b:Int): Int{
        return a+b
    }

    /**
     * 表达式作为函数体，返回类型自动推断
     */
    fun sum1(a:Int,b:Int)=a+b
    public fun sum2(a:Int,b:Int):Int = a+b;// public 方法则必须明确写出返回值 类型

    /**
     * 无返回值的函数  Unit 可以省略（public 方法也可以省略）
     */
    fun printSum(a:Int,b:Int):Unit{
        print(a+b)
    }

    /**
     * 可变长参数 函数
     */

    fun vars(vararg v:Int){
        for (vt in v){
            print(vt)
        }
    }

    /**
     * lambda（匿名函数）——见main 测试
     */
    val sumLambda:(Int,Int)->Int={x,y->x+y}


}

/**
 * 定义 常量与 变量
 */
class ChapterTwo{
    /**
     * 可变变量定义：var关键字
     *
     * 不可变变量（常量） 定义： val关键字，只能复制一次的变量（类似java中的 final 修饰的变量）
     *
     * 常量与 变量都可以没有初始化值(局部作用于下 可以不初始化，全局变量就必须初始化)，但是再引用前必须初始化
     *
     * 编译器支持 自动类型判断，即生命是可以不指定类型，与编译器判断
     */

    val a:Int= 1
    val b=1
    val c:Int=1

    var x=5
   fun textVarAndVal(){
       val e:Int
       x+=1;

   }

}

/**
 * 字符串模板
 */
class ChapterThree{
//    $ 表示一个变量名或者变量值
//
//    $varName 表示变量值
//
//    ${varName.fun()} 表示变量的方法返回值:
    fun charactorTemp(){
        var a=1
        //模板中的简单名称
        val s1="a is $a"
        println(s1)
        a=2
        //模板中的任意表达式
        val s2="${s1.replace("is","was")},but now is $a"
        println(s2)
    }
}

/**
 * NULL 检查机制
 */
class ChapterFour(age:Int?){
   val age=age
    //抛出空指针异常
    val ages=this.age!!.toInt()

    //不做处理 返回 null
    val age1=this.age?.toInt();
    // age为空 返回-1
    val age2=this.age?.toInt()?:-1

    fun printResult(){
        println("age : ${this.age}")
        println("ages : $ages")
        println("age1 : $age1")
        println("age2 : $age2")
    }
}

/**
 * 类型检测及自动类型转换
 */
class ChapterFive{
    fun getStringLength(obj:Any):Int?{
        if(obj is String){
            // 做过类型判断后， obj会自动转换成String 类型
            println(obj.length)
            return obj.length
        }

        // 在这里还有一种方法，与java中 instanceof 不同，使用 !is

        if(obj !is String){
            print("obj !is String")
        }
        // 这里的obj仍然是Any类型的弱引用
        println(null)
        return null
    }
}
/**
 * 区间
 *
 * 区间表达式由 具有操作符形式 .. 的 rangeTo函数辅以 in和!in形成
 * 区间是为任何可比较类型定义的， 但对于整型类型，它有一个优化的实现，一下是使用区间的一些示例
 *
 */
class ChapterSix{
   fun printRangeData(){
       for(i in 1..5)
           print(i)
   }
}

