package ru.nitrobubbles.nebotut.api.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by konstantinaksenov on 02.03.16.
 */

data class TrainingResponse(val status:Boolean, @SerializedName("result") val trainings: Array<Traning>)