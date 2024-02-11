package com.jagamental.app.di

import com.jagamental.app.feature_main.data.repository.ArticleRepositoryImpl
import com.jagamental.app.feature_main.data.repository.ChatRepositoryImpl
import com.jagamental.app.feature_main.data.repository.CommunityRepositoryImpl
import com.jagamental.app.feature_main.data.repository.CounselorRepositoryImpl
import com.jagamental.app.feature_main.data.repository.NoteRepositoryImpl
import com.jagamental.app.feature_main.domain.repository.ArticleRepository
import com.jagamental.app.feature_main.domain.repository.ChatRepository
import com.jagamental.app.feature_main.domain.repository.CommunityRepository
import com.jagamental.app.feature_main.domain.repository.CounselorRepository
import com.jagamental.app.feature_main.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideArticleRepository() : ArticleRepository {
        return ArticleRepositoryImpl()
    }

    @Provides
    fun provideCounselorRepository() : CounselorRepository {
        return CounselorRepositoryImpl()
    }

    @Provides
    fun provideCommunityRepository() : CommunityRepository {
        return CommunityRepositoryImpl()
    }

    @Provides
    fun provideChatRepository() : ChatRepository {
        return ChatRepositoryImpl()
    }

    @Provides
    fun provideNoteRepository() : NoteRepository {
        return NoteRepositoryImpl()
    }
}