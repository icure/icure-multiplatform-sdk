package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

/**
 * Identifier for a document stored in iCure, includes revision.
 */
@Serializable
data class StoredDocumentIdentifier(
	val id: String,
	val rev: String
)

@InternalIcureApi
internal fun List<DocIdentifier>.toStoredDocumentIdentifier(): List<StoredDocumentIdentifier> =
	map { it.toStoredDocumentIdentifier() }
@InternalIcureApi
internal fun DocIdentifier.toStoredDocumentIdentifier(): StoredDocumentIdentifier =
	StoredDocumentIdentifier(
		ensureNonNull(id) { "Backend returned null for stored document identifier `id`"},
		ensureNonNull(rev) { "Backend returned null for stored document identifier `rev`"}
	)