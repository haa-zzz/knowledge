package demo

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.lang.reflect.Proxy.newProxyInstance
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

interface FaceDemo {
    fun run()
}
object ProxyDemo {
    @JvmStatic
    fun main(args : Array<String>){
        val request = Proxy.newProxyInstance(FaceDemo::class.java.classLoader ,
                arrayOf<Class<*>>(FaceDemo::class.java)
        ) { proxy, method, args -> println("method = ${method.name}   我在这里运行 "  ) } as FaceDemo
        println(request.javaClass)
        //调用方法
        request.run()
    }
}
