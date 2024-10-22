// This file is auto-generated
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/crypto/entities/entity_with_encryption_metadata_stub.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/secure_delegation_key_map.dart';
import 'package:cardinal_sdk/model/topic.dart';
import 'package:cardinal_sdk/model/time_table.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/model/article.dart';
import 'package:cardinal_sdk/model/icure_stub.dart';
import 'package:cardinal_sdk/model/invoice.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/model/classification.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/model/form.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/receipt.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';


abstract interface class HasEncryptionMetadata implements Versionable<String> {
	abstract Set<String> secretForeignKeys;
	abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	abstract Map<String, Set<Delegation>> delegations;
	abstract Map<String, Set<Delegation>> encryptionKeys;
	abstract SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(HasEncryptionMetadata value) {
		switch (value) {
			case EntityWithEncryptionMetadataStub entity:
				Map<String, dynamic> entityJson = EntityWithEncryptionMetadataStub.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub";
				return entityJson;
			case EncryptedPatient entity:
				Map<String, dynamic> entityJson = EncryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedPatient";
				return entityJson;
			case DecryptedPatient entity:
				Map<String, dynamic> entityJson = DecryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedPatient";
				return entityJson;
			case EncryptedSecureDelegationKeyMap entity:
				Map<String, dynamic> entityJson = EncryptedSecureDelegationKeyMap.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap";
				return entityJson;
			case DecryptedSecureDelegationKeyMap entity:
				Map<String, dynamic> entityJson = DecryptedSecureDelegationKeyMap.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap";
				return entityJson;
			case DecryptedTopic entity:
				Map<String, dynamic> entityJson = DecryptedTopic.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedTopic";
				return entityJson;
			case EncryptedTopic entity:
				Map<String, dynamic> entityJson = EncryptedTopic.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedTopic";
				return entityJson;
			case EncryptedTimeTable entity:
				Map<String, dynamic> entityJson = EncryptedTimeTable.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedTimeTable";
				return entityJson;
			case DecryptedTimeTable entity:
				Map<String, dynamic> entityJson = DecryptedTimeTable.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedTimeTable";
				return entityJson;
			case EncryptedDocument entity:
				Map<String, dynamic> entityJson = EncryptedDocument.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedDocument";
				return entityJson;
			case DecryptedDocument entity:
				Map<String, dynamic> entityJson = DecryptedDocument.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedDocument";
				return entityJson;
			case DecryptedMaintenanceTask entity:
				Map<String, dynamic> entityJson = DecryptedMaintenanceTask.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedMaintenanceTask";
				return entityJson;
			case EncryptedMaintenanceTask entity:
				Map<String, dynamic> entityJson = EncryptedMaintenanceTask.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedMaintenanceTask";
				return entityJson;
			case EncryptedArticle entity:
				Map<String, dynamic> entityJson = EncryptedArticle.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedArticle";
				return entityJson;
			case DecryptedArticle entity:
				Map<String, dynamic> entityJson = DecryptedArticle.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedArticle";
				return entityJson;
			case IcureStub entity:
				Map<String, dynamic> entityJson = IcureStub.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.IcureStub";
				return entityJson;
			case DecryptedInvoice entity:
				Map<String, dynamic> entityJson = DecryptedInvoice.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedInvoice";
				return entityJson;
			case EncryptedInvoice entity:
				Map<String, dynamic> entityJson = EncryptedInvoice.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedInvoice";
				return entityJson;
			case DecryptedContact entity:
				Map<String, dynamic> entityJson = DecryptedContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedContact";
				return entityJson;
			case EncryptedContact entity:
				Map<String, dynamic> entityJson = EncryptedContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedContact";
				return entityJson;
			case DecryptedCalendarItem entity:
				Map<String, dynamic> entityJson = DecryptedCalendarItem.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedCalendarItem";
				return entityJson;
			case EncryptedCalendarItem entity:
				Map<String, dynamic> entityJson = EncryptedCalendarItem.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedCalendarItem";
				return entityJson;
			case EncryptedClassification entity:
				Map<String, dynamic> entityJson = EncryptedClassification.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedClassification";
				return entityJson;
			case DecryptedClassification entity:
				Map<String, dynamic> entityJson = DecryptedClassification.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedClassification";
				return entityJson;
			case EncryptedHealthElement entity:
				Map<String, dynamic> entityJson = EncryptedHealthElement.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedHealthElement";
				return entityJson;
			case DecryptedHealthElement entity:
				Map<String, dynamic> entityJson = DecryptedHealthElement.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedHealthElement";
				return entityJson;
			case EncryptedForm entity:
				Map<String, dynamic> entityJson = EncryptedForm.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedForm";
				return entityJson;
			case DecryptedForm entity:
				Map<String, dynamic> entityJson = DecryptedForm.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedForm";
				return entityJson;
			case DecryptedAccessLog entity:
				Map<String, dynamic> entityJson = DecryptedAccessLog.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedAccessLog";
				return entityJson;
			case EncryptedAccessLog entity:
				Map<String, dynamic> entityJson = EncryptedAccessLog.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedAccessLog";
				return entityJson;
			case DecryptedMessage entity:
				Map<String, dynamic> entityJson = DecryptedMessage.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedMessage";
				return entityJson;
			case EncryptedMessage entity:
				Map<String, dynamic> entityJson = EncryptedMessage.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedMessage";
				return entityJson;
			case DecryptedReceipt entity:
				Map<String, dynamic> entityJson = DecryptedReceipt.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedReceipt";
				return entityJson;
			case EncryptedReceipt entity:
				Map<String, dynamic> entityJson = EncryptedReceipt.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedReceipt";
				return entityJson;
			default:
				throw ArgumentError('Invalid subclass $value');
		}
	}

	static HasEncryptionMetadata fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub":
				return EntityWithEncryptionMetadataStub.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedPatient":
				return EncryptedPatient.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedPatient":
				return DecryptedPatient.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap":
				return EncryptedSecureDelegationKeyMap.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap":
				return DecryptedSecureDelegationKeyMap.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedTopic":
				return DecryptedTopic.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedTopic":
				return EncryptedTopic.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedTimeTable":
				return EncryptedTimeTable.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedTimeTable":
				return DecryptedTimeTable.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedDocument":
				return EncryptedDocument.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedDocument":
				return DecryptedDocument.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedMaintenanceTask":
				return DecryptedMaintenanceTask.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedMaintenanceTask":
				return EncryptedMaintenanceTask.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedArticle":
				return EncryptedArticle.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedArticle":
				return DecryptedArticle.fromJSON(data);
			case "com.icure.cardinal.sdk.model.IcureStub":
				return IcureStub.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedInvoice":
				return DecryptedInvoice.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedInvoice":
				return EncryptedInvoice.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedContact":
				return DecryptedContact.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedContact":
				return EncryptedContact.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedCalendarItem":
				return DecryptedCalendarItem.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedCalendarItem":
				return EncryptedCalendarItem.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedClassification":
				return EncryptedClassification.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedClassification":
				return DecryptedClassification.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedHealthElement":
				return EncryptedHealthElement.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedHealthElement":
				return DecryptedHealthElement.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedForm":
				return EncryptedForm.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedForm":
				return DecryptedForm.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedAccessLog":
				return DecryptedAccessLog.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedAccessLog":
				return EncryptedAccessLog.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedMessage":
				return DecryptedMessage.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedMessage":
				return EncryptedMessage.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedReceipt":
				return DecryptedReceipt.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedReceipt":
				return EncryptedReceipt.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}