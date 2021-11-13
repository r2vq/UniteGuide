package ca.keaneq.network

import android.content.Context
import ca.keaneq.network.impl.CacheControlInterceptor
import ca.keaneq.network.impl.PokeClientImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    @Binds
    @Singleton
    internal abstract fun bindsPokeClient(
        pokeClientImpl: PokeClientImpl
    ): PokeClient

    companion object {
        @Provides
        @Singleton
        internal fun providesApiService(
            @ApplicationContext context: Context,
        ): PokeApi {
            val adapterFactory = KotlinJsonAdapterFactory()
            val moshi = Moshi.Builder()
                .addLast(adapterFactory)
                .build()
            val converterFactory = MoshiConverterFactory.create(moshi)

            val cache = Cache(context.cacheDir, 5 * 1024 * 1024L)
            val interceptor = CacheControlInterceptor(context)
            val client = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_POKEMON_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build()
                .create(PokeApi::class.java)
        }
    }
}