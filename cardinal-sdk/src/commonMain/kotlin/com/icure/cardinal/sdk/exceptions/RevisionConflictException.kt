@file:OptIn(ExperimentalJsExport::class)

package com.icure.cardinal.sdk.exceptions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Exception used when an update to an entity failed due to a conflict in the stored entity revision and updated entity
 * revision.
 * Can also happen if you attempt to create an entity with the same id as an existing entity (in that case, the existing
 * entity has a non-null revision and the new entity has a null revision)
 */
@JsExport
class RevisionConflictException : Throwable()