// This file is auto-generated
package com.icure.sdk.serialization

import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.Article
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.Classification
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedAccessLog
import com.icure.sdk.model.DecryptedArticle
import com.icure.sdk.model.DecryptedCalendarItem
import com.icure.sdk.model.DecryptedClassification
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.DecryptedProperty
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.DecryptedReceipt
import com.icure.sdk.model.DecryptedSecureDelegationKeyMap
import com.icure.sdk.model.DecryptedTimeTable
import com.icure.sdk.model.DecryptedTopic
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.EncryptedArticle
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.EncryptedProperty
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.EncryptedReceipt
import com.icure.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.Form
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Property
import com.icure.sdk.model.PropertyStub
import com.icure.sdk.model.Receipt
import com.icure.sdk.model.SecureDelegationKeyMap
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.Topic
import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.CareTeamMember
import com.icure.sdk.model.embed.CareTeamMembership
import com.icure.sdk.model.embed.Content
import com.icure.sdk.model.embed.DecryptedAddress
import com.icure.sdk.model.embed.DecryptedCareTeamMember
import com.icure.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.sdk.model.embed.DecryptedContent
import com.icure.sdk.model.embed.DecryptedEpisode
import com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.sdk.model.embed.DecryptedInsurability
import com.icure.sdk.model.embed.DecryptedInvoicingCode
import com.icure.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.sdk.model.embed.DecryptedPlanOfAction
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.DecryptedSubContact
import com.icure.sdk.model.embed.DecryptedTelecom
import com.icure.sdk.model.embed.DecryptedValorisation
import com.icure.sdk.model.embed.EncryptedAddress
import com.icure.sdk.model.embed.EncryptedCareTeamMember
import com.icure.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.embed.EncryptedEpisode
import com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.EncryptedFlatRateTarification
import com.icure.sdk.model.embed.EncryptedInsurability
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.sdk.model.embed.EncryptedPlanOfAction
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.EncryptedSubContact
import com.icure.sdk.model.embed.EncryptedTelecom
import com.icure.sdk.model.embed.EncryptedValorisation
import com.icure.sdk.model.embed.Episode
import com.icure.sdk.model.embed.FinancialInstitutionInformation
import com.icure.sdk.model.embed.FlatRateTarification
import com.icure.sdk.model.embed.Insurability
import com.icure.sdk.model.embed.InvoicingCode
import com.icure.sdk.model.embed.MedicalHouseContract
import com.icure.sdk.model.embed.PatientHealthCareParty
import com.icure.sdk.model.embed.PlanOfAction
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.embed.SubContact
import com.icure.sdk.model.embed.Telecom
import com.icure.sdk.model.embed.Valorisation
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

