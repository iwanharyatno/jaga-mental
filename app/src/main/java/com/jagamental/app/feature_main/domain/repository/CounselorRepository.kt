package com.jagamental.app.feature_main.domain.repository

import com.jagamental.app.feature_main.domain.model.Counselor
import com.jagamental.app.feature_main.domain.model.Filter
import kotlinx.coroutines.flow.Flow

interface CounselorRepository {
    fun getCounselors() : Flow<List<Counselor>>
    fun getCounselors(filter: Filter) : Flow<List<Counselor>>
}