package com.icure.sdk.api.impl

import com.icure.sdk.api.FrontEndMigrationApi
import com.icure.sdk.api.raw.RawFrontEndMigrationApi
import com.icure.sdk.model.FrontEndMigration
import com.icure.sdk.utils.InternalIcureApi

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