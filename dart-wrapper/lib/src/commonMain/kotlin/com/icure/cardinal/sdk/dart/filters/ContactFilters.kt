// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object ContactFilters {
  public fun allContactsForDataOwner(dartResultCallback: (
    String?,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.allContactsForDataOwner(
        dataOwnerId,
      )
    }
  }

  public fun allContactsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.allContactsForSelf(
      )
    }
  }

  public fun byFormIdsForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    formIdsString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val formIds = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      formIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byFormIdsForDataOwner(
        dataOwnerId,
        formIds,
      )
    }
  }

  public fun byFormIdsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, formIdsString: String) {
    val formIds = fullLanguageInteropJson.decodeFromString(
      SetSerializer(String.serializer()),
      formIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byFormIdsForSelf(
        formIds,
      )
    }
  }

  public fun byPatientsOpeningDateForDataOwner(
    dartResultCallback: (
      String?,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientsOpeningDateForDataOwner(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientsOpeningDateForSelf(
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientSecretIdsOpeningDateForDataOwner(
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientSecretIdsOpeningDateForSelf(
        secretIds,
        from,
        to,
        descending,
      )
    }
  }

  public fun byExternalId(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, externalIdString: String) {
    val externalId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      externalIdString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byExternalId(
        externalId,
      )
    }
  }

  public fun byIdentifiersForSelf(dartResultCallback: (
    String?,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byIdentifiersForSelf(
        identifiers,
      )
    }
  }

  public fun byIdentifiersForDataOwner(
    dartResultCallback: (
      String?,
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byIdentifiersForDataOwner(
        dataOwnerId,
        identifiers,
      )
    }
  }

  public fun byCodeAndOpeningDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    codeTypeString: String,
    codeCodeString: String,
    startOfContactOpeningDateString: String,
    endOfContactOpeningDateString: String,
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
    val startOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfContactOpeningDateString
    )
    val endOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfContactOpeningDateString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byCodeAndOpeningDateForDataOwner(
        dataOwnerId,
        codeType,
        codeCode,
        startOfContactOpeningDate,
        endOfContactOpeningDate,
      )
    }
  }

  public fun byCodeAndOpeningDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    codeTypeString: String,
    codeCodeString: String,
    startOfContactOpeningDateString: String,
    endOfContactOpeningDateString: String,
  ) {
    val codeType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      codeTypeString
    )
    val codeCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      codeCodeString
    )
    val startOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfContactOpeningDateString
    )
    val endOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfContactOpeningDateString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byCodeAndOpeningDateForSelf(
        codeType,
        codeCode,
        startOfContactOpeningDate,
        endOfContactOpeningDate,
      )
    }
  }

  public fun byTagAndOpeningDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    tagTypeString: String,
    tagCodeString: String,
    startOfContactOpeningDateString: String,
    endOfContactOpeningDateString: String,
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
    val startOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfContactOpeningDateString
    )
    val endOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfContactOpeningDateString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byTagAndOpeningDateForDataOwner(
        dataOwnerId,
        tagType,
        tagCode,
        startOfContactOpeningDate,
        endOfContactOpeningDate,
      )
    }
  }

  public fun byOpeningDateForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    startDateString: String,
    endDateString: String,
    descendingString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val startDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startDateString
    )
    val endDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endDateString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byOpeningDateForDataOwner(
        dataOwnerId,
        startDate,
        endDate,
        descending,
      )
    }
  }

  public fun byOpeningDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    startDateString: String,
    endDateString: String,
    descendingString: String,
  ) {
    val startDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startDateString
    )
    val endDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endDateString
    )
    val descending = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      descendingString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byOpeningDateForSelf(
        startDate,
        endDate,
        descending,
      )
    }
  }

  public fun byServiceTagForSelf(
    dartResultCallback: (
      String?,
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
      FilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byServiceTagForSelf(
        tagType,
        tagCode,
      )
    }
  }

  public fun byServiceTagForDataOwner(
    dartResultCallback: (
      String?,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byServiceTagForDataOwner(
        dataOwnerId,
        tagType,
        tagCode,
      )
    }
  }

  public fun byServiceCodeForSelf(
    dartResultCallback: (
      String?,
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
      FilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byServiceCodeForSelf(
        codeType,
        codeCode,
      )
    }
  }

  public fun byServiceCodeForDataOwner(
    dartResultCallback: (
      String?,
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byServiceCodeForDataOwner(
        dataOwnerId,
        codeType,
        codeCode,
      )
    }
  }

  public fun byTagAndOpeningDateForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    tagTypeString: String,
    tagCodeString: String,
    startOfContactOpeningDateString: String,
    endOfContactOpeningDateString: String,
  ) {
    val tagType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      tagTypeString
    )
    val tagCode = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tagCodeString
    )
    val startOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      startOfContactOpeningDateString
    )
    val endOfContactOpeningDate = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      endOfContactOpeningDateString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byTagAndOpeningDateForSelf(
        tagType,
        tagCode,
        startOfContactOpeningDate,
        endOfContactOpeningDate,
      )
    }
  }

  public fun byPatientsForDataOwner(
    dartResultCallback: (
      String?,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientsForDataOwner(
        dataOwnerId,
        patients,
      )
    }
  }

  public fun byPatientsForSelf(dartResultCallback: (
    String?,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientsForSelf(
        patients,
      )
    }
  }

  public fun byPatientsSecretIdsForDataOwner(
    dartResultCallback: (
      String?,
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientsSecretIdsForDataOwner(
        dataOwnerId,
        secretIds,
      )
    }
  }

  public fun byPatientsSecretIdsForSelf(dartResultCallback: (
    String?,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byPatientsSecretIdsForSelf(
        secretIds,
      )
    }
  }

  public fun byServiceIds(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, serviceIdsString: String) {
    val serviceIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      serviceIdsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Contact::class))
    ) {
      com.icure.cardinal.sdk.filters.ContactFilters.byServiceIds(
        serviceIds,
      )
    }
  }
}
