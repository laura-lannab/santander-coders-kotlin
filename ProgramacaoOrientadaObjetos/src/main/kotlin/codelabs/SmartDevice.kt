package codelabs

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

//a palavra open (antes de class) informa ao compilador que essa classe pode ser estendida

open class SmartDevice(val name: String, val category: String) {

    //protected: torna a declaração acessível em subclasses.
    open var deviceStatus = "online"
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

    open fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"
//    private var speakerVolume = 1
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }

//    private var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
// substituidos por:

    var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
    var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

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

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number increased to $channelNumber.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(deviceName, deviceCategory) {

    override val deviceType = "Smart Light"

//    private var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
// substituidos por:


    var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

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

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness increased to $brightnessLevel.")
    }
}

// Relações HAS-A e Relações IS-A
// A classe SmartHome abaixo HAS-A(tem um/uma) smartTVDevice.
// SmartHome HAS-A smart TV device e smart light.

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {


    //private: torna a declaração acessível no mesmo arquivo de classe ou origem.
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun decreaseTvVolume() {
        smartTvDevice.decreaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun turnOffAllDevices() {
        turnOffLight()
        turnOffTv()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
}

//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevide("Android TV", "Entertainment")
////    println("Device name is: ${smartTvDevice.name}")
//    smartDevice.turnOn()
//    smartDevice.turnOff()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//    smartDevice.turnOff()
//
//}

// TODO Na classe SmartHome, faça com que todas as ações possam ser realizadas apenas quando a propriedade
//  deviceStatus de cada dispositivo estiver definida como uma string "on".
//  Além disso, verifique se a propriedade deviceTurnOnCount foi atualizada corretamente.