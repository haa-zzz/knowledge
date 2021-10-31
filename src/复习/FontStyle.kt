package 复习

/**
 * Author Haa-zzz
 * Time 2021/8/5
 * 字体样式基类, 所有的字体样式都先封装成这个类，最后做统一处理
 */
const val NORMAL = 16
const val SMALL = 14
const val BIG = 18

open class FontStyle {
    @JvmField
    var isBold = false      //加粗，默认不是

    @JvmField
    var isItalic = false    //斜体的，默认不是

    @JvmField
    var isUnderline = false  //下划线，默认没有

    @JvmField
    var isStreak = false     //

    @JvmField
    var fontSize = 0        //字体大小

    @JvmField
    var color = 0           // 字体颜色
}