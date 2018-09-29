package chansiqing.myapplication

/**
 * TODO:功能说明
 *
 * @author: chansiqing
 * @date: 2018-08-21 18:25
 */
class LeakManager {
    var listener: LeakListener? = null

    companion object {
        var instance: LeakManager? = null

        interface LeakListener {
            fun onListener()
        }
    }

    fun getInstance() {
        if (instance == null)
            instance = LeakManager()
    }

    fun addListener(listener: LeakListener) {
        this.listener = listener
    }
}