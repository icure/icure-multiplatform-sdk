// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object EntityTemplateApi {
  public fun getEntityTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateIdString: String,
  ) {
    val documentTemplateId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      documentTemplateIdString
    )
    ApiScope.execute(
      dartResultCallback,
      EntityTemplate.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.getEntityTemplate(
        documentTemplateId,
      )
    }
  }

  public fun createEntityTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    applicationSettingsString: String,
  ) {
    val applicationSettings = fullLanguageInteropJson.decodeFromString(
      EntityTemplate.serializer(),
      applicationSettingsString
    )
    ApiScope.execute(
      dartResultCallback,
      EntityTemplate.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.createEntityTemplate(
        applicationSettings,
      )
    }
  }

  public fun modifyEntityTemplate(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    documentTemplateString: String,
  ) {
    val documentTemplate = fullLanguageInteropJson.decodeFromString(
      EntityTemplate.serializer(),
      documentTemplateString
    )
    ApiScope.execute(
      dartResultCallback,
      EntityTemplate.serializer()) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.modifyEntityTemplate(
        documentTemplate,
      )
    }
  }

  public fun listEntityTemplatesBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    typeString: String,
    searchStringString: String,
    includeEntitiesString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      searchStringString
    )
    val includeEntities = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      includeEntitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.listEntityTemplatesBy(
        userId,
        type,
        searchString,
        includeEntities,
      )
    }
  }

  public fun listAllEntityTemplatesBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    typeString: String,
    searchStringString: String,
    includeEntitiesString: String,
  ) {
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      searchStringString
    )
    val includeEntities = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      includeEntitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.listAllEntityTemplatesBy(
        type,
        searchString,
        includeEntities,
      )
    }
  }

  public fun listEntityTemplatesByKeyword(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    typeString: String,
    keywordString: String,
    includeEntitiesString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val keyword = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keywordString
    )
    val includeEntities = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      includeEntitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.listEntityTemplatesByKeyword(
        userId,
        type,
        keyword,
        includeEntities,
      )
    }
  }

  public fun findAllEntityTemplatesByKeyword(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    typeString: String,
    keywordString: String,
    includeEntitiesString: String,
  ) {
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val keyword = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keywordString
    )
    val includeEntities = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer().nullable,
      includeEntitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.findAllEntityTemplatesByKeyword(
        type,
        keyword,
        includeEntities,
      )
    }
  }

  public fun getEntityTemplates(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityTemplateIdsString: String,
  ) {
    val entityTemplateIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      entityTemplateIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.getEntityTemplates(
        entityTemplateIds,
      )
    }
  }

  public fun modifyEntityTemplates(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityTemplatesString: String,
  ) {
    val entityTemplates = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EntityTemplate.serializer()),
      entityTemplatesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.modifyEntityTemplates(
        entityTemplates,
      )
    }
  }

  public fun createEntityTemplates(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityTemplatesString: String,
  ) {
    val entityTemplates = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EntityTemplate.serializer()),
      entityTemplatesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EntityTemplate.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.createEntityTemplates(
        entityTemplates,
      )
    }
  }

  public fun deleteEntityTemplates(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityTemplateIdsString: String,
  ) {
    val entityTemplateIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(IdWithMandatoryRev.serializer()),
      entityTemplateIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalSdk>(sdkId).entityTemplate.deleteEntityTemplates(
        entityTemplateIds,
      )
    }
  }
}
