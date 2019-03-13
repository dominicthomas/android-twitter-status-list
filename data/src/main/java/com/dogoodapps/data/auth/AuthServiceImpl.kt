package com.dogoodapps.data.auth

import com.dogoodapps.domain.auth.AuthService
import javax.inject.Inject

class AuthServiceImpl @Inject constructor() : AuthService {

    /**
     * This has been set manually for the sake of the demo but would probably be retrieved from an authentication
     * service and stored securely in memory.. this would never be stored in plain text
     */
    private var accessToken: String? =
        "Bearer AAAAAAAAAAAAAAAAAAAAAF7w0wAAAAAAb6kdTQSU%2F5EmGAMD917iN" +
                "7rZuVE%3D9ssQYqmHSgDTUgLDOW3k155qYVOxrGUaDSeOrW3IqvHeSoRYiu"

    override fun isUserLoggedIn(): Boolean {
        return !accessToken.isNullOrEmpty()
    }

    override fun getToken(): String? {
        return accessToken
    }
}