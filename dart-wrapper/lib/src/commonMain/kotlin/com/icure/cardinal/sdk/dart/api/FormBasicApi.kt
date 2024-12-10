// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object FormBasicApi {
  public fun matchFormsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.matchFormsBy(
        filter,
      )
    }
  }

  public fun matchFormsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.matchFormsBySorted(
        filter,
      )
    }
  }

  public fun filterFormsBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).form.filterFormsBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedForm.serializer()
      ))
    }
  }

  public fun filterFormsBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Form::class)),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalBaseApis>(sdkId).form.filterFormsBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        EncryptedForm.serializer()
      ))
    }
  }

  public fun deleteFormById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.deleteFormById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteFormsByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.deleteFormsByIds(
        entityIds,
      )
    }
  }

  public fun purgeFormById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.purgeFormById(
        id,
        rev,
      )
    }
  }

  public fun deleteForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.deleteForm(
        form,
      )
    }
  }

  public fun deleteForms(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formsString: String,
  ) {
    val forms = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Form::class)),
      formsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.deleteForms(
        forms,
      )
    }
  }

  public fun purgeForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.purgeForm(
        form,
      )
    }
  }

  public fun getFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateIdString: String,
    rawString: String,
  ) {
    val formTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      formTemplateIdString
    )
    val raw = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      rawString
    )
    ApiScope.execute(
      dartResultCallback,
      FormTemplate.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.getFormTemplate(
        formTemplateId,
        raw,
      )
    }
  }

  public fun createFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateString: String,
  ) {
    val formTemplate = fullLanguageInteropJson.decodeFromString(
      FormTemplate.serializer(),
      formTemplateString
    )
    ApiScope.execute(
      dartResultCallback,
      FormTemplate.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.createFormTemplate(
        formTemplate,
      )
    }
  }

  public fun deleteFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateIdString: String,
  ) {
    val formTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      formTemplateIdString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.deleteFormTemplate(
        formTemplateId,
      )
    }
  }

  public fun updateFormTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateString: String,
  ) {
    val formTemplate = fullLanguageInteropJson.decodeFromString(
      FormTemplate.serializer(),
      formTemplateString
    )
    ApiScope.execute(
      dartResultCallback,
      FormTemplate.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.updateFormTemplate(
        formTemplate,
      )
    }
  }

  public fun setTemplateAttachment(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formTemplateIdString: String,
    payloadString: String,
  ) {
    val formTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      formTemplateIdString
    )
    val payload = fullLanguageInteropJson.decodeFromString(
      ByteArraySerializer,
      payloadString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.setTemplateAttachment(
        formTemplateId,
        payload,
      )
    }
  }

  public fun modifyForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityString: String,
  ) {
    val entity = fullLanguageInteropJson.decodeFromString(
      EncryptedForm.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedForm.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.modifyForm(
        entity,
      )
    }
  }

  public fun undeleteFormById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedForm.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.undeleteFormById(
        id,
        rev,
      )
    }
  }

  public fun undeleteForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    formString: String,
  ) {
    val form = fullLanguageInteropJson.decodeFromString(
      PolymorphicSerializer(Form::class),
      formString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedForm.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.undeleteForm(
        form,
      )
    }
  }

  public fun modifyForms(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entitiesString: String,
  ) {
    val entities = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedForm.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedForm.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.modifyForms(
        entities,
      )
    }
  }

  public fun getForm(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedForm.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.getForm(
        entityId,
      )
    }
  }

  public fun getForms(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdsString: String,
  ) {
    val entityIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedForm.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.getForms(
        entityIds,
      )
    }
  }

  public fun getLatestFormByLogicalUuid(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    logicalUuidString: String,
  ) {
    val logicalUuid = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      logicalUuidString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedForm.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.getLatestFormByLogicalUuid(
        logicalUuid,
      )
    }
  }

  public fun getLatestFormByUniqueId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    uniqueIdString: String,
  ) {
    val uniqueId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      uniqueIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedForm.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).form.getLatestFormByUniqueId(
        uniqueId,
      )
    }
  }
}
