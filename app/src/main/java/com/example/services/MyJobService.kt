package com.example.services

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import kotlinx.coroutines.*

class MyJobService : JobService() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate() {
        log("onCreate")
        super.onCreate()
    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        log("onStartJob")
        coroutineScope.launch {
            for (i in 0 until 100) {
                delay(1000)
                log("Timer: $i")
            }
            jobFinished(p0, true)
        }
        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        log("onStopJob")
        return true
    }

    override fun onDestroy() {
        log("onDestroy")
        super.onDestroy()
        coroutineScope.cancel()
    }

    private fun log(message: String) {
        Log.d("MyService", "New message: $message")
    }
}
