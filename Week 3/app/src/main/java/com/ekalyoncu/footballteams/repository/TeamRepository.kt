package com.ekalyoncu.footballteams.repository

import android.content.Context
import com.ekalyoncu.footballteams.R
import com.ekalyoncu.footballteams.model.Team
import com.ekalyoncu.footballteams.util.readTeamsJsonData
import com.google.gson.Gson

object TeamRepository {

    fun getTeamList(context: Context): List<Team> {

        val teamsJsonData = readTeamsJsonData(context)

        val teamsArray = Gson().fromJson(
            teamsJsonData,
            Array<Team>::class.java,
        )

        return teamsArray.toList().shuffled()
    }

    /*
    fun ImageView.setTeamLogo(team: Team){
        val id = resources.getIdentifier("img_team_${team.code}", "drawable", context.packageName)
        val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
        this.setImageDrawable(drawable)
    }

    Alternatif olarak, drawable dosyası yukarıdaki gibi bir fonksiyon ile dinamik olarak çağrılabilir
    ancak bunun pek verimli bir yöntem olmadığı belirtiliyor.
     */

    val teamDrawables = mapOf(
        "fb" to R.drawable.img_team_fb,
        "gs" to R.drawable.img_team_gs,
        "bjk" to R.drawable.img_team_bjk,
        "ts" to R.drawable.img_team_ts,
    )
}