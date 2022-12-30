package com.ruangaldo.ruanggame.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.ruangaldo.ruanggame.BuildConfig
import com.ruangaldo.ruanggame.data.remote.services.RawgService
import com.ruangaldo.ruanggame.util.network.NetworkUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideChuckInterceptors(@ApplicationContext context: Context): ChuckerInterceptor =
        ChuckerInterceptor.Builder(context)
            .collector(NetworkUtil.chuckerCollector)
            .maxContentLength(100_000L)
            .alwaysReadResponseBody(true)
            .build()

    @Singleton
    @Provides
    fun providesOkHttpClient(
        chuckInterceptor: ChuckerInterceptor
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addNetworkInterceptor(chuckInterceptor)
            .build()

    @Provides
    fun provideRetrofitRawg(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideRawgServices(retrofit: Retrofit): RawgService =
        retrofit.create(RawgService::class.java)

}
