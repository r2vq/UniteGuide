package ca.keaneq.uniteguide.di

import ca.keaneq.uniteguide.api.PokeApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
}