package codelabs

import kotlin.properties.ReadWriteProperty

//a palavra open (antes de class) informa ao compilador que essa classe pode ser estendida

open class SmartDevice(val name: String, val category: String) {

    //protected: torna a declaração acessível em subclasses.
    var deviceStatus = "online"
        protected set

    open val deviceType = "unknow"

    //o construtor secundário possui os parâmetros que são as propriedades da classe, juntamente com o this que
    // inicializa o construtor primário (ele pode ou não ter parâmetro, mas se o construtor principal existir,
    // o secundário precisa inicializar o principal ->this)

//    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknow"
//        }
//    }

    open fun turnOn() {
        deviceStatus = "online"
    }

    open fun turnOff() {
        deviceStatus = "offline"
    }
}
class SmartTvDevide(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"
    private var speakerVolume = 1
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    private var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(deviceName, deviceCategory) {

    override val deviceType = "Smart Light"
    private var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off")
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
}

// Relações HAS-A e Relações IS-A
// A classe SmartHome abaixo HAS-A(tem um/uma) smartTVDevice.
// SmartHome HAS-A smart TV device e smart light.

class SmartHome(
    val smartTvDevice: SmartTvDevide,
    val smartLightDevice: SmartLightDevice
) {


    //private: torna a declaração acessível no mesmo arquivo de classe ou origem.
    var devideTurnOnCount = 0
        private set

    fun turnOnTv() {
        devideTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        devideTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffLight()
        turnOffTv()
    }
}

//class RangeRegulator() : ReadWriteProperty<Any?, Int> {
//
//}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevide("Android TV", "Entertainment")
//    println("Device name is: ${smartTvDevice.name}")
    smartDevice.turnOn()
    smartDevice.turnOff()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
    smartDevice.turnOff()

}