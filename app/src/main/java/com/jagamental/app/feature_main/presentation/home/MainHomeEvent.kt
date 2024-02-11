package com.jagamental.app.feature_main.presentation.home

import com.jagamental.app.feature_main.domain.model.Filter

sealed class MainHomeEvent {
    data class ChangeSearchQuery(val value: String) : MainHomeEvent()
    data class ChangeCounselorFilter(val value: Filter) : MainHomeEvent()
}
