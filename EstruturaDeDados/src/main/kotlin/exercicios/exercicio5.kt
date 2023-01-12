package exercicios
import java.util.*
import kotlin.math.abs

data class HashMap2<K, V>(
    private val buckets: Array<LinkedList<Pair<K, V>>?> = arrayOfNulls(16)
) {

    fun put(key: K, value: V) {
        val index = abs(key.hashCode() % buckets.size)

        var bucket = buckets[index]
        if (bucket == null) {
            bucket = LinkedList()
            buckets[index] = bucket
            bucket.add(Pair(key, value))
        } else {
            for (index in bucket.indices) {
                if (bucket[index].first == key) {
                    bucket[index] = key to value
                    return
                }
            }
            bucket.add(Pair(key, value))
        }
    }

    fun get(key: K): Pair<K, V>? {
        val index = abs(key.hashCode() % buckets.size)
        val bucket = buckets[index]

        if (bucket == null) {
            return null
        }

        return bucket.firstOrNull { it.first == key }
    }

    fun remove(key: K): Boolean? {
        val index = abs(key.hashCode() % buckets.size)
        val bucket = buckets[index] ?: return null

        return bucket.removeIf { it.first == key }
    }
}

data class Person1(
    val name: String
)

fun main() {
    val hashmap = HashMap2<Person1, String>()
    hashmap.put(Person1("a"), "b")
    hashmap.put(Person1("a"), "c")
    hashmap.put(Person1("b"), "c")
    hashmap.put(Person1("bc"), "c")
    hashmap.put(Person1("bd"), "c")
    hashmap.put(Person1("bea"), "c")
    hashmap.put(Person1("easdf"), "c")
    hashmap.put(Person1("easdf3"), "c")
    println(hashmap)

    println(hashmap.get(Person1("a")))
}