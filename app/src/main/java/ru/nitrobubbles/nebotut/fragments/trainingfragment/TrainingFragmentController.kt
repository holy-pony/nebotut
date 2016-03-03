package ru.nitrobubbles.nebotut.fragments.trainingfragment

import android.view.View
import ru.nitrobubbles.nebotut.api.dto.Training
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.subscriptions.CompositeSubscription

/**
 * Created by konstantinaksenov on 03.03.16.
 */
class TrainingFragmentController : Action1<Array<Training>>{
    var compositeSubsctiption : CompositeSubscription? = null

    override fun call(p0: Array<Training>?) {

    }

    val baseView : View

    constructor(baseView: View) {
        this.baseView = baseView

    }

    class ViewHolder{

    }

    fun connect(){
        compositeSubsctiption = CompositeSubscription()
        compositeSubsctiption?.add(
                SheduleProvider.getSheduleSubject()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this))
    }

    fun diconnect(){
        compositeSubsctiption?.unsubscribe()
    }
}