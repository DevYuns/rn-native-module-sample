package com.rnnativemodule.samplecomponent

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

class SampleNativeComponentEvent(surfaceId: Int, viewTag: Int): Event<SampleNativeComponentEvent>() {
    /*
        Event object that can be used by the RN android framework
        to pass events to the Typescript layer.
    */
    private val kEventName = "onUpdate"

    init {
        super.init(surfaceId, viewTag)
    }

    override fun getEventName(): String {
       return kEventName
    }

    override fun getEventData(): WritableMap? {
       val event = Arguments.createMap()
       event.putBoolean("isPressed", true)
       return event
    }
}