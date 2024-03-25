package com.icure.sdk.model

/**
 * Names for entities that support secure delegations.
 */
enum class EntityWithDelegationTypeName(
	/**
	 * Uniquely identifies the entity type, it is included as a "salt" in the secure delegation key, to segregate the
	 * secure delegation key spaces of different entity types.
	 * We must never change these values since it could break the secure delegation key derivation, making some data
	 * inaccessible to anonymous users.
	 */
	val id: String
) {
	Article("Article"),
	AccessLog("AccessLog"),
	CalendarItem("CalendarItem"),
	Classification("Classification"),
	ClassificationTemplate("ClassificationTemplate"),
	Contact("Contact"),
	Document("Document"),
	Form("Form"),
	HealthElement("HealthElement"),
	Invoice("Invoice"),
	MaintenanceTask("MaintenanceTask"),
	Message("Message"),
	Patient("Patient"),
	Receipt("Receipt"),
	TimeTable("TimeTable"),
	Topic("Topic")
}