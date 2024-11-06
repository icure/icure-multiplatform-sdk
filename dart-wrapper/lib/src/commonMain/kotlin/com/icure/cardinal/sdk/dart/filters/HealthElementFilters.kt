// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object HealthElementFilters {
  public fun allHealthElementsForDataOwner(dartResultCallback: (
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
      BaseFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.allHealthElementsForDataOwner(
        dataOwnerId,
      )
    }
  }

  public fun allHealthElementsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.allHealthElementsForSelf(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byIdentifiersForDataOwner(
        dataOwnerId,
        identifiers,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byIdentifiersForSelf(
        identifiers,
      )
    }
  }

  public fun byCodeForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    codeTypeString: String,
    codeCodeString: String,
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
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byCodeForDataOwner(
        dataOwnerId,
        codeType,
        codeCode,
      )
    }
  }

  public fun byCodeForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    codeTypeString: String,
    codeCodeString: String,
  ) {
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    val codeCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      codeCodeString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byCodeForSelf(
        codeType,
        codeCode,
      )
    }
  }

  public fun byTagForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    tagTypeString: String,
    tagCodeString: String,
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
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byTagForDataOwner(
        dataOwnerId,
        tagType,
        tagCode,
      )
    }
  }

  public fun byTagForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    tagTypeString: String,
    tagCodeString: String,
  ) {
    val tagType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tagTypeString
    )
    val tagCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tagCodeString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byTagForSelf(
        tagType,
        tagCode,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientsForDataOwner(
        dataOwnerId,
        patients,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientsForSelf(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientsSecretIdsForDataOwner(
        dataOwnerId,
        secretIds,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientsSecretIdsForSelf(
        secretIds,
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byIds(
        ids,
      )
    }
  }

  public fun byPatientsOpeningDateForDataOwner(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientsOpeningDateForDataOwner(
        dataOwnerId,
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientsOpeningDateForSelf(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientsOpeningDateForSelf(
        patients,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsOpeningDateForDataOwner(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwner(
        dataOwnerId,
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byPatientSecretIdsOpeningDateForSelf(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byPatientSecretIdsOpeningDateForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byStatusForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    statusString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val status = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      statusString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byStatusForDataOwner(
        dataOwnerId,
        status,
      )
    }
  }

  public fun byStatusForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, statusString: String) {
    val status = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      statusString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(HealthElement::class))
    ) {
      com.icure.cardinal.sdk.filters.HealthElementFilters.byStatusForSelf(
        status,
      )
    }
  }
}
