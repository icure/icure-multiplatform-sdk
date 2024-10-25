// auto-generated file
package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object TopicFilters {
  public fun allTopicsForDataOwner(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, dataOwnerIdString: String) {
    val dataOwnerId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      dataOwnerIdString
    )
    ApiScope.execute(
      dartResultCallback,
      BaseFilterOptions.serializer(PolymorphicSerializer(Topic::class))
    ) {
      com.icure.cardinal.sdk.filters.TopicFilters.allTopicsForDataOwner(
        dataOwnerId,
      )
    }
  }

  public fun allTopicsForSelf(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit) {
    ApiScope.execute(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Topic::class))
    ) {
      com.icure.cardinal.sdk.filters.TopicFilters.allTopicsForSelf(
      )
    }
  }

  public fun byParticipant(dartResultCallback: (
    String?,
    String?,
    String?,
  ) -> Unit, participantIdString: String) {
    val participantId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      participantIdString
    )
    ApiScope.execute(
      dartResultCallback,
      FilterOptions.serializer(PolymorphicSerializer(Topic::class))
    ) {
      com.icure.cardinal.sdk.filters.TopicFilters.byParticipant(
        participantId,
      )
    }
  }
}
