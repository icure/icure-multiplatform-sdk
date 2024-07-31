package com.icure.sdk.options

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.model.UserGroup
import com.icure.sdk.storage.KeyStorageFacade
import com.icure.sdk.storage.StorageFacade
import io.ktor.client.HttpClient
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

interface CommonOptions {
	/**
	 * Configure which fields of entities should be encrypted
	 */
	val encryptedFields: EncryptedFieldsConfiguration
	/**
	 * Specify which client to use for performing http requests (rest).
	 * You will be responsible for closing the client after you are done using the sdk.
	 *
	 * This client must support json serialization.
	 *
	 * If null an http client instance shared across all sdks will be used.
	 */
	val httpClient: HttpClient?
	/**
	 * Specify which client to use for performing websocket requests.
	 * You will be responsible for closing the client after you are done using the sdk.
	 *
	 * If [httpClient] is not null and this is null the sdk will use the [httpClient] also to perform the websocket
	 * requests. This means that if [httpClient] is not null and does not support websockets you must also provide
	 * a value for this, else you will not be able to use features that rely on websockets, such as realtime
	 * notifications.
	 *
	 * If both this and [httpClient] are null a shared instance of the client will be used.
	 */
	val websocketClient: HttpClient?
	/**
	 * The instance of [Json] used by the provided [httpClient] (leave null if [httpClient] is null).
	 */
	val httpClientJson: Json?
	/**
	 * Service for encryption primitives
	 */
	val cryptoService: CryptoService
	/**
	 * An instance of iCure SDK is initialized for working as a specific user in a single group.
	 * However, the user credentials may match multiple users in different groups (but at most one per group).
	 * If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
	 *
	 * This function takes in input the information on the users and corresponding group that are matching the
	 * credentials, and returns a single group id.
	 *
	 * This is mandatory in multi-group applications, where a single user could exist in multiple groups.
	 * If this parameter is null and the user credentials match multiple users the api initialisation will fail.
	 * In single-group applications this parameter won't be used, so it can be left as null.
	 */
	val groupSelector: ((availableGroups: List<UserGroup>) -> String)?
	/**
	 * If true (default) the password of the user will be salted together with the application id before sending it to
	 * the iCure backend for login or when changing the user password.
	 * This is done in addition to the server-side salting of the password before storing them.
	 *
	 * By enabling this option iCure never gets access to the plain text password of users.
	 * Note that changing this value in a second moment requires also modifying the password of the user on the iCure
	 * databases to reflect the change.
	 */
	val saltPasswordWithApplicationId: Boolean
}

data class ApiOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	/**
	 * Has only effect when logging in as an hcp user.
	 *
	 * If false the api will be initialized in a hierarchical mode, where each data owner is considered to have access
	 * to all data of his parents (requires corresponding permission on the server side).
	 * In this case the sdk will also expect to have access to at least a key for each parent data owner of the current
	 * user.
	 *
	 * If true the api will ignore the data owner hierarchies.
	 * Each data owner is considered to have access only to data shared explicitly with him, and has access only to his
	 * own keys.
	 */
	val disableParentKeysInitialisation: Boolean = false,
	override val httpClient: HttpClient? = null,
	override val websocketClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	/**
	 * If true (default) the sdk will automatically create the transfer keys for the current user if a new keypair is
	 * created.
	 */
	val createTransferKeys: Boolean = true,
	override val cryptoService: CryptoService = defaultCryptoService,
	override val groupSelector: ((availableGroups: List<UserGroup>) -> String)? = null,
	/**
	 * Options to support the migration of data created using iCure versions from before 2018.
	 * Leave it as false (default) unless explicitly instructed to set it to true by the iCure team.
	 */
	val autoCreateEncryptionKeyForExistingLegacyData: Boolean = false,
	/**
	 * Implementation of key storage to use.
	 * If not provided the sdk will store the keys in the [StorageFacade] provided to the api initialization method.
	 */
	val keyStorage: KeyStorageFacade? = null,
	override val saltPasswordWithApplicationId: Boolean = true,
): CommonOptions {
}

data class BasicApiOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	override val httpClient: HttpClient? = null,
	override val websocketClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val cryptoService: CryptoService = defaultCryptoService,
	override val groupSelector: ((availableGroups: List<UserGroup>) -> String)? = null,
	override val saltPasswordWithApplicationId: Boolean = true,
): CommonOptions

@Serializable
data class EncryptedFieldsConfiguration(
	val accessLog: Set<String> = setOf("detail", "objectId"),
	val calendarItem: Set<String> = setOf("details", "title", "patientId"),
	val contact: Set<String> = setOf("descr", "notes[].markdown"),
	val service: Set<String> = setOf("notes[].markdown"),
	val healthElement: Set<String> = setOf("descr", "note", "notes[].markdown"),
	val maintenanceTask: Set<String> = setOf("properties"),
	val patient: Set<String> = setOf("note", "notes[].markdown"),
	val message: Set<String> = emptySet(),
	val topic: Set<String> = setOf("description", "linkedServices", "linkedHealthElements"),
	val document: Set<String> = emptySet(),
	val form: Set<String> = emptySet(),
	val receipt: Set<String> = emptySet(),
	val classification: Set<String> = emptySet(),
	val timeTable: Set<String> = emptySet(),
	val invoice: Set<String> = emptySet(),
)
