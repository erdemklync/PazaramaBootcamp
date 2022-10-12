package com.ekalyoncu.footballteams.util

import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.ekalyoncu.footballteams.R
import com.ekalyoncu.footballteams.model.Team
import com.ekalyoncu.footballteams.repository.PlayerRepository
import com.ekalyoncu.footballteams.repository.TeamRepository

fun ImageView.setTeamLogo(team: Team){
    val id = TeamRepository.teamDrawables.getOrElse(team.code){ R.drawable.img_default }
    val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
    this.setImageDrawable(drawable)
}

fun ImageView.setPlayerPhoto(team: Team){
    val id = PlayerRepository.playerDrawables.getOrElse(team.code){ R.drawable.img_default }
    val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
    this.setImageDrawable(drawable)
}