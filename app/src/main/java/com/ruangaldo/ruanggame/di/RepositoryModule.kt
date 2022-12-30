package com.ruangaldo.ruanggame.di

import com.ruangaldo.ruanggame.data.repository.GamesRepositoryImpl
import com.ruangaldo.ruanggame.domain.repository.IGamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideGamesRepository(gamesRepositoryImpl: GamesRepositoryImpl): IGamesRepository
}