internal object EncryptableSerializationModule {
	public val module: SerializersModule = SerializersModule {
		polymorphic(AccessLog::class) {
			subclass(DecryptedAccessLog::class)
			subclass(EncryptedAccessLog::class)
		}
		polymorphic(Address::class) {
			subclass(DecryptedAddress::class)
			subclass(EncryptedAddress::class)
		}
		polymorphic(Article::class) {
			subclass(DecryptedArticle::class)
			subclass(EncryptedArticle::class)
		}
		polymorphic(CalendarItem::class) {
			subclass(DecryptedCalendarItem::class)
			subclass(EncryptedCalendarItem::class)
		}
		polymorphic(CareTeamMember::class) {
			subclass(DecryptedCareTeamMember::class)
			subclass(EncryptedCareTeamMember::class)
		}
		polymorphic(CareTeamMembership::class) {
			subclass(DecryptedCareTeamMembership::class)
			subclass(EncryptedCareTeamMembership::class)
		}
		polymorphic(Classification::class) {
			subclass(DecryptedClassification::class)
			subclass(EncryptedClassification::class)
		}
		polymorphic(Contact::class) {
			subclass(DecryptedContact::class)
			subclass(EncryptedContact::class)
		}
		polymorphic(Content::class) {
			subclass(DecryptedContent::class)
			subclass(EncryptedContent::class)
		}
		polymorphic(Document::class) {
			subclass(DecryptedDocument::class)
			subclass(EncryptedDocument::class)
		}
		polymorphic(Episode::class) {
			subclass(DecryptedEpisode::class)
			subclass(EncryptedEpisode::class)
		}
		polymorphic(FinancialInstitutionInformation::class) {
			subclass(DecryptedFinancialInstitutionInformation::class)
			subclass(EncryptedFinancialInstitutionInformation::class)
		}
		polymorphic(FlatRateTarification::class) {
			subclass(DecryptedFlatRateTarification::class)
			subclass(EncryptedFlatRateTarification::class)
		}
		polymorphic(Form::class) {
			subclass(DecryptedForm::class)
			subclass(EncryptedForm::class)
		}
		polymorphic(HealthElement::class) {
			subclass(DecryptedHealthElement::class)
			subclass(EncryptedHealthElement::class)
		}
		polymorphic(Insurability::class) {
			subclass(DecryptedInsurability::class)
			subclass(EncryptedInsurability::class)
		}
		polymorphic(Invoice::class) {
			subclass(DecryptedInvoice::class)
			subclass(EncryptedInvoice::class)
		}
		polymorphic(InvoicingCode::class) {
			subclass(DecryptedInvoicingCode::class)
			subclass(EncryptedInvoicingCode::class)
		}
		polymorphic(MaintenanceTask::class) {
			subclass(DecryptedMaintenanceTask::class)
			subclass(EncryptedMaintenanceTask::class)
		}
		polymorphic(MedicalHouseContract::class) {
			subclass(DecryptedMedicalHouseContract::class)
			subclass(EncryptedMedicalHouseContract::class)
		}
		polymorphic(Message::class) {
			subclass(DecryptedMessage::class)
			subclass(EncryptedMessage::class)
		}
		polymorphic(Patient::class) {
			subclass(DecryptedPatient::class)
			subclass(EncryptedPatient::class)
		}
		polymorphic(PatientHealthCareParty::class) {
			subclass(DecryptedPatientHealthCareParty::class)
			subclass(EncryptedPatientHealthCareParty::class)
		}
		polymorphic(PlanOfAction::class) {
			subclass(DecryptedPlanOfAction::class)
			subclass(EncryptedPlanOfAction::class)
		}
		polymorphic(Property::class) {
			subclass(DecryptedProperty::class)
			subclass(EncryptedProperty::class)
		}
		polymorphic(PropertyStub::class) {
			subclass(DecryptedPropertyStub::class)
			subclass(EncryptedPropertyStub::class)
		}
		polymorphic(Receipt::class) {
			subclass(DecryptedReceipt::class)
			subclass(EncryptedReceipt::class)
		}
		polymorphic(SecureDelegationKeyMap::class) {
			subclass(DecryptedSecureDelegationKeyMap::class)
			subclass(EncryptedSecureDelegationKeyMap::class)
		}
		polymorphic(Service::class) {
			subclass(DecryptedService::class)
			subclass(EncryptedService::class)
		}
		polymorphic(SubContact::class) {
			subclass(DecryptedSubContact::class)
			subclass(EncryptedSubContact::class)
		}
		polymorphic(Telecom::class) {
			subclass(DecryptedTelecom::class)
			subclass(EncryptedTelecom::class)
		}
		polymorphic(TimeTable::class) {
			subclass(DecryptedTimeTable::class)
			subclass(EncryptedTimeTable::class)
		}
		polymorphic(Topic::class) {
			subclass(DecryptedTopic::class)
			subclass(EncryptedTopic::class)
		}
		polymorphic(Valorisation::class) {
			subclass(DecryptedValorisation::class)
			subclass(EncryptedValorisation::class)
		}
	}
}
