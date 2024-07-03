package com.icure.sdk.auth.services

/**
 * An [AuthProvider] is responsible for instantiating an [AuthService] for each request of the raw api.
 * In the case of all the services that share the same state across requests (e.g. the [JwtAuthService]), then the concrete service
 * class should also implement this interface, returning itself on [AuthProvider.getAuthService].
 */
interface AuthProvider {

	fun getAuthService(): AuthService

}
