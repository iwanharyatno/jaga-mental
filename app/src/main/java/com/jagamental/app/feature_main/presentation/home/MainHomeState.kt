package com.jagamental.app.feature_main.presentation.home

import com.jagamental.app.feature_main.domain.model.Article
import com.jagamental.app.feature_main.domain.model.Community
import com.jagamental.app.feature_main.domain.model.Counselor
import com.jagamental.app.feature_main.domain.model.Filter

data class MainHomeState(
    val articles: List<Article> = emptyList(),
    val counselors: List<Counselor> = emptyList(),
    val communities: List<Community> = emptyList(),
    val searchQuery: String = String(),
    val currentCounselorFilter: Filter = Filter("semua"),
    val filters: List<Filter> = listOf(
        Filter("semua", "Semua"),
        Filter("gratis", "Gratis"),
        Filter("pria", "Pria"),
        Filter("wanita", "Wanita"),
    )
)