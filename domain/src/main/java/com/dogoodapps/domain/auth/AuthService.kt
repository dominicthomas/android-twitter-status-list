package com.dogoodapps.domain.auth

interface AuthService {
    fun isUserLoggedIn(): Boolean

    fun getToken(): String?
}