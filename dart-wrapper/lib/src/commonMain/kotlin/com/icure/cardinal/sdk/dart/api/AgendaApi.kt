// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object AgendaApi {
  public fun createAgenda(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaDtoString: String,
  ) {
    val agendaDto = fullLanguageInteropJson.decodeFromString(
      Agenda.serializer(),
      agendaDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      Agenda.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.createAgenda(
        agendaDto,
      )
    }
  }

  public fun deleteAgendaById(
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.deleteAgendaById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteAgendasByIds(
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
      ListSerializer(StoredDocumentIdentifier.serializer()),
      entityIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.deleteAgendasByIds(
        entityIds,
      )
    }
  }

  public fun purgeAgendaById(
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
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.purgeAgendaById(
        id,
        rev,
      )
    }
  }

  public fun undeleteAgendaById(
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
      Agenda.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.undeleteAgendaById(
        id,
        rev,
      )
    }
  }

  public fun deleteAgenda(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaString: String,
  ) {
    val agenda = fullLanguageInteropJson.decodeFromString(
      Agenda.serializer(),
      agendaString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.deleteAgenda(
        agenda,
      )
    }
  }

  public fun deleteAgendas(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendasString: String,
  ) {
    val agendas = fullLanguageInteropJson.decodeFromString(
      ListSerializer(Agenda.serializer()),
      agendasString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(DocIdentifier.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.deleteAgendas(
        agendas,
      )
    }
  }

  public fun purgeAgenda(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaString: String,
  ) {
    val agenda = fullLanguageInteropJson.decodeFromString(
      Agenda.serializer(),
      agendaString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.purgeAgenda(
        agenda,
      )
    }
  }

  public fun undeleteAgenda(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaString: String,
  ) {
    val agenda = fullLanguageInteropJson.decodeFromString(
      Agenda.serializer(),
      agendaString
    )
    ApiScope.execute(
      dartResultCallback,
      Agenda.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.undeleteAgenda(
        agenda,
      )
    }
  }

  public fun getAgenda(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaIdString: String,
  ) {
    val agendaId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      agendaIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Agenda.serializer().nullable) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.getAgenda(
        agendaId,
      )
    }
  }

  public fun getAgendas(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaIdsString: String,
  ) {
    val agendaIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      agendaIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(Agenda.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.getAgendas(
        agendaIds,
      )
    }
  }

  public fun modifyAgenda(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    agendaDtoString: String,
  ) {
    val agendaDto = fullLanguageInteropJson.decodeFromString(
      Agenda.serializer(),
      agendaDtoString
    )
    ApiScope.execute(
      dartResultCallback,
      Agenda.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.modifyAgenda(
        agendaDto,
      )
    }
  }

  public fun matchAgendasBy(
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
      BaseFilterOptions.serializer(Agenda.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.matchAgendasBy(
        filter,
      )
    }
  }

  public fun matchAgendasBySorted(
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
      BaseSortableFilterOptions.serializer(Agenda.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.matchAgendasBySorted(
        filter,
      )
    }
  }

  public fun filterAgendasBy(
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
      BaseFilterOptions.serializer(Agenda.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.filterAgendasBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        Agenda.serializer()
      ))
    }
  }

  public fun filterAgendasBySorted(
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
      BaseSortableFilterOptions.serializer(Agenda.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalNonCryptoApis>(sdkId).agenda.filterAgendasBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        Agenda.serializer()
      ))
    }
  }

  @OptIn(InternalIcureApi::class)
  public object inGroup {
    public fun getAgenda(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      entityIdString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val entityId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        entityIdString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(Agenda.serializer()).nullable) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.getAgenda(
          groupId,
          entityId,
        )
      }
    }

    public fun getAgendas(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      entityIdsString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val entityIds = fullLanguageInteropJson.decodeFromString(
        ListSerializer(String.serializer()),
        entityIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(Agenda.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.getAgendas(
          groupId,
          entityIds,
        )
      }
    }

    public fun createAgenda(
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
        GroupScoped.serializer(Agenda.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(Agenda.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.createAgenda(
          entity,
        )
      }
    }

    public fun modifyAgenda(
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
        GroupScoped.serializer(Agenda.serializer()),
        entityString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(Agenda.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.modifyAgenda(
          entity,
        )
      }
    }

    public fun deleteAgendas(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      agendasString: String,
    ) {
      val agendas = fullLanguageInteropJson.decodeFromString(
        ListSerializer(GroupScoped.serializer(Agenda.serializer())),
        agendasString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.deleteAgendas(
          agendas,
        )
      }
    }

    public fun deleteAgenda(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      agendaString: String,
    ) {
      val agenda = fullLanguageInteropJson.decodeFromString(
        GroupScoped.serializer(Agenda.serializer()),
        agendaString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(StoredDocumentIdentifier.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.deleteAgenda(
          agenda,
        )
      }
    }

    public fun deleteAgendasByIds(
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
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
        entityIdsString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.deleteAgendasByIds(
          entityIds,
        )
      }
    }

    public fun deleteAgendaById(
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
        GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
        entityIdString
      )
      ApiScope.execute(
        dartResultCallback,
        GroupScoped.serializer(StoredDocumentIdentifier.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.deleteAgendaById(
          entityId,
        )
      }
    }

    public fun matchAgendasBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseFilterOptions.serializer(Agenda.serializer()),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.matchAgendasBy(
          groupId,
          filter,
        )
      }
    }

    public fun matchAgendasBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseSortableFilterOptions.serializer(Agenda.serializer()),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        ListSerializer(String.serializer())) {
        NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.matchAgendasBySorted(
          groupId,
          filter,
        )
      }
    }

    public fun filterAgendasBy(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseFilterOptions.serializer(Agenda.serializer()),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult = NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.filterAgendasBy(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(Agenda.serializer())
        ))
      }
    }

    public fun filterAgendasBySorted(
      dartResultCallback: (
        String?,
        String?,
        String?,
        String?,
      ) -> Unit,
      sdkId: String,
      groupIdString: String,
      filterString: String,
    ) {
      val groupId = fullLanguageInteropJson.decodeFromString(
        String.serializer(),
        groupIdString
      )
      val filter = fullLanguageInteropJson.decodeFromString(
        BaseSortableFilterOptions.serializer(Agenda.serializer()),
        filterString
      )
      ApiScope.execute(
        dartResultCallback,
        String.serializer()) {
        val richResult =
            NativeReferences.get<CardinalApis>(sdkId).agenda.inGroup.filterAgendasBySorted(
          groupId,
          filter,
        )
        NativeReferences.create(PaginatedListIteratorWithSerializer(
          richResult,
          GroupScoped.serializer(Agenda.serializer())
        ))
      }
    }
  }
}
