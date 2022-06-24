package com.rnnativemodule.samplecomponent

import android.annotation.SuppressLint
import android.widget.LinearLayout
import com.facebook.react.uimanager.ThemedReactContext
import com.rnnativemodule.R

@SuppressLint("ViewConstructor")
class SampleNativeComponent(private val context: ThemedReactContext) : LinearLayout(context) {
    init {
        inflate(context, R.layout.sample_layout, this)
    }
}