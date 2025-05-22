// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object InvoiceBasicApi {
  public fun deleteInvoice(
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
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.deleteInvoice(
        entityId,
      )
    }
  }

  public fun getTarificationsCodesOccurrences(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    minOccurrenceString: String,
  ) {
    val minOccurrence = fullLanguageInteropJson.decodeFromString(
      Int.serializer(),
      minOccurrenceString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(LabelledOccurence.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.getTarificationsCodesOccurrences(
        minOccurrence,
      )
    }
  }

  public fun modifyInvoice(
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
      EncryptedInvoice.serializer(),
      entityString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedInvoice.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.modifyInvoice(
        entity,
      )
    }
  }

  public fun modifyInvoices(
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
      ListSerializer(EncryptedInvoice.serializer()),
      entitiesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.modifyInvoices(
        entities,
      )
    }
  }

  public fun getInvoice(
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
      EncryptedInvoice.serializer().nullable) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.getInvoice(
        entityId,
      )
    }
  }

  public fun getInvoices(
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
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.getInvoices(
        entityIds,
      )
    }
  }

  public fun reassignInvoice(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    invoiceString: String,
  ) {
    val invoice = fullLanguageInteropJson.decodeFromString(
      EncryptedInvoice.serializer(),
      invoiceString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedInvoice.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.reassignInvoice(
        invoice,
      )
    }
  }

  public fun mergeTo(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    invoiceIdString: String,
    idsString: String,
  ) {
    val invoiceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      invoiceIdString
    )
    val ids = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      idsString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedInvoice.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.mergeTo(
        invoiceId,
        ids,
      )
    }
  }

  public fun validate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    invoiceIdString: String,
    schemeString: String,
    forcedValueString: String,
  ) {
    val invoiceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      invoiceIdString
    )
    val scheme = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      schemeString
    )
    val forcedValue = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      forcedValueString
    )
    ApiScope.execute(
      dartResultCallback,
      EncryptedInvoice.serializer()) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.validate(
        invoiceId,
        scheme,
        forcedValue,
      )
    }
  }

  public fun appendCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    typeString: String,
    sentMediumTypeString: String,
    secretFKeysString: String,
    insuranceIdString: String,
    invoiceIdString: String,
    gracePeriodString: String,
    invoicingCodesString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val type = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      typeString
    )
    val sentMediumType = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      sentMediumTypeString
    )
    val secretFKeys = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      secretFKeysString
    )
    val insuranceId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      insuranceIdString
    )
    val invoiceId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      invoiceIdString
    )
    val gracePeriod = fullLanguageInteropJson.decodeFromString(
      Int.serializer().nullable,
      gracePeriodString
    )
    val invoicingCodes = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedInvoicingCode.serializer()),
      invoicingCodesString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.appendCodes(
        userId,
        type,
        sentMediumType,
        secretFKeys,
        insuranceId,
        invoiceId,
        gracePeriod,
        invoicingCodes,
      )
    }
  }

  public fun removeCodes(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    serviceIdString: String,
    secretFKeysString: String,
    tarificationIdsString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val serviceId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      serviceIdString
    )
    val secretFKeys = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      secretFKeysString
    )
    val tarificationIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      tarificationIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.removeCodes(
        userId,
        serviceId,
        secretFKeys,
        tarificationIds,
      )
    }
  }

  public fun listInvoicesByHcPartyAndGroupId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
    groupIdString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listInvoicesByHcPartyAndGroupId(
        hcPartyId,
        groupId,
      )
    }
  }

  public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
    sentMediumTypeString: String,
    invoiceTypeString: String,
    sentString: String,
    fromString: String,
    toString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    val sentMediumType = fullLanguageInteropJson.decodeFromString(
      MediumType.serializer(),
      sentMediumTypeString
    )
    val invoiceType = fullLanguageInteropJson.decodeFromString(
      InvoiceType.serializer(),
      invoiceTypeString
    )
    val sent = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      sentString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      toString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
        hcPartyId,
        sentMediumType,
        invoiceType,
        sent,
        from,
        to,
      )
    }
  }

  public fun listInvoicesByContactIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    contactIdsString: String,
  ) {
    val contactIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      contactIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listInvoicesByContactIds(
        contactIds,
      )
    }
  }

  public fun listInvoicesByRecipientsIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    recipientsIdsString: String,
  ) {
    val recipientsIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      recipientsIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listInvoicesByRecipientsIds(
        recipientsIds,
      )
    }
  }

  public fun listToInsurances(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdsString: String,
  ) {
    val userIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      userIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listToInsurances(
        userIds,
      )
    }
  }

  public fun listToInsurancesUnsent(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdsString: String,
  ) {
    val userIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      userIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listToInsurancesUnsent(
        userIds,
      )
    }
  }

  public fun listToPatients(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listToPatients(
        hcPartyId,
      )
    }
  }

  public fun listToPatientsUnsent(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      hcPartyIdString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listToPatientsUnsent(
        hcPartyId,
      )
    }
  }

  public fun listInvoicesByIds(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idsString: String,
  ) {
    val ids = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      idsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listInvoicesByIds(
        ids,
      )
    }
  }

  public fun listInvoicesByHcpartySendingModeStatusDate(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    hcPartyIdString: String,
    sendingModeString: String,
    statusString: String,
    fromString: String,
    toString: String,
  ) {
    val hcPartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      hcPartyIdString
    )
    val sendingMode = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      sendingModeString
    )
    val status = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      statusString
    )
    val from = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      fromString
    )
    val to = fullLanguageInteropJson.decodeFromString(
      Long.serializer(),
      toString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(EncryptedInvoice.serializer())) {
      NativeReferences.get<CardinalBaseApis>(sdkId).invoice.listInvoicesByHcpartySendingModeStatusDate(
        hcPartyId,
        sendingMode,
        status,
        from,
        to,
      )
    }
  }
}
