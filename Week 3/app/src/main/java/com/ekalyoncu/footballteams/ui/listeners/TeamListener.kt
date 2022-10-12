package com.ekalyoncu.footballteams.ui.listeners

import com.ekalyoncu.footballteams.model.Team

interface TeamListener {
    fun onClick(team: Team)
}