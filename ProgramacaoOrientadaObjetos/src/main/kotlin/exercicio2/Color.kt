package exercicio2

data class RGB(val red: Int, val green: Int, val blue: Int)
data class CMYK(val ciano: Int, val magenta: Int, val yellow: Int, val key: Int)
data class HSV(val hue: Int, val saturation: Int, val value: Int)
data class HSL(val hue: Int, val saturation: Int, val luminosity: Int)


enum class Color(val hex: String, val rbg: RGB, val cmyk: CMYK, val hsv: HSV, val hsl: HSL) {
    BLUE(
        "#0941db",
        RGB(9, 65, 219),
        CMYK(96, 70, 0, 14),
        HSV(224, 96, 86),
        HSL(224, 92, 45)
    ),
    PURPLE(
        "#380275", RGB(56, 2, 117),
        CMYK(52, 98, 0, 54),
        HSV(268, 98, 46),
        HSL(268, 97, 23)
    );

    override fun toString(): String {
        return """
            Hex: ${this.hex}
            RGB: ${this.rbg.red}, ${this.rbg.green}, ${this.rbg.blue}
            CMYK: ${this.cmyk.ciano}%, ${this.cmyk.magenta}%, ${this.cmyk.yellow}%, ${this.cmyk.key}%
            HSV: ${this.hsv.hue}°, ${this.hsv.saturation}%, ${this.hsv.value}%
            HSL: ${this.hsl.hue}°, ${this.hsl.saturation}%, ${this.hsl.luminosity}%
        """.trimIndent()
    }

//    companion object{
//        val mult = 10
//    }
//
//    fun transform(): Int{
//        return mult.toInt()
//    }
}

fun main(){
    println(Color.BLUE)
    println(Color.PURPLE)
}