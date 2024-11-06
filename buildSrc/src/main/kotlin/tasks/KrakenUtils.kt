package tasks

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend fun createNewDatabase(
	httpClient: HttpClient,
	databaseName: String,
	couchDBUrl: String = "http://127.0.0.1:15984",
	couchDbUser: String = "icure",
	couchDbPassword: String = "icure"
) {
	val response = httpClient.put("$couchDBUrl/$databaseName") {
		basicAuth(couchDbUser, couchDbPassword)
		contentType(ContentType.Application.Json)
		setBody("{}")
	}

	if (!response.status.isSuccess()) {
		println("Could not create database $databaseName: ${response.status} - ${response.bodyAsText()}")
	}
}


suspend fun createUserIn(
	httpClient: HttpClient,
	groupId: String,
	groupUserId: String,
	groupUserLogin: String,
	groupUserPasswordHash: String,
	groupUserHcpId: String? = null,
	couchDBUrl: String = "http://127.0.0.1:15984",
	couchDbUser: String = "icure",
	couchDbPassword: String = "icure"
) {
	val response = httpClient.post("$couchDBUrl/icure-$groupId-base") {
		basicAuth(couchDbUser, couchDbPassword)
		contentType(ContentType.Application.Json)
		setBody(
			"""{
        "_id" : "$groupUserId",
        "login" : "$groupUserLogin",
        "passwordHash" : "$groupUserPasswordHash",
        "healthcarePartyId": "$groupUserHcpId",
        "isUse2fa" : true,
        "type" : "database",
        "status" : "ACTIVE",
                """.trimMargin() +
				(
					if (groupUserHcpId != null) {
						""" "healthcarePartyId": "$groupUserHcpId", """.trimMargin()
					} else ""
					) +
				""" "java_type" : "org.taktik.icure.entities.User"
        }
                    """.trimMargin()
		)
	}

	if (!response.status.isSuccess() && response.status != HttpStatusCode.Conflict) {
		throw RuntimeException("Could not create a new DB User in icure-$groupId-base")
	}
}

suspend fun createUserInBase(
	httpClient: HttpClient,
	groupId: String? = null,
	groupUserId: String,
	groupUserLogin: String,
	groupUserPasswordHash: String,
	groupUserHcpId: String? = null,
	couchDBUrl: String = "http://127.0.0.1:15984",
	couchDbUser: String = "icure",
	couchDbPassword: String = "icure"
) {
	val userId = if (groupId == null) groupUserId else "$groupId:$groupUserId"

	val response = httpClient.post("$couchDBUrl/icure-${if (groupId == null) "" else "__-"}base") {
		basicAuth(couchDbUser, couchDbPassword)
		contentType(ContentType.Application.Json)
		setBody(
			"""{
  "_id" : "$userId",
  "login" : "$groupUserLogin",
  "passwordHash" : "$groupUserPasswordHash",
  "type" : "database",
  "status" : "ACTIVE",
""" +
				(
					if (groupId != null) {
						""""groupId" : "$groupId",
  "permissions": [
            {
              "grants": [
                {
                  "java_type": "org.taktik.icure.entities.security.AlwaysPermissionItem",
                  "type": "ADMIN"
                }
              ]
            }
          ],
"""
					} else ""
					) +
				(
					if (groupUserHcpId != null) {
						""" "healthcarePartyId": "$groupUserHcpId", """
					} else ""
					) +
				"  \"java_type\" : \"org.taktik.icure.entities.User\"" +
				"}"
		)
	}

	if (!response.status.isSuccess() && response.status != HttpStatusCode.Conflict) {
		throw RuntimeException("Could not create DB User $groupId:$groupUserId in icure-__-base")
	}
}

suspend fun createNewDbUser(
	httpClient: HttpClient,
	groupId: String,
	groupPassword: String,
	couchDBUrl: String = "http://127.0.0.1:15984",
	couchDbUser: String = "icure",
	couchDbPassword: String = "icure"
) {
	val response = httpClient.post("$couchDBUrl/_users") {
		basicAuth(couchDbUser, couchDbPassword)
		contentType(ContentType.Application.Json)
		setBody(
			"""{
  "_id" : "org.couchdb.user:$groupId",
  "name" : "$groupId",
  "password" : "$groupPassword",
  "roles" : [],
  "type" : "user"
}"""
		)
	}

	if (!response.status.isSuccess() && response.status != HttpStatusCode.Conflict) {
		throw RuntimeException("Could not create a new DB User in _users")
	}
}

suspend fun createNewGroupInConfig(
	httpClient: HttpClient,
	groupId: String,
	groupPassword: String,
	couchDBUrl: String = "http://127.0.0.1:15984",
	couchDbUser: String = "icure",
	couchDbPassword: String = "icure",
	superGroup: String? = null,
	defaultRoles: Map<String, List<String>> = emptyMap(),
	quotas: List<Int> = listOf(1000, 2, 5)
) {
	val response = httpClient.post("$couchDBUrl/icure-__-config") {
		basicAuth(couchDbUser, couchDbPassword)
		contentType(ContentType.Application.Json)
		setBody(
			"""{
          "_id": "$groupId",
          "java_type": "org.taktik.icure.entities.Group",
          "name": "$groupId",
          "password": "$groupPassword",
          ${superGroup?.let { "\"superGroup\": \"$it\"," } ?: ""}
          "defaultUserRoles": {
            ${defaultRoles.entries.joinToString(",") { (k, v) ->
				"\"$k\": [${v.joinToString(", ") { "\"$it\""}}]"
			}}
          },
          "properties": [
            ${quotas.mapIndexed { index, quota ->
				"""
                    {
                      "type": {
                        "identifier": "com.icure.dbs.quota.$index",
                        "type": "INTEGER"
                      },
                      "typedValue": {
                        "type": "INTEGER",
                        "integerValue": $quota
                      }
                    }
                    """.trimIndent()
			}.joinToString(",")
			}
          ],
          "tags": [
            {
              "id": "IC-GROUP|root|1.0",
              "type": "IC-GROUP",
              "code": "root",
              "version": "1.0"
            }
          ],
          "rev_history": {},
          "servers": []
        }"""
		)
	}

	if (!response.status.isSuccess() && response.status != HttpStatusCode.Conflict) {
		throw RuntimeException("Could not create a new groupDB  in _config")
	}
}