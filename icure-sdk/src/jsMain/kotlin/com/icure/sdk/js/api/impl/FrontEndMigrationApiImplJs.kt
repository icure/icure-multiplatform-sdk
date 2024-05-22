// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.FrontEndMigrationApi
import com.icure.sdk.js.api.FrontEndMigrationApiJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.FrontEndMigrationJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.frontEndMigration_toJs
import com.icure.sdk.model.FrontEndMigration
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class FrontEndMigrationApiImplJs private constructor(
	private val frontEndMigrationApi: FrontEndMigrationApi,
) : FrontEndMigrationApiJs {
	override fun getFrontEndMigration(frontEndMigrationId: String): Promise<FrontEndMigrationJs> =
			GlobalScope.promise {
		frontEndMigration_toJs(frontEndMigrationApi.getFrontEndMigration(frontEndMigrationId))}


	override fun createFrontEndMigration(frontEndMigration: FrontEndMigrationJs):
			Promise<FrontEndMigrationJs> = GlobalScope.promise {
		frontEndMigration_toJs(frontEndMigrationApi.createFrontEndMigration(com.icure.sdk.js.model.frontEndMigration_fromJs(frontEndMigration)))}


	override fun getFrontEndMigrations(): Promise<Array<FrontEndMigrationJs>> = GlobalScope.promise {
		listToArray(
			frontEndMigrationApi.getFrontEndMigrations(),
			{ x1: FrontEndMigration ->
				frontEndMigration_toJs(x1)
			},
		)}


	override fun deleteFrontEndMigration(frontEndMigrationId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(frontEndMigrationApi.deleteFrontEndMigration(frontEndMigrationId))}


	override fun getFrontEndMigrationByName(frontEndMigrationName: String):
			Promise<Array<FrontEndMigrationJs>> = GlobalScope.promise {
		listToArray(
			frontEndMigrationApi.getFrontEndMigrationByName(frontEndMigrationName),
			{ x1: FrontEndMigration ->
				frontEndMigration_toJs(x1)
			},
		)}


	override fun modifyFrontEndMigration(frontEndMigration: FrontEndMigrationJs):
			Promise<FrontEndMigrationJs> = GlobalScope.promise {
		frontEndMigration_toJs(frontEndMigrationApi.modifyFrontEndMigration(com.icure.sdk.js.model.frontEndMigration_fromJs(frontEndMigration)))}

}
