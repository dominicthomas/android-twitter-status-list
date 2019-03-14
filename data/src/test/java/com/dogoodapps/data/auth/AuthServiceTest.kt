package com.dogoodapps.data.auth

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthServiceTest {

    @Test
    fun isUserLoggedIn_whenAccessTokenEmpty_returnsFalse() {
        val authService = AuthServiceImpl()
        authService.setToken(null)
        assertEquals(false, authService.isUserLoggedIn())
    }

}