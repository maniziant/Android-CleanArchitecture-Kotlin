package com.fernandocejas.sample.framework.extension

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.fernandocejas.sample.framework.exception.ErrorEvent

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
        liveData.observe(this, Observer(body))

fun <L : LiveData<ErrorEvent>> LifecycleOwner.error(liveData: L, body: (ErrorEvent?) -> Unit) =
        liveData.observe(this, Observer(body))