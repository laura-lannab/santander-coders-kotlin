package codelabs

//a palavra open (antes de class) informa ao compilador que essa classe pode ser estendida

open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "online"

    //o construtor secundário possui os parâmetros que são as propriedades da classe, juntamente com o this que
    // inicializa o construtor primário (ele pode ou não ter parâmetro, mas se o construtor principal existir,
    // o secundário precisa inicializar o principal ->this)

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknow"
        }
    }

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }

}

class SmartTvDevide(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory){

}

fun main() {
    val smartTvDevice = SmartDevice("Android TV", "Entertainment")
    println("Device name is: ${smartTvDevice.name}")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}