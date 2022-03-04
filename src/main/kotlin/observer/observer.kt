package observer

class Observable {
    var mObserver:Observer? = null
    fun register(funObserver:Observer?){
        mObserver = funObserver
    }
    fun onNewDataAvailable(data:Any?){
        mObserver?.getSms(data)
    }

}
class Observer{
/*    val observable = Observable()
    init {
        observable.register( this)
    }*/
    fun getSms(data :Any?){
        println("RECived data :$data")
    }
}
fun main(){
    val mainObservable = Observable()
    val registerMeAsObserver=Observer()
    mainObservable.register(registerMeAsObserver)
    mainObservable.onNewDataAvailable("mahdi is here")
}