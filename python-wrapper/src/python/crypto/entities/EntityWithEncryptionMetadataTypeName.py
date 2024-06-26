from typing import Union, Dict
from enum import Enum

class EntityWithEncryptionMetadataTypeName(Enum):
	Article = "Article"
	AccessLog = "AccessLog"
	CalendarItem = "CalendarItem"
	Classification = "Classification"
	ClassificationTemplate = "ClassificationTemplate"
	Contact = "Contact"
	Service = "Service"
	Document = "Document"
	Form = "Form"
	HealthElement = "HealthElement"
	Invoice = "Invoice"
	MaintenanceTask = "MaintenanceTask"
	Message = "Message"
	Patient = "Patient"
	Receipt = "Receipt"
	TimeTable = "TimeTable"
	Topic = "Topic"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityWithEncryptionMetadataTypeName':
		if data == "Article":
			return EntityWithEncryptionMetadataTypeName.Article
		elif data == "AccessLog":
			return EntityWithEncryptionMetadataTypeName.AccessLog
		elif data == "CalendarItem":
			return EntityWithEncryptionMetadataTypeName.CalendarItem
		elif data == "Classification":
			return EntityWithEncryptionMetadataTypeName.Classification
		elif data == "ClassificationTemplate":
			return EntityWithEncryptionMetadataTypeName.ClassificationTemplate
		elif data == "Contact":
			return EntityWithEncryptionMetadataTypeName.Contact
		elif data == "Service":
			return EntityWithEncryptionMetadataTypeName.Service
		elif data == "Document":
			return EntityWithEncryptionMetadataTypeName.Document
		elif data == "Form":
			return EntityWithEncryptionMetadataTypeName.Form
		elif data == "HealthElement":
			return EntityWithEncryptionMetadataTypeName.HealthElement
		elif data == "Invoice":
			return EntityWithEncryptionMetadataTypeName.Invoice
		elif data == "MaintenanceTask":
			return EntityWithEncryptionMetadataTypeName.MaintenanceTask
		elif data == "Message":
			return EntityWithEncryptionMetadataTypeName.Message
		elif data == "Patient":
			return EntityWithEncryptionMetadataTypeName.Patient
		elif data == "Receipt":
			return EntityWithEncryptionMetadataTypeName.Receipt
		elif data == "TimeTable":
			return EntityWithEncryptionMetadataTypeName.TimeTable
		elif data == "Topic":
			return EntityWithEncryptionMetadataTypeName.Topic
		else:
			raise Exception(f"{data} is not a valid value for EntityWithEncryptionMetadataTypeName enum.")

__all__ = ['EntityWithEncryptionMetadataTypeName']