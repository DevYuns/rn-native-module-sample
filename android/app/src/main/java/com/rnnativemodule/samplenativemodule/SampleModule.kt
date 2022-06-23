package com.rnnativemodule.samplenativemodule

import android.os.Build
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.*
import java.text.SimpleDateFormat
import java.util.*
import com.facebook.react.bridge.ReactMethod
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class SampleModule(context: ReactApplicationContext): ReactContextBaseJavaModule(){
    override fun getName(): String {
       return "Sample"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @ReactMethod
    fun getCurrentTime(promise: Promise) {
        val date = ZonedDateTime.now(ZoneOffset.UTC).format(
            DateTimeFormatter.ISO_INSTANT)
        promise.resolve(date)
    }

}