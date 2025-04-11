package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmName

/**
 * Identifier for a document stored in iCure, includes revision.
 */
@Serializable
data class StoredDocumentIdentifier(
	override val id: String,
	val rev: String
) : Identifiable<String>

@JvmName("idWithRevToStoredDocumentIdentifier")
internal fun List<IdWithRev>.toStoredDocumentIdentifier(): List<StoredDocumentIdentifier> =
	map { it.toStoredDocumentIdentifier() }

@JvmName("docIdentifiersToStoredDocumentIdentifier")
internal fun List<DocIdentifier>.toStoredDocumentIdentifier(): List<StoredDocumentIdentifier> =
	map { it.toStoredDocumentIdentifier() }

@OptIn(InternalIcureApi::class)
internal fun DocIdentifier.toStoredDocumentIdentifier(): StoredDocumentIdentifier =
	StoredDocumentIdentifier(
		ensureNonNull(id) { "Backend returned null for stored document identifier `id`"},
		ensureNonNull(rev) { "Backend returned null for stored document identifier `rev`"}
	)

@OptIn(InternalIcureApi::class)
internal fun IdWithRev.toStoredDocumentIdentifier(): StoredDocumentIdentifier =
	StoredDocumentIdentifier(
		ensureNonNull(id) { "Backend returned null for stored document identifier `id`"},
		ensureNonNull(rev) { "Backend returned null for stored document identifier `rev`"}
	)

@OptIn(InternalIcureApi::class)
internal fun StoredDocument.toStoredDocumentIdentifier(): StoredDocumentIdentifier =
	StoredDocumentIdentifier(
		id,
		ensureNonNull(rev) { "${this::class.simpleName}(\"${this.id}\") has no rev. Was not yet stored?" }
	)


@JvmName("storedDocumentsToStoredDocumentIdentifier")
internal fun List<StoredDocument>.toStoredDocumentIdentifier(): List<StoredDocumentIdentifier> =
	map { it.toStoredDocumentIdentifier() }

internal fun GroupScoped<StoredDocument>.toStoredDocumentIdentifier(): GroupScoped<StoredDocumentIdentifier> =
	GroupScoped(entity.toStoredDocumentIdentifier(), groupId)

@JvmName("groupScopedStoredDocumentsToStoredDocumentIdentifier")
internal fun List<GroupScoped<StoredDocument>>.toStoredDocumentIdentifier(): List<GroupScoped<StoredDocumentIdentifier>> =
	map { it.toStoredDocumentIdentifier() }
