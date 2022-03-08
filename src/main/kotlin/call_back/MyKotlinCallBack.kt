package call_back

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun main() {
    val mSandogh = Sandogh("mahdi")
    val mFood = Food(FoodType.Shishleag)
    val tFood = Food(FoodType.Ghormeh)
    val aFood = Food(FoodType.Adas)
    mSandogh.acceptOrder(tFood)

    mSandogh.acceptOrder(aFood)
    mSandogh.acceptOrder(mFood)

}

data class Food(val type: FoodType)
enum class FoodType(val foodPrice: Long) {
    Shishleag(15000L),
    Ghormeh(10000L),
    Adas(5000L)
}

class Sandogh(val nameOfWorker: String){
    private val ashpaz = Ashpaz()
    fun acceptOrder(food: Food) {
        ashpaz.pokht(food,object : Ashpaz.AshpazPokhtListener {
            override fun pokhted(food: Food) {
                    println(food.type.name)
            }
        })
    }
}

class Ashpaz() {
    fun pokht(food: Food,callback:AshpazPokhtListener) {
        nonBlockingDelay(food.type.foodPrice){
            val pokhteFood= Food(food.type)
            callback.pokhted(pokhteFood)
        }

    }

    interface AshpazPokhtListener {
        fun pokhted(food: Food)
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
