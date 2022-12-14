package com.example.services

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log

class MyIntentService2 : IntentService(NAME) {

    @Deprecated("Deprecated in Java")
    override fun onCreate() {
        super.onCreate()
        log("onCreate")
        setIntentRedelivery(true)
    }

    private fun log(message: String) {
        Log.d("MyService", "MyIntentService2: $message")
    }

    @Deprecated("Deprecated in Java")
    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(p0: Intent?) {
        log("onHandleIntent")
        val page = p0?.getIntExtra(PAGE, 0) ?: 0
        for (i in 0 until 5) {
            Thread.sleep(1000)
            log("Timer: $i $page")
        }
    }

    companion object {

        private const val NAME = "MyIntentService2"
        private const val PAGE = "page"

        fun newIntent(context: Context, page: Int): Intent {
            return Intent(context, MyIntentService2::class.java).apply {
                putExtra(PAGE, page)
            }
        }
    }
}