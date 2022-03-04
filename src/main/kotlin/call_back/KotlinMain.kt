fun main() {
    val fred = Barista("Fred")
    val sam = Barista("Sam")
    fred.acceptOrder(CoffeeType.LATTE)
    sam.acceptOrder(CoffeeType.AMERICANO)
}

class Barista(val name: String) {
    private val coffeeMaker = CoffeeMaker()
    fun acceptOrder(type: CoffeeType) {
        val coffee = coffeeMaker.brewCoffee(type)
        println("$name finish brewing ${coffee.type}")
    }
}

data class Coffee(val type: CoffeeType)
class CoffeeMaker {
    fun brewCoffee(type: CoffeeType): Coffee {
/*        runBlocking {
            delay(type.brewTime)
        }*/
        blockingDelay(type.brewTime)
        return Coffee(type)
    }
}

enum class CoffeeType(val brewTime: Long) {
    AMERICANO(3000L),
    LATTE(8750L)
}
fun blockingDelay(time: Long) {
    Thread.sleep(time)
}