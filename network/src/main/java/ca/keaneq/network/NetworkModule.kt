package ca.keaneq.network

import android.content.Context
import ca.keaneq.network.impl.CacheControlInterceptor
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    internal fun providesOkHttpClient(
        interceptor: CacheControlInterceptor,
        cache: Cache
    ): OkHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    internal fun providesJsonAdapterFactory(
    ): JsonAdapter.Factory = KotlinJsonAdapterFactory()

    @Provides
    @Singleton
    internal fun providesCache(
        @ApplicationContext context: Context
    ): Cache = Cache(context.cacheDir, 5 * 1024 * 1024L)

    @Provides
    @Singleton
    internal fun providesMoshi(
        factory: JsonAdapter.Factory
    ): Moshi = Moshi.Builder()
        .addLast(factory)
        .build()

    @Provides
    @Singleton
    internal fun providesConverterFactory(
        moshi: Moshi
    ): Converter.Factory = MoshiConverterFactory
        .create(moshi)

    @Provides
    @Singleton
    fun providesApiService(
        client: OkHttpClient,
        factory: Converter.Factory
    ): PokeApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_POKEMON_URL)
        .addConverterFactory(factory)
        .client(client)
        .build()
        .create(PokeApi::class.java)
}