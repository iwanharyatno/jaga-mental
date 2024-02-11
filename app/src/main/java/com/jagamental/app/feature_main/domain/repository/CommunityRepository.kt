package com.jagamental.app.feature_main.domain.repository

import com.jagamental.app.feature_main.domain.model.Community
import kotlinx.coroutines.flow.Flow

interface CommunityRepository {
    fun getCommunities() : Flow<List<Community>>
}