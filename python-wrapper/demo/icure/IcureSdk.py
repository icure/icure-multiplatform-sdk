import json
from icure.kotlin_types import symbols
from typing import Optional, Union, List
from ctypes import CFUNCTYPE, c_void_p, c_char_p, cast
from concurrent.futures import Executor
from icure.storage import FileSystemStorage
from icure.authentication import UsernamePassword
from icure.api import DataOwnerApi, IcureMaintenanceTaskApi, AccessLogApi, CalendarItemApi, ClassificationApi, ContactApi, \
    DocumentApi, FormApi, HealthcareElementApi, InvoiceApi, MaintenanceTaskApi, MessageApi, PatientApi, ReceiptApi, \
    TimeTableApi, TopicApi, ApplicationSettingsApi, CodeApi, CryptoApi, DeviceApi, DocumentTemplateApi, \
    EntityReferenceApi, EntityTemplateApi, FrontEndMigrationApi, GroupApi, HealthcarePartyApi, ICureApi, InsuranceApi, \
    KeywordApi, PermissionApi, PlaceApi, RecoveryApi, RoleApi, TarificationApi, UserApi
from dataclasses import dataclass, field
import traceback
from icure.model.CallResult import create_result_from_json
from icure.model import deserialize_recovery_result, RecoveryResultFailure, deserialize_data_owner_with_type, CryptoActorStubWithType
from icure.CryptoStrategies import CryptoStrategies, ExportedKeyData, KeyDataRecoveryRequest, RecoveredKeyData, serialize_key_generation_request_result

@dataclass
class EncryptedFieldsConfiguration:
    accessLog: List[str] = field(default_factory=lambda: ["detail", "objectId"])
    calendarItem: List[str] = field(default_factory=lambda: ["details", "title", "patientId"])
    contact: List[str] = field(default_factory=lambda: ["descr", "notes[].markdown"])
    service: List[str] = field(default_factory=lambda: ["notes[].markdown"])
    healthElement: List[str] = field(default_factory=lambda: ["descr", "note", "notes[].markdown"])
    maintenanceTask: List[str] = field(default_factory=lambda: ["properties"])
    patient: List[str] = field(default_factory=lambda: ["note", "notes[].markdown"])
    message: List[str] = field(default_factory=lambda: [])
    topic: List[str] = field(default_factory=lambda: ["description", "linkedServices", "linkedHealthElements"])
    document: List[str] = field(default_factory=lambda: [])
    form: List[str] = field(default_factory=lambda: [])
    receipt: List[str] = field(default_factory=lambda: [])
    classification: List[str] = field(default_factory=lambda: [])
    timeTable: List[str] = field(default_factory=lambda: [])
    invoice: List[str] = field(default_factory=lambda: [])


@dataclass
class SdkOptions:
    encryptedFields: EncryptedFieldsConfiguration = field(default_factory=EncryptedFieldsConfiguration)
    disableParentKeysInitialisation: bool = False
    createTransferKeys: bool = True


