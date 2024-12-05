// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object PatientFilters {
  public fun allPatientsForDataOwner(dartResultCallback: (
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
      BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.allPatientsForDataOwner(
        dataOwnerId,
      )
    }
  }

  public fun allPatientsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.allPatientsForSelf(
      )
    }
  }

  public fun byIds(dartResultCallback: (
    String?,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byIds(
        ids,
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
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byIdentifiersForDataOwner(
        dataOwnerId,
        identifiers,
      )
    }
  }

  public fun bySsinsForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    ssinsString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val ssins = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      ssinsString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.bySsinsForDataOwner(
        dataOwnerId,
        ssins,
      )
    }
  }

  public fun byDateOfBirthBetweenForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    fromDateString: String,
    toDateString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val fromDate = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      fromDateString
    )
    val toDate = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      toDateString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byDateOfBirthBetweenForDataOwner(
        dataOwnerId,
        fromDate,
        toDate,
      )
    }
  }

  public fun byFuzzyNameForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    searchStringString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byFuzzyNameForDataOwner(
        dataOwnerId,
        searchString,
      )
    }
  }

  public fun byGenderEducationProfessionForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    genderString: String,
    educationString: String,
    professionString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val gender = fullLanguageInteropJson.decodeFromString(
      Gender.serializer(),
      genderString
    )
    val education = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      educationString
    )
    val profession = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      professionString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byGenderEducationProfessionForDataOwner(
        dataOwnerId,
        gender,
        education,
        profession,
      )
    }
  }

  public fun byActiveForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    activeString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val active = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      activeString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byActiveForDataOwner(
        dataOwnerId,
        active,
      )
    }
  }

  public fun byTelecomForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    searchStringString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byTelecomForDataOwner(
        dataOwnerId,
        searchString,
      )
    }
  }

  public fun byAddressPostalCodeHouseNumberForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    searchStringString: String,
    postalCodeString: String,
    houseNumberString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    val postalCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      postalCodeString
    )
    val houseNumber = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      houseNumberString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byAddressPostalCodeHouseNumberForDataOwner(
        dataOwnerId,
        searchString,
        postalCode,
        houseNumber,
      )
    }
  }

  public fun byAddressForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    searchStringString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byAddressForDataOwner(
        dataOwnerId,
        searchString,
      )
    }
  }

  public fun byExternalIdForDataOwner(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    dataOwnerIdString: String,
    externalIdPrefixString: String,
  ) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    val externalIdPrefix = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      externalIdPrefixString
    )
    DartResult.resolve(
      dartResultCallback,
      BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byExternalIdForDataOwner(
        dataOwnerId,
        externalIdPrefix,
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
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byIdentifiersForSelf(
        identifiers,
      )
    }
  }

  public fun bySsinsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, ssinsString: String) {
    val ssins = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      ssinsString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.bySsinsForSelf(
        ssins,
      )
    }
  }

  public fun byDateOfBirthBetweenForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    fromDateString: String,
    toDateString: String,
  ) {
    val fromDate = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      fromDateString
    )
    val toDate = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      toDateString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byDateOfBirthBetweenForSelf(
        fromDate,
        toDate,
      )
    }
  }

  public fun byNameForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, searchStringString: String) {
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byNameForSelf(
        searchString,
      )
    }
  }

  public fun byGenderEducationProfessionForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    genderString: String,
    educationString: String,
    professionString: String,
  ) {
    val gender = fullLanguageInteropJson.decodeFromString(
      Gender.serializer(),
      genderString
    )
    val education = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      educationString
    )
    val profession = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      professionString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byGenderEducationProfessionForSelf(
        gender,
        education,
        profession,
      )
    }
  }

  public fun byActiveForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, activeString: String) {
    val active = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      activeString
    )
    DartResult.resolve(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byActiveForSelf(
        active,
      )
    }
  }

  public fun byTelecomForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, searchStringString: String) {
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byTelecomForSelf(
        searchString,
      )
    }
  }

  public fun byAddressPostalCodeHouseNumberForSelf(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    searchStringString: String,
    postalCodeString: String,
    houseNumberString: String,
  ) {
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    val postalCode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      postalCodeString
    )
    val houseNumber = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      houseNumberString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byAddressPostalCodeHouseNumberForSelf(
        searchString,
        postalCode,
        houseNumber,
      )
    }
  }

  public fun byAddressForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, searchStringString: String) {
    val searchString = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      searchStringString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byAddressForSelf(
        searchString,
      )
    }
  }

  public fun byExternalIdForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, externalIdPrefixString: String) {
    val externalIdPrefix = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      externalIdPrefixString
    )
    DartResult.resolve(
      dartResultCallback,
      SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class))
    ) {
      com.icure.cardinal.sdk.filters.PatientFilters.byExternalIdForSelf(
        externalIdPrefix,
      )
    }
  }
}
