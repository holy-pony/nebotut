package ru.nitrobubbles.nebotut.fragments.trainingfragment

import ru.nitrobubbles.nebotut.api.API
import ru.nitrobubbles.nebotut.api.dto.Training
import rx.subjects.BehaviorSubject


/**
 * Created by konstantinaksenov on 03.03.16.
 */

object SheduleProvider {
    private lateinit var shedule: BehaviorSubject<Array<Training>>

    init {
        shedule = BehaviorSubject.create()
    }

    fun updateShedule(date: Long) {
        API.getTranings(date).filter { it.status }.map { it.trainings }.subscribe (shedule)
    }

    fun getSheduleSubject(): BehaviorSubject<Array<Training>> {
        return shedule
    }
}