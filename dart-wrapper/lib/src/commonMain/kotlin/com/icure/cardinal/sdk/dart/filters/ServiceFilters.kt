// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object ServiceFilters {
  public fun allServicesForDataOwner(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, dataOwnerIdString: String) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.allServicesForDataOwner(
        dataOwnerId,
      )
    }
  }

  public fun allServicesForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.allServicesForSelf(
      )
    }
  }

  public fun byIdentifiersForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    identifiersString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val identifiers = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Identifier.serializer()),
      identifiersString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byIdentifiersForDataOwner(
        dataOwnerId,
        identifiers,
      )
    }
  }

  public fun byCodeAndValueDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    codeTypeString: String,
    codeCodeString: String,
    startOfServiceValueDateString: String,
    endOfServiceValueDateString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    val codeCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      codeCodeString
    )
    val startOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfServiceValueDateString
    )
    val endOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfServiceValueDateString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byCodeAndValueDateForDataOwner(
        dataOwnerId,
        codeType,
        codeCode,
        startOfServiceValueDate,
        endOfServiceValueDate,
      )
    }
  }

  public fun byTagAndValueDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    tagTypeString: String,
    tagCodeString: String,
    startOfServiceValueDateString: String,
    endOfServiceValueDateString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val tagType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tagTypeString
    )
    val tagCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tagCodeString
    )
    val startOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfServiceValueDateString
    )
    val endOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfServiceValueDateString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byTagAndValueDateForDataOwner(
        dataOwnerId,
        tagType,
        tagCode,
        startOfServiceValueDate,
        endOfServiceValueDate,
      )
    }
  }

  public fun byPatientsForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    patientsString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientsForDataOwner(
        dataOwnerId,
        patients,
      )
    }
  }

  public fun byPatientsSecretIdsForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    secretIdsString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientsSecretIdsForDataOwner(
        dataOwnerId,
        secretIds,
      )
    }
  }

  public fun byHealthElementIdFromSubContactForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    healthElementIdsString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val healthElementIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      healthElementIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byHealthElementIdFromSubContactForDataOwner(
        dataOwnerId,
        healthElementIds,
      )
    }
  }

  public fun byIdentifiersForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, identifiersString: String) {
    val identifiers = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Identifier.serializer()),
      identifiersString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byIdentifiersForSelf(
        identifiers,
      )
    }
  }

  public fun byCodeAndValueDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    codeTypeString: String,
    codeCodeString: String,
    startOfServiceValueDateString: String,
    endOfServiceValueDateString: String,
  ) {
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    val codeCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      codeCodeString
    )
    val startOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfServiceValueDateString
    )
    val endOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfServiceValueDateString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byCodeAndValueDateForSelf(
        codeType,
        codeCode,
        startOfServiceValueDate,
        endOfServiceValueDate,
      )
    }
  }

  public fun byTagAndValueDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    tagTypeString: String,
    tagCodeString: String,
    startOfServiceValueDateString: String,
    endOfServiceValueDateString: String,
  ) {
    val tagType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tagTypeString
    )
    val tagCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tagCodeString
    )
    val startOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfServiceValueDateString
    )
    val endOfServiceValueDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfServiceValueDateString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byTagAndValueDateForSelf(
        tagType,
        tagCode,
        startOfServiceValueDate,
        endOfServiceValueDate,
      )
    }
  }

  public fun byPatientsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, patientsString: String) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientsForSelf(
        patients,
      )
    }
  }

  public fun byPatientsSecretIdsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, secretIdsString: String) {
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientsSecretIdsForSelf(
        secretIds,
      )
    }
  }

  public fun byHealthElementIdFromSubContactForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, healthElementIdsString: String) {
    val healthElementIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      healthElementIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byHealthElementIdFromSubContactForSelf(
        healthElementIds,
      )
    }
  }

  public fun byIds(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, idsString: String) {
    val ids = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      idsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byIds(
        ids,
      )
    }
  }

  public fun byAssociationId(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, associationIdString: String) {
    val associationId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      associationIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byAssociationId(
        associationId,
      )
    }
  }

  public fun byQualifiedLink(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    linkValuesString: String,
    linkQualificationString: String,
  ) {
    val linkValues = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      linkValuesString
    )
    val linkQualification = fullLanguageInteropJson.decodeFromString(
      LinkQualification.serializer().nullable,
      linkQualificationString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byQualifiedLink(
        linkValues,
        linkQualification,
      )
    }
  }

  public fun byPatientsDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    patientsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientsDateForDataOwner(
        dataOwnerId,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    patientsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val patients = fullLanguageInteropJson.decodeFromString(
      ListSerializer(PolymorphicSerializer(Patient::class)),
      patientsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientsDateForSelf(
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    secretIdsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientSecretIdsDateForDataOwner(
        dataOwnerId,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    secretIdsString: String,
    fromString: String,
    toString: String,
    descendingString: String,
  ) {
    val secretIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      secretIdsString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Service::class))
    ) {
      com.icure.cardinal.sdk.filters.ServiceFilters.byPatientSecretIdsDateForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }
}
