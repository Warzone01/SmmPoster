package com.kirdevelopment.smmposter.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ShowPostView: MvpView {

    fun startLoading()
    fun endLoading()
    fun showError(string: String)
    fun showAllNotes(request:Int)
    fun showEmptyList()
    fun clickListener()
    fun addNewPost()

}