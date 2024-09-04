package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ClassificationTemplate
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawClassificationTemplateApi {
	// region common endpoints

	suspend fun createClassificationTemplate(c: ClassificationTemplate): HttpResponse<ClassificationTemplate>

	suspend fun getClassificationTemplate(classificationTemplateId: String): HttpResponse<ClassificationTemplate>

	suspend fun getClassificationTemplateByIds(ids: String): HttpResponse<List<ClassificationTemplate>>

	suspend fun deleteClassificationTemplates(classificationTemplateIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteClassificationTemplate(classificationTemplateId: String): HttpResponse<DocIdentifier>

	suspend fun modifyClassificationTemplate(classificationTemplateDto: ClassificationTemplate): HttpResponse<ClassificationTemplate>

	suspend fun findClassificationTemplatesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<ClassificationTemplate>>
	// endregion
}
