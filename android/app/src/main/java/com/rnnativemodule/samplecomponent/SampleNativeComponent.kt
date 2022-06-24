package com.rnnativemodule.samplecomponent

import android.annotation.SuppressLint
import android.widget.LinearLayout
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.rnnativemodule.R

@SuppressLint("ViewConstructor")
class SampleNativeComponent(private val context: ThemedReactContext) : LinearLayout(context) {
    init {
        inflate(context, R.layout.sample_layout, this)
        this.setOnClickListener {
            val surfaceId = UIManagerHelper.getSurfaceId(context)
            UIManagerHelper.getEventDispatcherForReactTag(context, id)
                ?.dispatchEvent(SampleNativeComponentEvent(surfaceId, id))
        }
    }
}