import {AccessLogApi} from "../api/flavoured/AccessLogApi.mjs";
import {CalendarItemApi} from "../api/flavoured/CalendarItemApi.mjs";
import {ClassificationApi} from "../api/flavoured/ClassificationApi.mjs";
import {ContactApi} from "../api/flavoured/ContactApi.mjs";
import {DeviceApi} from "../api/DeviceApi.mjs";
import {DocumentApi} from "../api/flavoured/DocumentApi.mjs";
import {FormApi} from "../api/flavoured/FormApi.mjs";
import {HealthElementApi} from "../api/flavoured/HealthElementApi.mjs";
import {InvoiceApi} from "../api/flavoured/InvoiceApi.mjs";
import {MaintenanceTaskApi} from "../api/flavoured/MaintenanceTaskApi.mjs";
import {MessageApi} from "../api/flavoured/MessageApi.mjs";
import {PatientApi} from "../api/flavoured/PatientApi.mjs";
import {PermissionApi} from "../api/PermissionApi.mjs";
import {ReceiptApi} from "../api/flavoured/ReceiptApi.mjs";
import {TimeTableApi} from "../api/flavoured/TimeTableApi.mjs";
import {TopicApi} from "../api/flavoured/TopicApi.mjs";
import {CryptoApi} from "../api/CryptoApi.mjs";
import {DataOwnerApi} from "../api/extended/DataOwnerApi.mjs";
import {UserApi} from "../api/UserApi.mjs";
import {IcureMaintenanceTaskApi} from "../api/extended/IcureMaintenanceTaskApi.mjs";
import {RecoveryApi} from "../api/RecoveryApi.mjs";
import {AuthenticationMethod} from "../options/AuthenticationMethod.mjs";
import {StorageFacade} from "../storage/StorageFacade.mjs";
import {IcureStorageOptions, InternalSdkInitializers} from "../icure-sdk-ts.mjs";
import {ApiOptions} from "../options/ApiOptions.mjs";

export interface IcureSdk{
  readonly accessLog: AccessLogApi
  readonly calendarItem: CalendarItemApi
  readonly classification: ClassificationApi
  readonly contact: ContactApi
  readonly device: DeviceApi
  readonly document: DocumentApi
  readonly form: FormApi
  readonly healthcareElement: HealthElementApi
  readonly invoice: InvoiceApi
  readonly maintenanceTask: MaintenanceTaskApi
  readonly message: MessageApi
  readonly patient: PatientApi
  readonly permission: PermissionApi
  readonly receipt: ReceiptApi
  readonly timeTable: TimeTableApi
  readonly topic: TopicApi
  readonly crypto: CryptoApi
  readonly dataOwner: DataOwnerApi
  readonly user: UserApi
  readonly icureMaintenanceTask: IcureMaintenanceTaskApi
  readonly recovery: RecoveryApi

  /**
   * Get a new sdk using the same configurations and user authentication methods but for a different group.
   * To use this method, the authentication method provided at initialization of this sdk must be valid also for the
   * new group.
   *
   * @param groupId the id of the new group to switch to
   * @return a new sdk for executing requests in the provided group
   */
  switchGroup(groupId: String): Promise<IcureSdk>
}

export namespace IcureSdk {
  /**
   * Initialize a new instance of the icure sdk for a specific user.
   *
   * @param applicationId a string to uniquely identify your iCure application.
   * @param baseUrl the url of the iCure backend to use
   * @param authenticationMethod specifies how the sdk should authenticate.
   * @param baseStorage an implementation of {@link StorageFacade} or standard icure storage options, used for persistent
   * storage of various information including the user keys if {@link ApiOptions.keyStorage}1 is not provided.
   * @param options optional parameters for the initialization of the sdk.
   */
  export async function initialize(
    applicationId: string | undefined,
    baseUrl: string,
    authenticationMethod: AuthenticationMethod,
    baseStorage: StorageFacade | IcureStorageOptions,
    options?: ApiOptions
  ): Promise<IcureSdk> {
    return await InternalSdkInitializers.getInstance().initializeSdk(
      applicationId,
      baseUrl,
      authenticationMethod,
      baseStorage,
      options
    )
  }
}