from kotlin_types import symbols
from typing import Optional
from concurrent.futures import Executor
from api import DataOwnerApi, IcureMaintenanceTaskApi, AccessLogApi, CalendarItemApi, ClassificationApi, ContactApi, \
    DocumentApi, FormApi, HealthcareElementApi, InvoiceApi, MaintenanceTaskApi, MessageApi, PatientApi, ReceiptApi, \
    TimeTableApi, TopicApi, ApplicationSettingsApi, CodeApi, CryptoApi, DeviceApi, DocumentTemplateApi, \
    EntityReferenceApi, EntityTemplateApi, FrontEndMigrationApi, GroupApi, HealthcarePartyApi, ICureApi, InsuranceApi, \
    KeywordApi, PermissionApi, PlaceApi, RecoveryApi, RoleApi, TarificationApi, UserApi


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

    def __init__(
        self,
        baseurl: str,
        username: str,
        password: str,
        executor: Optional[Executor] = None
    ):
        self._native = symbols.kotlin.root.com.icure.sdk.py.initializeSdk(
            baseurl.encode('utf-8'),
            username.encode('utf-8'),
            password.encode('utf-8'),
        )
        self._executor = executor

    def __del__(self):
        symbols.DisposeStablePointer(self._native.pinned)

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

