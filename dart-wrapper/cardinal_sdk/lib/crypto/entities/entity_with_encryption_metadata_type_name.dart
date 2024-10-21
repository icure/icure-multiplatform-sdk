// This file is auto-generated


enum EntityWithEncryptionMetadataTypeName {
	article,
	accessLog,
	calendarItem,
	classification,
	classificationTemplate,
	contact,
	service,
	document,
	form,
	healthElement,
	invoice,
	maintenanceTask,
	message,
	patient,
	receipt,
	timeTable,
	topic;

	static String encode(EntityWithEncryptionMetadataTypeName value) {
		switch (value) {
			case EntityWithEncryptionMetadataTypeName.article:
				return '"Article"';
			case EntityWithEncryptionMetadataTypeName.accessLog:
				return '"AccessLog"';
			case EntityWithEncryptionMetadataTypeName.calendarItem:
				return '"CalendarItem"';
			case EntityWithEncryptionMetadataTypeName.classification:
				return '"Classification"';
			case EntityWithEncryptionMetadataTypeName.classificationTemplate:
				return '"ClassificationTemplate"';
			case EntityWithEncryptionMetadataTypeName.contact:
				return '"Contact"';
			case EntityWithEncryptionMetadataTypeName.service:
				return '"Service"';
			case EntityWithEncryptionMetadataTypeName.document:
				return '"Document"';
			case EntityWithEncryptionMetadataTypeName.form:
				return '"Form"';
			case EntityWithEncryptionMetadataTypeName.healthElement:
				return '"HealthElement"';
			case EntityWithEncryptionMetadataTypeName.invoice:
				return '"Invoice"';
			case EntityWithEncryptionMetadataTypeName.maintenanceTask:
				return '"MaintenanceTask"';
			case EntityWithEncryptionMetadataTypeName.message:
				return '"Message"';
			case EntityWithEncryptionMetadataTypeName.patient:
				return '"Patient"';
			case EntityWithEncryptionMetadataTypeName.receipt:
				return '"Receipt"';
			case EntityWithEncryptionMetadataTypeName.timeTable:
				return '"TimeTable"';
			case EntityWithEncryptionMetadataTypeName.topic:
				return '"Topic"';
			}
	}

}