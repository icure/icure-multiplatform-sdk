package com.icure.sdk.model.couchdb

import com.icure.sdk.model.base.Versionable
import com.icure.sdk.serialization.ZonedDateTimeSerializer
import com.icure.sdk.utils.time.ZonedDateTime
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReplicatorDocument(
    override val id: String,
    override val rev: String? = null,
    public val source: Remote? = null,
    public val target: Remote? = null,
    public val owner: String? = null,
    public val create_target: Boolean? = null,
    public val continuous: Boolean? = null,
    public val doc_ids: List<String>? = null,
    public val replicationState: String? = null,
    @Serializable(with = ZonedDateTimeSerializer::class)
    public val replicationStateTime: ZonedDateTime? = null,
    public val replicationStats: ReplicationStats? = null,
    public val errorCount: Int? = null,
    public val revsInfo: List<Map<String, String>>? = null,
    public val revHistory: Map<String, String>? = null,
) : Versionable<String> {
    // region ReplicatorDocument-ReplicatorDocument

    // endregion
}
