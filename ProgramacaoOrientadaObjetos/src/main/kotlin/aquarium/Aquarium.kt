package aquarium

import kotlin.random.Random

class Aquarium {

    private val listOfFish: MutableList<Fish> = mutableListOf()

    private var dirty: Boolean = false

    fun addFish(fish: Fish) {
        if (dirty) {
            println("O aquário está sujo, você não pode adicionar mais peixes. Limpe o aquário!")
        } else {
            listOfFish.add(fish)
            println("${fish.name} foi adicionado ao aquário!")
            if (listOfFish.size % 3 == 0) {
                dirty = true
                println("O aquário está sujo, você não pode adicionar mais peixes. Limpe o aquário!")
            }
        }
    }

    fun feed() {
        when (val random = Random.nextInt(0, listOfFish.size + 1)) {
            listOfFish.size -> println("Todos os peixes foram alimentados!")
            0 -> println("Nenhum peixe foi alimentado")
            else -> {
                println("Somente alguns peixes se alimentaram! Total alimentado: $random")
            }
        }
    }

    fun clean() {
        dirty = false
        println("Você limpou o aquário!")
    }
}



