package com.example.tapasoft.testusersapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tapasoft.testusersapp.api.Config
import com.example.tapasoft.testusersapp.api.ApiInterface
import com.example.tapasoft.testusersapp.repository.DataRepository
import com.example.tapasoft.testusersapp.repository.DataRepositoryImpl
import com.example.tapasoft.testusersapp.viewmodel.UserViewModel
import com.example.tapasoft.testusersapp.viewmodel.UserViewModelFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [AppModule.Bindings::class, AppModule.ViewModelModule::class])
class AppModule {
    @Module
    interface Bindings {
        @Binds
        @Singleton
        fun bindDataRepository(impl: DataRepositoryImpl): DataRepository
    }

    @Provides
    internal fun provideApiInterface(retrofit: Retrofit): ApiInterface = retrofit
        .create(ApiInterface::class.java)

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(httpClient)
            .baseUrl(Config.SERVER_API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    internal fun provideHttpClient(): OkHttpClient = OkHttpClient()

    @Module
    interface ViewModelModule {
        @Binds
        @Singleton
        fun bindViewModelFactory(factory: UserViewModelFactory?): ViewModelProvider.Factory?

        @Binds
        fun provideUserViewModel(userViewModel: UserViewModel?): ViewModel?
    }
}
