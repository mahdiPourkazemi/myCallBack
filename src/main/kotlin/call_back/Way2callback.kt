
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

/*
fun main() {
    val fred = Barista2("Fred")
    val sam = Barista2("Sam")
    fred.acceptOrder(CoffeeType2.LATTE)
    sam.acceptOrder(CoffeeType2.AMERICANO)
}
class Barista2(val name: String):CoffeeMaker2.OnCoffeeBrewListener {
    private val coffeeMaker = CoffeeMaker2()
    fun acceptOrder(type: CoffeeType2) {
        coffeeMaker.brewCoffee(type,this)
    }
    override fun onCoffeeBrewed(coffee: Coffee2) {
        println("$name finish brewing ${coffee.type}")
    }
}
data class Coffee2(val type: CoffeeType2)
class CoffeeMaker2 {
    fun brewCoffee(type: CoffeeType2, mCallback : OnCoffeeBrewListener) {
        val madeCoffee = Coffee2(type)
        nonBlockingDelay(type.brewTime){
            mCallback.onCoffeeBrewed(madeCoffee)
        }
        // mCallback.onCoffeeBrewed(madeCoffee)
    }
    interface OnCoffeeBrewListener{
        fun onCoffeeBrewed(coffee : Coffee2)
    }
}
enum class CoffeeType2(val brewTime: Long) {
    AMERICANO(3000L),
    LATTE(8750L)
}
/**
 * Emulate a delay by blocking the main thread.
 *
 * Warning: Never use this (lol)
 */
/*fun blockingDelay(time: Long) {
    Thread.sleep(time)
}*/

/**
 * Emulate a delay using threads.
 *
 * Warning: This is really just as an example.
 */
fun nonBlockingDelay(time: Long, complete: () -> Unit) {
    val completableFuture = CompletableFuture<String>()
    Executors.newCachedThreadPool().submit<Any?> {
        Thread.sleep(time)
        completableFuture.complete("")
        null
    }
    completableFuture.thenAccept { complete() }
}
*/