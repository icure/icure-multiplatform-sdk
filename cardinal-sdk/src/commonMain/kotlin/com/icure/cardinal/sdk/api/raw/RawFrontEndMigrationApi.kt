package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.FrontEndMigration
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawFrontEndMigrationApi {
	// region common endpoints

	suspend fun getFrontEndMigrations(): HttpResponse<List<FrontEndMigration>>

	suspend fun createFrontEndMigration(frontEndMigrationDto: FrontEndMigration): HttpResponse<FrontEndMigration>

	suspend fun deleteFrontEndMigration(frontEndMigrationId: String): HttpResponse<DocIdentifier>

	suspend fun getFrontEndMigration(frontEndMigrationId: String): HttpResponse<FrontEndMigration>

	suspend fun getFrontEndMigrationByName(frontEndMigrationName: String): HttpResponse<List<FrontEndMigration>>

	suspend fun modifyFrontEndMigration(frontEndMigrationDto: FrontEndMigration): HttpResponse<FrontEndMigration>
	// endregion
}
