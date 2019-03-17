package com.dogoodapps.data.auth

import org.junit.Assert.assertEquals
import org.junit.Test

class AuthServiceTest {

    private val fakeToken = "FAKE_TOKEN"

    @Test
    fun isUserLoggedIn_whenAccessTokenEmpty_returnsFalse() {
        val authService = AuthServiceImpl()
        authService.setToken(null)
        assertEquals(false, authService.isUserLoggedIn())
    }

    @Test
    fun getToken_afterTokenSet_returnsCorrectToken() {
        val authService = AuthServiceImpl()
        authService.setToken(fakeToken)
        assertEquals(fakeToken, authService.getToken())
    }
}