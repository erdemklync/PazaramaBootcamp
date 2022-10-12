package com.ekalyoncu.footballteams.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val value: String,
):Parcelable
