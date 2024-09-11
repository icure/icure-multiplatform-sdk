package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.api.raw.RawFrontEndMigrationApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.FrontEndMigration
import com.icure.utils.InternalIcureApi

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

	override suspend fun modifyFrontEndMigration(frontEndMigration: FrontEndMigration) = rawApi.modifyFrontEndMigration(frontEndMigration).successBodyOrThrowRevisionConflict()
}