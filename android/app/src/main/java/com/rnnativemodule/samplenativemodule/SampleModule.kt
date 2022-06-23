package com.rnnativemodule.samplenativemodule

import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.*
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.modules.core.DeviceEventManagerModule
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class SampleModule(private val context: ReactApplicationContext): ReactContextBaseJavaModule() {
    private val _mainHandler = Handler(Looper.getMainLooper())
    var secondsCount = 0

    override fun getName(): String {
       return "Sample"
    }

    private fun sendEvent(reactContext: ReactContext, eventName: String, params: WritableMap) {
        reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
            .emit(eventName, params)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @ReactMethod
    fun getCurrentTime(promise: Promise) {
        val date = ZonedDateTime.now(ZoneOffset.UTC).format(
            DateTimeFormatter.ISO_INSTANT)
        promise.resolve(date)
    }

    @ReactMethod
    fun dispatchEventEverySecond() {
        _mainHandler.post(object : Runnable {
            override fun run() {
                secondsCount += 1
                val event = Arguments.createMap()
                event.putInt("count", secondsCount)
                sendEvent(
                    context,
                    "onTimeUpdated",
                    event
                )
                _mainHandler.postDelayed(this, 1000)
            }
        })
    }


    @ReactMethod
    fun addListener(eventName: String?) {
        // Keep: Required for RN built in Event Emitter Calls.
    }

    @ReactMethod
    fun removeListeners(count: Int?) {
        // Keep: Required for RN built in Event Emitter Calls. O
    }

}