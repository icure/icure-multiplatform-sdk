package com.icure.cardinal.sdk.api.raw

import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.model.FrontEndMigration as ModelFrontEndMigration
import org.taktik.icure.entities.FrontEndMigration as EntitiesFrontEndMigration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawFrontEndMigrationApi {
	// region common endpoints

	suspend fun getFrontEndMigrations(): HttpResponse<List<ModelFrontEndMigration>>

	suspend fun createFrontEndMigration(frontEndMigrationDto: ModelFrontEndMigration): HttpResponse<ModelFrontEndMigration>

	suspend fun deleteFrontEndMigration(frontEndMigrationId: String): HttpResponse<EntitiesFrontEndMigration>

	suspend fun getFrontEndMigration(frontEndMigrationId: String): HttpResponse<ModelFrontEndMigration>

	suspend fun getFrontEndMigrationByName(frontEndMigrationName: String): HttpResponse<List<ModelFrontEndMigration>>

	suspend fun modifyFrontEndMigration(frontEndMigrationDto: ModelFrontEndMigration): HttpResponse<ModelFrontEndMigration>
	// endregion
}
