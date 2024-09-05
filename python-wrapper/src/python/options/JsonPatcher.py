from abc import ABC
from ctypes import CFUNCTYPE, c_char_p, c_void_p, cast
from typing import Optional
from cardinal_sdk.kotlin_types import symbols
import json
import traceback

class JsonPatcher(ABC):
    """
    Provides methods to patch the json representing a certain type of entity after decryption and before validation and
    proper deserialization.
    Each of these methods takes in input the parsed json of the decrypted entity and must return the patched json.
    All the patchers are optional, if you don't override a patcher the json of the entity will be used by the sdk as is,
    without any patching.
    """

    def patch_access_log(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of an AccessLog.
        :param decrypted_json: the parsed decrypted json representation of an AccessLog
        :return: the patched json representation of an AccessLog
        """
        return decrypted_json

    def patch_calendar_item(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a CalendarItem.
        :param decrypted_json: the parsed decrypted json representation of a CalendarItem
        :return: the patched json representation of a CalendarItem
        """
        return decrypted_json

    def patch_contact(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Contact.
        :param decrypted_json: the parsed decrypted json representation of a Contact
        :return: the patched json representation of a Contact
        """
        return decrypted_json

    def patch_individual_service(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Service.
        This method is used only when a service is retrieved by itself, without the rest of the contact.
        Services retrieved as part of a contact should be patched with patchContact
        :param decrypted_json: the parsed decrypted json representation of a Service
        :return: the patched json representation of a Service
        """
        return decrypted_json

    def patch_health_element(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a HealthElement.
        :param decrypted_json: the parsed decrypted json representation of a HealthElement
        :return: the patched json representation of a HealthElement
        """
        return decrypted_json

    def patch_maintenance_task(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a MaintenanceTask.
        :param decrypted_json: the parsed decrypted json representation of a MaintenanceTask
        :return: the patched json representation of a MaintenanceTask
        """
        return decrypted_json

    def patch_patient(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Patient.
        :param decrypted_json: the parsed decrypted json representation of a Patient
        :return: the patched json representation of a Patient
        """
        return decrypted_json

    def patch_message(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Message.
        :param decrypted_json: the parsed decrypted json representation of a Message
        :return: the patched json representation of a Message
        """
        return decrypted_json

    def patch_topic(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Topic.
        :param decrypted_json: the parsed decrypted json representation of a Topic
        :return: the patched json representation of a Topic
        """
        return decrypted_json

    def patch_document(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Document.
        :param decrypted_json: the parsed decrypted json representation of a Document
        :return: the patched json representation of a Document
        """
        return decrypted_json

    def patch_form(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Form.
        :param decrypted_json: the parsed decrypted json representation of a Form
        :return: the patched json representation of a Form
        """
        return decrypted_json

    def patch_receipt(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Receipt.
        :param decrypted_json: the parsed decrypted json representation of a Receipt
        :return: the patched json representation of a Receipt
        """
        return decrypted_json

    def patch_classification(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a Classification.
        :param decrypted_json: the parsed decrypted json representation of a Classification
        :return: the patched json representation of a Classification
        """
        return decrypted_json

    def patch_time_table(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of a TimeTable.
        :param decrypted_json: the parsed decrypted json representation of a TimeTable
        :return: the patched json representation of a TimeTable
        """
        return decrypted_json

    def patch_invoice(self, decrypted_json: dict[str, any]) -> dict[str, any]:
        """
        Patches the decrypted json representation of an Invoice.
        :param decrypted_json: the parsed decrypted json representation of an Invoice
        :return: the patched json representation of an Invoice
        """
        return decrypted_json

_C_PatchFunction = CFUNCTYPE(None, c_void_p, c_char_p)
class _JsonPatcherBridge:
    _CALLBACK_patch_access_log: Optional[_C_PatchFunction]
    _CALLBACK_patch_calendar_item: Optional[_C_PatchFunction]
    _CALLBACK_patch_contact: Optional[_C_PatchFunction]
    _CALLBACK_patch_individual_service: Optional[_C_PatchFunction]
    _CALLBACK_patch_health_element: Optional[_C_PatchFunction]
    _CALLBACK_patch_maintenance_task: Optional[_C_PatchFunction]
    _CALLBACK_patch_patient: Optional[_C_PatchFunction]
    _CALLBACK_patch_message: Optional[_C_PatchFunction]
    _CALLBACK_patch_topic: Optional[_C_PatchFunction]
    _CALLBACK_patch_document: Optional[_C_PatchFunction]
    _CALLBACK_patch_form: Optional[_C_PatchFunction]
    _CALLBACK_patch_receipt: Optional[_C_PatchFunction]
    _CALLBACK_patch_classification: Optional[_C_PatchFunction]
    _CALLBACK_patch_time_table: Optional[_C_PatchFunction]
    _CALLBACK_patch_invoice: Optional[_C_PatchFunction]
    __kt_py_patcher: Optional[c_void_p]

    def __init__(self, py_patcher: JsonPatcher):
        self.__py_patcher = py_patcher
        self.__kt_py_patcher = None

    def __del__(self):
        if self.__kt_py_patcher is not None:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.disposeStablePtr(self.__kt_py_patcher)

    def patch_access_log(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_access_log(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_calendar_item(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_calendar_item(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_contact(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_contact(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_individual_service(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_individual_service(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_health_element(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_health_element(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_maintenance_task(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_maintenance_task(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_patient(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_patient(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_message(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_message(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_topic(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_topic(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_document(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_document(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_form(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_form(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_receipt(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_receipt(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_classification(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_classification(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_time_table(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_time_table(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def patch_invoice(self, result_holder, json_string):
        try:
            result = self.__py_patcher.patch_invoice(json.loads(cast(json_string, c_char_p).value.decode('utf-8')))
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def get_kt(self) -> c_void_p:
        if self.__kt_py_patcher is None:
            py_patcher_class = self.__py_patcher
            self._CALLBACK_patch_access_log = _C_PatchFunction(self.patch_access_log) if getattr(JsonPatcher, 'patch_access_log', None) != getattr(py_patcher_class, 'patch_access_log', None) else None
            self._CALLBACK_patch_calendar_item = _C_PatchFunction(self.patch_calendar_item) if getattr(JsonPatcher, 'patch_calendar_item', None) != getattr(py_patcher_class, 'patch_calendar_item', None) else None
            self._CALLBACK_patch_contact = _C_PatchFunction(self.patch_contact) if getattr(JsonPatcher, 'patch_contact', None) != getattr(py_patcher_class, 'patch_contact', None) else None
            self._CALLBACK_patch_individual_service = _C_PatchFunction(self.patch_individual_service) if getattr(JsonPatcher, 'patch_individual_service', None) != getattr(py_patcher_class, 'patch_individual_service', None) else None
            self._CALLBACK_patch_health_element = _C_PatchFunction(self.patch_health_element) if getattr(JsonPatcher, 'patch_health_element', None) != getattr(py_patcher_class, 'patch_health_element', None) else None
            self._CALLBACK_patch_maintenance_task = _C_PatchFunction(self.patch_maintenance_task) if getattr(JsonPatcher, 'patch_maintenance_task', None) != getattr(py_patcher_class, 'patch_maintenance_task', None) else None
            self._CALLBACK_patch_patient = _C_PatchFunction(self.patch_patient) if getattr(JsonPatcher, 'patch_patient', None) != getattr(py_patcher_class, 'patch_patient', None) else None
            self._CALLBACK_patch_message = _C_PatchFunction(self.patch_message) if getattr(JsonPatcher, 'patch_message', None) != getattr(py_patcher_class, 'patch_message', None) else None
            self._CALLBACK_patch_topic = _C_PatchFunction(self.patch_topic) if getattr(JsonPatcher, 'patch_topic', None) != getattr(py_patcher_class, 'patch_topic', None) else None
            self._CALLBACK_patch_document = _C_PatchFunction(self.patch_document) if getattr(JsonPatcher, 'patch_document', None) != getattr(py_patcher_class, 'patch_document', None) else None
            self._CALLBACK_patch_form = _C_PatchFunction(self.patch_form) if getattr(JsonPatcher, 'patch_form', None) != getattr(py_patcher_class, 'patch_form', None) else None
            self._CALLBACK_patch_receipt = _C_PatchFunction(self.patch_receipt) if getattr(JsonPatcher, 'patch_receipt', None) != getattr(py_patcher_class, 'patch_receipt', None) else None
            self._CALLBACK_patch_classification = _C_PatchFunction(self.patch_classification) if getattr(JsonPatcher, 'patch_classification', None) != getattr(py_patcher_class, 'patch_classification', None) else None
            self._CALLBACK_patch_time_table = _C_PatchFunction(self.patch_time_table) if getattr(JsonPatcher, 'patch_time_table', None) != getattr(py_patcher_class, 'patch_time_table', None) else None
            self._CALLBACK_patch_invoice = _C_PatchFunction(self.patch_invoice) if getattr(JsonPatcher, 'patch_invoice', None) != getattr(py_patcher_class, 'patch_invoice', None) else None
            self.__kt_py_patcher = symbols.kotlin.root.com.icure.cardinal.sdk.py.options.PyJsonPatcher.createJsonPatcher(
                self._CALLBACK_patch_access_log,
                self._CALLBACK_patch_calendar_item,
                self._CALLBACK_patch_contact,
                self._CALLBACK_patch_individual_service,
                self._CALLBACK_patch_health_element,
                self._CALLBACK_patch_maintenance_task,
                self._CALLBACK_patch_patient,
                self._CALLBACK_patch_message,
                self._CALLBACK_patch_topic,
                self._CALLBACK_patch_document,
                self._CALLBACK_patch_form,
                self._CALLBACK_patch_receipt,
                self._CALLBACK_patch_classification,
                self._CALLBACK_patch_time_table,
                self._CALLBACK_patch_invoice,
            )
        return self.__kt_py_patcher
