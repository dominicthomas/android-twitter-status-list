package com.dogoodapps.data.di

import com.dogoodapps.data.auth.AuthServiceImpl
import com.dogoodapps.domain.auth.AuthService
import dagger.Binds
import dagger.Module

@Module
abstract class AuthModule {

    @Binds
    internal abstract fun bindsAuthService(authService: AuthServiceImpl): AuthService
}