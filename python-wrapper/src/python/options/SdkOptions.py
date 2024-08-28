from dataclasses import dataclass, field
from typing import List, Optional
from icure.CryptoStrategies import CryptoStrategies
from icure.storage.StorageFacadeOptions import StorageOptions
from icure.options.JsonPatcher import JsonPatcher

@dataclass
class EncryptedFieldsConfiguration:
    access_log: List[str] = field(default_factory=lambda: ["detail", "objectId"])
    calendar_item: List[str] = field(default_factory=lambda: ["details", "title", "patientId"])
    contact: List[str] = field(default_factory=lambda: ["descr", "notes[].markdown"])
    service: List[str] = field(default_factory=lambda: ["notes[].markdown"])
    health_element: List[str] = field(default_factory=lambda: ["descr", "note", "notes[].markdown"])
    maintenance_task: List[str] = field(default_factory=lambda: ["properties"])
    patient: List[str] = field(default_factory=lambda: ["note", "notes[].markdown"])
    message: List[str] = field(default_factory=lambda: ["subject"])
    topic: List[str] = field(default_factory=lambda: ["description", "linkedServices", "linkedHealthElements"])
    document: List[str] = field(default_factory=lambda: [])
    form: List[str] = field(default_factory=lambda: [])
    receipt: List[str] = field(default_factory=lambda: [])
    classification: List[str] = field(default_factory=lambda: [])
    time_table: List[str] = field(default_factory=lambda: [])
    invoice: List[str] = field(default_factory=lambda: [])


@dataclass
class SdkOptions:
    encrypted_fields: EncryptedFieldsConfiguration = field(default_factory=EncryptedFieldsConfiguration)
    disable_parent_keys_initialisation: bool = False
    create_transfer_keys: bool = True
    key_storage: Optional[StorageOptions] = None
    salt_password_with_application_id: bool = True
    crypto_strategies: Optional[CryptoStrategies] = None
    json_patcher: Optional[JsonPatcher] = None


def _serialize_encrypted_fields(fields: EncryptedFieldsConfiguration):
    return {
        'accessLog': fields.access_log,
        'calendarItem': fields.calendar_item,
        'contact': fields.contact,
        'service': fields.service,
        'healthElement': fields.health_element,
        'maintenanceTask': fields.maintenance_task,
        'patient': fields.patient,
        'message': fields.message,
        'topic': fields.topic,
        'document': fields.document,
        'form': fields.form,
        'receipt': fields.receipt,
        'classification': fields.classification,
        'timeTable': fields.time_table,
        'invoice': fields.invoice,
    }