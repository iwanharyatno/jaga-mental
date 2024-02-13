package com.jagamental.app.feature_main.util

sealed class NavRoute(val route: String) {
    object Home : NavRoute("nav-home")
    object Chat : NavRoute("nav-chat")
    object Music : NavRoute("nav-music")
    object Note : NavRoute("nav-note")
    object Report : NavRoute("nav-report")
    object ArticleList : NavRoute("nav-article-list")
    object ArticleDetail : NavRoute("nav-article-detail")
}
