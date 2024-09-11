@file:OptIn(ExperimentalJsExport::class)

package com.icure.cardinal.sdk.exceptions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Exception used when an update to an entity failed due to a conflict in the stored entity revision and updated entity
 * revision.
 */
@JsExport
class RevisionConflictException : Throwable()