package com.icure.sdk.api

import com.icure.sdk.model.FrontEndMigration
import com.icure.sdk.model.couchdb.DocIdentifier

interface FrontEndMigrationApi {
	suspend fun getFrontEndMigration(frontEndMigrationId: String): FrontEndMigration
	suspend fun createFrontEndMigration(frontEndMigration: FrontEndMigration): FrontEndMigration
	suspend fun getFrontEndMigrations(): List<FrontEndMigration>
	suspend fun deleteFrontEndMigration(frontEndMigrationId: String): DocIdentifier
	suspend fun getFrontEndMigrationByName(frontEndMigrationName: String): List<FrontEndMigration>
	suspend fun modifyFrontEndMigration(frontEndMigration: FrontEndMigration): FrontEndMigration
}

