package com.dogoodapps.chirp.data.di

import com.dogoodapps.chirp.data.auth.AuthServiceImpl
import com.dogoodapps.chirp.domain.auth.AuthService
import dagger.Binds
import dagger.Module

@Module
abstract class AuthModule {

    @Binds
    internal abstract fun bindsAuthService(authService: AuthServiceImpl): AuthService
}