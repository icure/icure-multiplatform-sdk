package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DocumentGroup
import com.icure.sdk.model.embed.form.template.FormTemplateLayout
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class FormTemplate(
    override val id: String,
    override val rev: String? = null,
    override val deletionDate: Long? = null,
    public val templateLayout: FormTemplateLayout? = null,
    public val rawTemplateLayout: ByteArray? = null,
    public val name: String? = null,
    public val guid: String? = null,
    public val group: DocumentGroup? = null,
    public val descr: String? = null,
    public val disabled: String? = null,
    public val specialty: CodeStub? = null,
    public val author: String? = null,
    public val formInstancePreferredLocation: String? = null,
    public val keyboardShortcut: String? = null,
    public val shortReport: String? = null,
    public val mediumReport: String? = null,
    public val longReport: String? = null,
    public val reports: Set<String> = emptySet(),
    public val tags: Set<CodeStub> = emptySet(),
    public val layoutAttachmentId: String? = null,
    public val templateLayoutAttachmentId: String? = null,
) : StoredDocument {
    // region FormTemplate-FormTemplate

    // endregion
}