class _CryptoStrategiesBridge:
    __py_strategies: CryptoStrategies

    def __init__(self, py_strategies: CryptoStrategies):
        self.__py_strategies = py_strategies

    def recover_and_verify_self_hierarchy_keys(self, result_holder, keys_data, key_pair_recoverer):
        try:
            keys_data_json = json.loads(cast(keys_data, c_char_p).value.decode('utf-8'))
            def use_key_pair_recover(recovery_key, auto_delete):
                result_bytes = symbols.kotlin.root.com.icure.sdk.py.PyCryptoStrategies.recoverWithRecoveryKey(
                    key_pair_recoverer,
                    recovery_key.encode('utf-8'),
                    auto_delete
                )
                result = create_result_from_json(cast(result_bytes, c_char_p).value.decode('utf-8'))
                symbols.DisposeString(result_bytes)
                if result.failure is not None:
                    raise Exception(result.failure)
                recovery_result = deserialize_recovery_result(result.success)
                if isinstance(recovery_result, RecoveryResultFailure):
                    return recovery_result.reason
                return {
                    k: {
                        k1: ExportedKeyData._deserialize(v1) for k1, v1 in v.items()
                    } for k, v in recovery_result.data.items()
                }
            result = self.__py_strategies.recover_and_verify_self_hierarchy_keys(
                [KeyDataRecoveryRequest._deserialize(x) for x in keys_data_json],
                use_key_pair_recover
            )
            result_json = {
                k: v.__serialize__() for k, v in result.items()
            }
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result_json).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def generate_new_key_for_data_owner(self, result_holder, self_data_owner):
        try:
            result = self.__py_strategies.generate_new_key_for_data_owner(
                deserialize_data_owner_with_type(cast(self_data_owner, c_char_p).value.decode('utf-8'))
            )
            result_json = serialize_key_generation_request_result(result)
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result_json).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))

    def verify_delegate_public_keys(self, result_holder, delegate, public_keys):
        try:
            result = self.__py_strategies.verify_delegate_public_keys(
                CryptoActorStubWithType._deserialize(cast(delegate, c_char_p).value.decode('utf-8')),
                json.loads(cast(public_keys, c_char_p).value.decode('utf-8'))
            )
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc())

    def data_owner_requires_anonymous_delegation(self, result_holder, data_owner):
        try:
            result = self.__py_strategies.data_owner_requires_anonymous_delegation(
                CryptoActorStubWithType._deserialize(cast(data_owner, c_char_p).value.decode('utf-8'))
            )
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(result_holder, json.dumps(result).encode('utf-8'))
        except:
            symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(result_holder, traceback.format_exc().encode('utf-8'))


_C_RecoverAndVerifySelfHierarchyKeys = CFUNCTYPE(None, c_void_p, c_char_p, c_void_p)
_C_GenerateNewKeyForDataOwner = CFUNCTYPE(None, c_void_p, c_char_p)
_C_VerifyDelegatePublicKeys = CFUNCTYPE(None, c_void_p, c_char_p, c_char_p)
_C_DataOwnerRequiresAnonymousDelegation = CFUNCTYPE(None, c_void_p, c_char_p)



