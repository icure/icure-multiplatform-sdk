// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object AgendaFilters {
  public fun all(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.all(
      )
    }
  }

  public fun byUser(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, userIdString: String) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.byUser(
        userId,
      )
    }
  }

  public fun byUserInGroup(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, userReferenceString: String) {
    val userReference = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      userReferenceString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.byUserInGroup(
        userReference,
      )
    }
  }

  public fun readableByUser(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, userIdString: String) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.readableByUser(
        userId,
      )
    }
  }

  public fun readableByUserInGroup(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, userReferenceString: String) {
    val userReference = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      userReferenceString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.readableByUserInGroup(
        userReference,
      )
    }
  }

  public fun readableByUserRights(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, userIdString: String) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.readableByUserRights(
        userId,
      )
    }
  }

  public fun readableByUserRightsInGroup(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, userReferenceString: String) {
    val userReference = fullLanguageInteropJson.decodeFromString(
      EntityReferenceInGroup.serializer(),
      userReferenceString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.readableByUserRightsInGroup(
        userReference,
      )
    }
  }

  public fun byStringProperty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    propertyIdString: String,
    propertyValueString: String,
  ) {
    val propertyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      propertyIdString
    )
    val propertyValue = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      propertyValueString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.byStringProperty(
        propertyId,
        propertyValue,
      )
    }
  }

  public fun byBooleanProperty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    propertyIdString: String,
    propertyValueString: String,
  ) {
    val propertyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      propertyIdString
    )
    val propertyValue = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      propertyValueString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.byBooleanProperty(
        propertyId,
        propertyValue,
      )
    }
  }

  public fun byLongProperty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    propertyIdString: String,
    propertyValueString: String,
  ) {
    val propertyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      propertyIdString
    )
    val propertyValue = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      propertyValueString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.byLongProperty(
        propertyId,
        propertyValue,
      )
    }
  }

  public fun byDoubleProperty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    propertyIdString: String,
    propertyValueString: String,
  ) {
    val propertyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      propertyIdString
    )
    val propertyValue = fullLanguageInteropJson.decodeFromString(
      Double.serializer(),
      propertyValueString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.byDoubleProperty(
        propertyId,
        propertyValue,
      )
    }
  }

  public fun withProperty(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, propertyIdString: String) {
    val propertyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      propertyIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(Agenda.serializer())
    ) {
      com.icure.cardinal.sdk.filters.AgendaFilters.withProperty(
        propertyId,
      )
    }
  }
}
