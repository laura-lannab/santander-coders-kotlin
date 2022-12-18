package exercicio4

//interface MotorCombustao{
//    val tipoBateriaPadrao: String;
//    val caminhao: String;
//    val trator: String;
//    fun abastecer()
//}
//
//interface MotorEletrico{
//    val tipoBateriaPadrao: String;
//    val carroEletrico: String;
//    val motoEletrica: String;
//    fun abastecer()
//}
//
//class Trator: MotorCombustao{
//    override val tipoBateriaPadrao: String
//        get() = TODO("Not yet implemented")
//    override val caminhao: String
//        get() = TODO("Not yet implemented")
//    override val trator: String
//        get() = TODO("Not yet implemented")
//
//    override fun abastecer() {
//        TODO("Not yet implemented")
//    }
//}
//
//class Moto: MotorEletrico{
//    override val tipoBateriaPadrao: String
//        get() = TODO("Not yet implemented")
//    override val carroEletrico: String
//        get() = TODO("Not yet implemented")
//    override val motoEletrica: String
//        get() = TODO("Not yet implemented")
//
//    override fun abastecer() {
//        TODO("Not yet implemented")
//    }
//}
interface Notas{
    val nome: String
}

interface Acordes: Notas{
 val listaDeNotas: MutableList<Notas>
}

interface Instrumento: Notas, Acordes{

}
