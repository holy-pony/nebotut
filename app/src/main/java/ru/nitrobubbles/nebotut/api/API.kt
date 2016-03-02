package ru.nitrobubbles.nebotut.api

import retrofit.RestAdapter
import ru.nitrobubbles.nebotut.BuildConfig
import ru.nitrobubbles.nebotut.api.dto.TrainingResponse
import rx.Observable

/**
 * Created by konstantinaksenov on 02.03.16.
 */
object API {
    private lateinit var nebotutService: NebotutService

    init {
        val nebotutAdapter = RestAdapter.Builder()
                .setEndpoint(BuildConfig.SERVER_ENDPOINT)
                .build()
        nebotutService = nebotutAdapter.create(NebotutService::class.java)
    }

    fun getTranings(timestamp: Long, action: String = "day"): Observable<TrainingResponse> {
        return nebotutService.getTrainings(timestamp, action);
    }
}