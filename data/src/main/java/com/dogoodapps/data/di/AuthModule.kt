package com.dogoodapps.data.di

import com.dogoodapps.data.auth.AuthServiceImpl
import com.dogoodapps.domain.auth.AuthService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AuthModule {

    @Singleton
    @Binds
    internal abstract fun bindsAuthService(authService: AuthServiceImpl): AuthService
}