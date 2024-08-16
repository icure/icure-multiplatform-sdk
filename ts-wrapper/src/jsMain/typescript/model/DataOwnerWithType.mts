// auto-generated file
import {Device} from './Device.mjs';
import {HealthcareParty} from './HealthcareParty.mjs';
import {EncryptedPatient} from './Patient.mjs';


export type DataOwnerWithType = DataOwnerWithType.HcpDataOwner | DataOwnerWithType.PatientDataOwner | DataOwnerWithType.DeviceDataOwner;

export namespace DataOwnerWithType {

	export class HcpDataOwner {

		dataOwner: HealthcareParty;

		readonly $ktClass: 'com.icure.sdk.model.DataOwnerWithType.HcpDataOwner' = 'com.icure.sdk.model.DataOwnerWithType.HcpDataOwner';

		constructor(partial: Partial<HcpDataOwner> & Pick<HcpDataOwner, "dataOwner">) {
			this.dataOwner = partial.dataOwner;
		}

	}

	export class PatientDataOwner {

		dataOwner: EncryptedPatient;

		readonly $ktClass: 'com.icure.sdk.model.DataOwnerWithType.PatientDataOwner' = 'com.icure.sdk.model.DataOwnerWithType.PatientDataOwner';

		constructor(partial: Partial<PatientDataOwner> & Pick<PatientDataOwner, "dataOwner">) {
			this.dataOwner = partial.dataOwner;
		}

	}

	export class DeviceDataOwner {

		dataOwner: Device;

		readonly $ktClass: 'com.icure.sdk.model.DataOwnerWithType.DeviceDataOwner' = 'com.icure.sdk.model.DataOwnerWithType.DeviceDataOwner';

		constructor(partial: Partial<DeviceDataOwner> & Pick<DeviceDataOwner, "dataOwner">) {
			this.dataOwner = partial.dataOwner;
		}

	}

}