class IcureSdk:
    __healthcareElement: Optional[HealthcareElementApi] = None
    __dataOwner: Optional[DataOwnerApi] = None
    __icureMaintenanceTask: Optional[IcureMaintenanceTaskApi] = None
    __accessLog: Optional[AccessLogApi] = None
    __calendarItem: Optional[CalendarItemApi] = None
    __classification: Optional[ClassificationApi] = None
    __contact: Optional[ContactApi] = None
    __document: Optional[DocumentApi] = None
    __form: Optional[FormApi] = None
    __invoice: Optional[InvoiceApi] = None
    __maintenanceTask: Optional[MaintenanceTaskApi] = None
    __message: Optional[MessageApi] = None
    __patient: Optional[PatientApi] = None
    __receipt: Optional[ReceiptApi] = None
    __timeTable: Optional[TimeTableApi] = None
    __topic: Optional[TopicApi] = None
    __applicationSettings: Optional[ApplicationSettingsApi] = None
    __code: Optional[CodeApi] = None
    __crypto: Optional[CryptoApi] = None
    __device: Optional[DeviceApi] = None
    __documentTemplate: Optional[DocumentTemplateApi] = None
    __entityReference: Optional[EntityReferenceApi] = None
    __entityTemplate: Optional[EntityTemplateApi] = None
    __frontEndMigration: Optional[FrontEndMigrationApi] = None
    __group: Optional[GroupApi] = None
    __healthcareParty: Optional[HealthcarePartyApi] = None
    __icure: Optional[ICureApi] = None
    __insurance: Optional[InsuranceApi] = None
    __keyword: Optional[KeywordApi] = None
    __permission: Optional[PermissionApi] = None
    __place: Optional[PlaceApi] = None
    __recovery: Optional[RecoveryApi] = None
    __role: Optional[RoleApi] = None
    __tarification: Optional[TarificationApi] = None
    __user: Optional[UserApi] = None
    __CALLBACK_RecoverAndVerifySelfHierarchyKeys: _C_RecoverAndVerifySelfHierarchyKeys
    __CALLBACK_GenerateNewKeyForDataOwner: _C_GenerateNewKeyForDataOwner
    __CALLBACK_VerifyDelegatePublicKeys: _C_VerifyDelegatePublicKeys
    __CALLBACK_DataOwnerRequiresAnonymousDelegation: _C_DataOwnerRequiresAnonymousDelegation
    __kt_crypto_strategies: c_void_p

    def __init__(
        self,
        baseurl: str,
        authentication_method: Union[UsernamePassword],
        storage: Union[FileSystemStorage],
        crypto_strategies: CryptoStrategies,
        options: SdkOptions = SdkOptions(),
        executor: Optional[Executor] = None
    ):
        if not isinstance(authentication_method, UsernamePassword):
            raise Exception(f"Invalid authentication method, expected `icure.authentication.UsernamePassword`, found {type(authentication_method)}")
        if not isinstance(storage, FileSystemStorage):
            raise Exception(f"Invalid storage type, expected `icure.storage.FileSystemStorage`, found {type(storage)}")

        data_params = {
            'baseUrl': baseurl,
            'username': authentication_method.username,
            'password': authentication_method.password,
            'storagePath': storage.directory,
            'encryptedFields': options.encryptedFields.__dict__,
            'disableParentKeysInitialisation': options.disableParentKeysInitialisation,
            'createTransferKeys': options.createTransferKeys
        }

        strategies_bridge = _CryptoStrategiesBridge(crypto_strategies)
        self.__CALLBACK_RecoverAndVerifySelfHierarchyKeys = _C_RecoverAndVerifySelfHierarchyKeys(strategies_bridge.recover_and_verify_self_hierarchy_keys)
        self.__CALLBACK_GenerateNewKeyForDataOwner = _C_GenerateNewKeyForDataOwner(strategies_bridge.generate_new_key_for_data_owner)
        self.__CALLBACK_VerifyDelegatePublicKeys = _C_VerifyDelegatePublicKeys(strategies_bridge.verify_delegate_public_keys)
        self.__CALLBACK_DataOwnerRequiresAnonymousDelegation = _C_DataOwnerRequiresAnonymousDelegation(strategies_bridge.data_owner_requires_anonymous_delegation)
        self.__kt_crypto_strategies = symbols.kotlin.root.com.icure.sdk.py.PyCryptoStrategies.create(
            self.__CALLBACK_RecoverAndVerifySelfHierarchyKeys,
            self.__CALLBACK_GenerateNewKeyForDataOwner,
            self.__CALLBACK_VerifyDelegatePublicKeys,
            self.__CALLBACK_DataOwnerRequiresAnonymousDelegation,
        )

        sdkInitializationResult = symbols.kotlin.root.com.icure.sdk.py.initializeSdk(
            json.dumps(data_params).encode('utf-8'),
            self.__kt_crypto_strategies
        )
        failure = symbols.kotlin.root.com.icure.sdk.py.SdkInitializationResult.get_failure(sdkInitializationResult)
        if failure is not None:
            symbols.DisposeStablePointer(sdkInitializationResult.pinned)
            trace = cast(failure, c_char_p).value.decode('utf-8')
            symbols.DisposeString(failure)
            raise Exception(trace)
        self._native = symbols.kotlin.root.com.icure.sdk.py.SdkInitializationResult.get_success(sdkInitializationResult)
        symbols.DisposeStablePointer(sdkInitializationResult.pinned)
        self._executor = executor

    def __del__(self):
        if self.__dict__.get("_native") is not None:
            symbols.DisposeStablePointer(self._native.pinned)
        if self.__dict__.get("__kt_crypto_strategies") is not None:
            symbols.kotlin.root.com.icure.sdk.py.utils.disposeStablePtr(self.__kt_crypto_strategies)

    @property
    def healthcare_element(self):
        if self.__healthcareElement is None:
            self.__healthcareElement = HealthcareElementApi(self)
        return self.__healthcareElement

    @property
    def data_owner(self):
        if self.__dataOwner is None:
            self.__dataOwner = DataOwnerApi(self)
        return self.__dataOwner

    @property
    def icure_maintenance_task(self):
        if self.__icureMaintenanceTask is None:
            self.__icureMaintenanceTask = IcureMaintenanceTaskApi(self)
        return self.__icureMaintenanceTask

    @property
    def access_log(self):
        if self.__accessLog is None:
            self.__accessLog = AccessLogApi(self)
        return self.__accessLog

    @property
    def calendar_item(self):
        if self.__calendarItem is None:
            self.__calendarItem = CalendarItemApi(self)
        return self.__calendarItem

    @property
    def classification(self):
        if self.__classification is None:
            self.__classification = ClassificationApi(self)
        return self.__classification

    @property
    def contact(self):
        if self.__contact is None:
            self.__contact = ContactApi(self)
        return self.__contact

    @property
    def document(self):
        if self.__document is None:
            self.__document = DocumentApi(self)
        return self.__document

    @property
    def form(self):
        if self.__form is None:
            self.__form = FormApi(self)
        return self.__form

    @property
    def invoice(self):
        if self.__invoice is None:
            self.__invoice = InvoiceApi(self)
        return self.__invoice

    @property
    def maintenance_task(self):
        if self.__maintenanceTask is None:
            self.__maintenanceTask = MaintenanceTaskApi(self)
        return self.__maintenanceTask

    @property
    def message(self):
        if self.__message is None:
            self.__message = MessageApi(self)
        return self.__message

    @property
    def patient(self):
        if self.__patient is None:
            self.__patient = PatientApi(self)
        return self.__patient

    @property
    def receipt(self):
        if self.__receipt is None:
            self.__receipt = ReceiptApi(self)
        return self.__receipt

    @property
    def time_table(self):
        if self.__timeTable is None:
            self.__timeTable = TimeTableApi(self)
        return self.__timeTable

    @property
    def topic(self):
        if self.__topic is None:
            self.__topic = TopicApi(self)
        return self.__topic

    @property
    def application_settings(self):
        if self.__applicationSettings is None:
            self.__applicationSettings = ApplicationSettingsApi(self)
        return self.__applicationSettings

    @property
    def code(self):
        if self.__code is None:
            self.__code = CodeApi(self)
        return self.__code

    @property
    def crypto(self):
        if self.__crypto is None:
            self.__crypto = CryptoApi(self)
        return self.__crypto

    @property
    def device(self):
        if self.__device is None:
            self.__device = DeviceApi(self)
        return self.__device

    @property
    def document_template(self):
        if self.__documentTemplate is None:
            self.__documentTemplate = DocumentTemplateApi(self)
        return self.__documentTemplate

    @property
    def entity_reference(self):
        if self.__entityReference is None:
            self.__entityReference = EntityReferenceApi(self)
        return self.__entityReference

    @property
    def entity_template(self):
        if self.__entityTemplate is None:
            self.__entityTemplate = EntityTemplateApi(self)
        return self.__entityTemplate

    @property
    def front_end_migration(self):
        if self.__frontEndMigration is None:
            self.__frontEndMigration = FrontEndMigrationApi(self)
        return self.__frontEndMigration

    @property
    def group(self):
        if self.__group is None:
            self.__group = GroupApi(self)
        return self.__group

    @property
    def healthcare_party(self):
        if self.__healthcareParty is None:
            self.__healthcareParty = HealthcarePartyApi(self)
        return self.__healthcareParty

    @property
    def icure(self):
        if self.__icure is None:
            self.__icure = ICureApi(self)
        return self.__icure

    @property
    def insurance(self):
        if self.__insurance is None:
            self.__insurance = InsuranceApi(self)
        return self.__insurance

    @property
    def keyword(self):
        if self.__keyword is None:
            self.__keyword = KeywordApi(self)
        return self.__keyword

    @property
    def permission(self):
        if self.__permission is None:
            self.__permission = PermissionApi(self)
        return self.__permission

    @property
    def place(self):
        if self.__place is None:
            self.__place = PlaceApi(self)
        return self.__place

    @property
    def recovery(self):
        if self.__recovery is None:
            self.__recovery = RecoveryApi(self)
        return self.__recovery

    @property
    def role(self):
        if self.__role is None:
            self.__role = RoleApi(self)
        return self.__role

    @property
    def tarification(self):
        if self.__tarification is None:
            self.__tarification = TarificationApi(self)
        return self.__tarification

    @property
    def user(self):
        if self.__user is None:
            self.__user = UserApi(self)
        return self.__user
