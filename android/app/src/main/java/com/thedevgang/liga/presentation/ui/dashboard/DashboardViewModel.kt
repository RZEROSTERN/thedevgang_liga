package com.thedevgang.liga.presentation.ui.dashboard

import androidx.lifecycle.ViewModel
import com.thedevgang.liga.data.dao.Match

class DashboardViewModel : ViewModel() {
    fun retrieveMatches() : MutableList<Match> {
        var matches : MutableList<Match> = ArrayList()

        matches.add(Match("Bayern Munchen", "Munich, Germany",
            "https://cdn.icon-icons.com/icons2/1018/PNG/256/Bayern_Munchen_icon-icons.com_75868.png",
            "2", "Real Madrid C.F.",
            "Madrid, Spain",
            "https://cdn.icon-icons.com/icons2/1637/PNG/256/real-madrid_109486.png",
            "1"))

        matches.add(Match("Borussia Dortmund", "Dortmund, Germany",
            "https://cdn.icon-icons.com/icons2/1018/PNG/256/Borussia_Dortmund_icon-icons.com_75869.png",
            "4", "Barcelona F.C.",
            "Barcelona, Spain",
            "https://cdn.icon-icons.com/icons2/104/PNG/256/fc_barcelona_footballteam_18015.png",
            "0"))

        matches.add(Match("Juventus", "Turin, Italy",
            "https://p1.hiclipart.com/preview/746/421/93/juventus-logo-png-clipart.jpg",
            "3", "Paris St. Germain",
            "Paris, France",
            "https://cdn.icon-icons.com/icons2/383/PNG/256/Paris-Saint-Germain-icon-256_37658.png",
            "3"))

        return matches
    }
}
