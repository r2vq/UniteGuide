package ca.keaneq.uniteguide.di

import ca.keaneq.uniteguide.api.PokeApi
import ca.keaneq.uniteguide.ui.home.HomeViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val AppModule = module {
    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<Converter.Factory> {
        MoshiConverterFactory.create(get())
    }

    single<PokeApi> {
        val retrofit = Retrofit.Builder()
            .baseUrl(PokeApi.BASE_URL)
            .addConverterFactory(get())
            .build()

        retrofit.create(PokeApi::class.java)
    }

    viewModel {
        val api: PokeApi = get()

        HomeViewModel(
            api = api
        )
    }
}