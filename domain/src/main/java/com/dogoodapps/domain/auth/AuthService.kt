package com.dogoodapps.domain.auth

interface AuthService {
    fun isUserLoggedIn(): Boolean

    fun setToken(token: String?)

    fun getToken(): String?
}