package ru.nitrobubbles.nebotut.api

import retrofit.http.GET
import retrofit.http.Query
import ru.nitrobubbles.nebotut.api.dto.TrainingResponse
import rx.Observable


/**
 * Created by konstantinaksenov on 02.03.16.
 */
interface NebotutService {
    @GET("/index.php?")
    fun getTrainings(@Query("date") last: Long, @Query("action") action: String): Observable<TrainingResponse>;

}