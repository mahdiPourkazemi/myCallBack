package call_back

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun main() {
    val mSandogh = Sandogh("mahdi")
    val mFood = Food(FoodType.Shishleag)
    val tFood=Food(FoodType.Ghormeh)
    val aFood=Food(FoodType.Adas)
    println( mSandogh.acceptOrder(tFood).toString()+" is ready")

    println( mSandogh.acceptOrder(aFood).toString()+" is ready")
    println( mSandogh.acceptOrder(mFood).toString()+" is ready")

}

data class Food(val type: FoodType)
enum class FoodType(val foodPrice: Long) {
    Shishleag(20000L),
    Ghormeh(10000L),
    Adas(5000L)
}

class Sandogh(val nameOfWorker: String) {
    private val ashpaz = Ashpaz()
    fun acceptOrder(food: Food): FoodType {
        return ashpaz.pokht(food)

    }
}

class Ashpaz() {
    fun pokht(food: Food): FoodType {
        blockingDelay(food.type.foodPrice)
        return food.type
    }
}

fun blockingDelay(time: Long) {
    Thread.sleep(time)
}
fun nonBlockingDelay(time: Long, complete: () -> Unit) {
    val completableFuture = CompletableFuture<String>()
    Executors.newCachedThreadPool().submit<Any?> {
        Thread.sleep(time)
        completableFuture.complete("")
        null
    }
    completableFuture.thenAccept { complete() }
}
