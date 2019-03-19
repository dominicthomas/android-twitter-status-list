package com.dogoodapps.data.auth

import com.dogoodapps.data.BuildConfig
import com.dogoodapps.domain.auth.AuthService
import javax.inject.Inject

class AuthServiceImpl @Inject constructor() : AuthService {

    /**
     * This has been set manually from build config for the sake of the demo..
     */
    private var accessToken: String? = BuildConfig.AUTH_TOKEN

    override fun isUserLoggedIn(): Boolean {
        return !accessToken.isNullOrEmpty()
    }

    override fun setToken(token: String?) {
        accessToken = token
    }

    override fun getToken(): String? {
        return accessToken
    }
}