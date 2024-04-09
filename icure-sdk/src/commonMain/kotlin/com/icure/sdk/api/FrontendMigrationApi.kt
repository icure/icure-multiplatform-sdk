package com.icure.sdk.api

import com.icure.sdk.api.raw.RawFrontEndMigrationApi
import com.icure.sdk.model.FrontEndMigration
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi

interface FrontEndMigrationApi {
	suspend fun getFrontEndMigration(frontEndMigrationId: String): FrontEndMigration
	suspend fun createFrontEndMigration(frontEndMigration: FrontEndMigration): FrontEndMigration
	suspend fun getFrontEndMigrations(): List<FrontEndMigration>
	suspend fun deleteFrontEndMigration(frontEndMigrationId: String): DocIdentifier
	suspend fun getFrontEndMigrationByName(frontEndMigrationName: String): List<FrontEndMigration>
	suspend fun modifyFrontEndMigration(frontEndMigration: FrontEndMigration): FrontEndMigration
}

@InternalIcureApi
internal  class FrontEndMigrationApiImpl(
	private val rawApi: RawFrontEndMigrationApi,
) : FrontEndMigrationApi {
	override suspend fun getFrontEndMigration(frontEndMigrationId: String) = rawApi.getFrontEndMigration(frontEndMigrationId).successBody()

	override suspend fun createFrontEndMigration(frontEndMigration: FrontEndMigration) =
		rawApi.createFrontEndMigration(frontEndMigration).successBody()

	override suspend fun getFrontEndMigrations() = rawApi.getFrontEndMigrations().successBody()

	override suspend fun deleteFrontEndMigration(frontEndMigrationId: String) = rawApi.deleteFrontEndMigration(frontEndMigrationId).successBody()

	override suspend fun getFrontEndMigrationByName(frontEndMigrationName: String) = rawApi.getFrontEndMigrationByName(frontEndMigrationName).successBody()

	override suspend fun modifyFrontEndMigration(frontEndMigration: FrontEndMigration) = rawApi.modifyFrontEndMigration(frontEndMigration).successBody()
}

