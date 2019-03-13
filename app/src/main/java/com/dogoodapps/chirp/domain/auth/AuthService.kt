package com.dogoodapps.chirp.domain.auth

interface AuthService {
    fun isUserLoggedIn(): Boolean

    fun getToken(): String?
}