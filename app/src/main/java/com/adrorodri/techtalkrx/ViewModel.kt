package com.adrorodri.techtalkrx

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

object ViewModel {
    val myRandomNumber: BehaviorSubject<Int> = BehaviorSubject.createDefault(getRandom())

    init {
        Observable.interval(10, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                myRandomNumber.onNext(getRandom())
            }
    }

    private fun getRandom() = (Math.random() * 1000).roundToInt()
}