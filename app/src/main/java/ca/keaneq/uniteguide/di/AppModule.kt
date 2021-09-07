package ca.keaneq.uniteguide.di

import ca.keaneq.uniteguide.api.CacheControlInterceptor
import ca.keaneq.uniteguide.api.PokeApi
import ca.keaneq.uniteguide.repo.PokemonRepository
import ca.keaneq.uniteguide.repo.impl.PokemonRepositoryImpl
import ca.keaneq.uniteguide.ui.home.HomeViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val AppModule = module {
    single {
        val cacheSize: Long = 5 * 1024 * 1024

        Cache(
            androidContext().cacheDir,
            cacheSize
        )
    }

    single<JsonAdapter.Factory> {
        KotlinJsonAdapterFactory()
    }

    single<Moshi> {
        val factory: JsonAdapter.Factory = get()

        Moshi.Builder()
            .addLast(factory)
            .build()
    }

    single<Converter.Factory> {
        val moshi: Moshi = get()

        MoshiConverterFactory.create(
            moshi
        )
    }

    single {
        CacheControlInterceptor(
            context = androidContext()
        )
    }

    single<OkHttpClient> {
        val cache: Cache = get()
        val interceptor: CacheControlInterceptor = get()

        OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(interceptor)
            .build()
    }

    single<PokeApi> {
        val client: OkHttpClient = get()
        val factory: Converter.Factory = get()

        val retrofit = Retrofit.Builder()
            .baseUrl(PokeApi.BASE_URL)
            .addConverterFactory(factory)
            .client(client)
            .build()

        retrofit.create(PokeApi::class.java)
    }

    single<PokemonRepository> {
        val api: PokeApi = get()

        PokemonRepositoryImpl(
            pokeApi = api
        )
    }

    viewModel {
        val repository: PokemonRepository = get()

        HomeViewModel(
            repository = repository
        )
    }
}