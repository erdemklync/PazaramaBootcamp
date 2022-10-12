package com.ekalyoncu.footballteams.repository

import com.ekalyoncu.footballteams.R

object PlayerRepository {

    /*
    fun ImageView.setPlayerPhoto(team: Team){
        val id = resources.getIdentifier("img_player_${team.code}", "drawable", context.packageName)
        val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
        this.setImageDrawable(drawable)
    }

    Alternatif olarak, drawable dosyası yukarıdaki gibi bir fonksiyon ile dinamik olarak çağrılabilir
    ancak bunun pek verimli bir yöntem olmadığı belirtiliyor.
     */
    val playerDrawables = mapOf(
        "fb" to R.drawable.img_player_fb,
        "gs" to R.drawable.img_player_gs,
        "bjk" to R.drawable.img_player_bjk,
        "ts" to R.drawable.img_player_ts,
    )

}