package com.jagamental.app.feature_main.data.repository

import com.jagamental.app.feature_main.domain.model.Counselor
import com.jagamental.app.feature_main.domain.model.Filter
import com.jagamental.app.feature_main.domain.repository.CounselorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlin.random.Random

class CounselorRepositoryImpl : CounselorRepository {
    override fun getCounselors(): Flow<List<Counselor>> {
        return flowOf(
            listOf(
                Counselor(
                    id = 1,
                    name = "Random person with cool names",
                    imgUrl = "https://i.pravatar.cc/300?t=1",
                    ratings = Random(1).nextDouble(4.0, 5.0),
                    isPro = true,
                ),
                Counselor(
                    id = 2,
                    name = "Random person with cool names",
                    imgUrl = "https://i.pravatar.cc/300?t=2",
                    ratings = Random(2).nextDouble(4.0, 5.0),
                    isPro = true,
                ),
                Counselor(
                    id = 3,
                    name = "Random person with cool names",
                    imgUrl = "https://i.pravatar.cc/300?t=3",
                    ratings = Random(3).nextDouble(4.0, 5.0)
                ),
                Counselor(
                    id = 4,
                    name = "Random person with cool names",
                    imgUrl = "https://i.pravatar.cc/300?t=4",
                    ratings = Random(4).nextDouble(4.0, 5.0),
                ),
                Counselor(
                    id = 5,
                    name = "Random person with cool names",
                    imgUrl = "https://i.pravatar.cc/300?t=5",
                    ratings = Random(5).nextDouble(4.0, 5.0)
                ),
                Counselor(
                    id = 6,
                    name = "Random person with cool names",
                    imgUrl = "https://i.pravatar.cc/300?t=6",
                    ratings = Random(6).nextDouble(4.0, 5.0)
                ),
            )
        )
    }

    override fun getCounselors(filter: Filter): Flow<List<Counselor>> {

        val allCounselor = listOf(
            Counselor(
                id = 2,
                name = "Random person with cool names",
                imgUrl = "https://i.pravatar.cc/300?t=1",
                ratings = Random(2).nextDouble(4.0, 5.0),
                isPro = true,
            ),
            Counselor(
                id = 1,
                name = "Random person with cool names",
                imgUrl = "https://i.pravatar.cc/300?t=2",
                ratings = Random(1).nextDouble(4.0, 5.0),
                isPro = true,
            ),
            Counselor(
                id = 3,
                name = "Random person with cool names",
                imgUrl = "https://i.pravatar.cc/300?t=3",
                ratings = Random(3).nextDouble(4.0, 5.0)
            ),
            Counselor(
                id = 4,
                name = "Random person with cool names",
                imgUrl = "https://i.pravatar.cc/300?t=4",
                ratings = Random(4).nextDouble(4.0, 5.0),
            ),
            Counselor(
                id = 5,
                name = "Random person with cool names",
                imgUrl = "https://i.pravatar.cc/300?t=5",
                ratings = Random(5).nextDouble(4.0, 5.0)
            ),
            Counselor(
                id = 6,
                name = "Random person with cool names",
                imgUrl = "https://i.pravatar.cc/300?t=6",
                ratings = Random(6).nextDouble(4.0, 5.0)
            )
        )

        return when(filter.name) {
            "semua" -> {
                flowOf(allCounselor)
            }

            "gratis" -> {
                flowOf(allCounselor.filter { !it.isPro })
            }

            else -> {
                flowOf(allCounselor)
            }
        }
    }
}