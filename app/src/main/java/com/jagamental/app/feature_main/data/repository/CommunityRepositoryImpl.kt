package com.jagamental.app.feature_main.data.repository

import com.jagamental.app.feature_main.domain.model.Community
import com.jagamental.app.feature_main.domain.repository.CommunityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CommunityRepositoryImpl : CommunityRepository {
    override fun getCommunities(): Flow<List<Community>> {
        return flowOf(
            listOf(
                Community(
                    id = 1,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
                Community(
                    id = 2,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
                Community(
                    id = 3,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
                Community(
                    id = 4,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
                Community(
                    id = 5,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
                Community(
                    id = 6,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
                Community(
                    id = 7,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
                Community(
                    id = 8,
                    name = "Random Community",
                    imageUrl = "https://placehold.co/400x600.png"
                ),
            )
        )
    }
}