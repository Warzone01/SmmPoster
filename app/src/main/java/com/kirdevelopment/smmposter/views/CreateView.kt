package com.kirdevelopment.smmposter.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)

interface CreateView: MvpView {
    fun save()
    fun cancel()
    fun initMiscellaneous()
    fun delete()
    fun selectImage(path: String)
    fun selectVideo(path: String)
    fun selectAudio(path: String)
    fun selectDate(path: String)
}