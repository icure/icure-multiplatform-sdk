// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {ContractChangeType} from './ContractChangeType.mjs';
import {Encryptable} from './Encryptable.mjs';
import {MhcSignatureType} from './MhcSignatureType.mjs';
import {SuspensionReason} from './SuspensionReason.mjs';


export interface MedicalHouseContract extends Encryptable {

  contractId: string | undefined;

  validFrom: number | undefined;

  validTo: number | undefined;

  mmNihii: string | undefined;

  hcpId: string | undefined;

  changeType: ContractChangeType | undefined;

  parentContractId: string | undefined;

  changedBy: string | undefined;

  startOfContract: number | undefined;

  startOfCoverage: number | undefined;

  endOfContract: number | undefined;

  endOfCoverage: number | undefined;

  kine: boolean;

  gp: boolean;

  ptd: boolean;

  nurse: boolean;

  noKine: boolean;

  noGp: boolean;

  noNurse: boolean;

  unsubscriptionReasonId: number | undefined;

  ptdStart: number | undefined;

  ptdEnd: number | undefined;

  ptdLastInvoiced: number | undefined;

  startOfSuspension: number | undefined;

  endOfSuspension: number | undefined;

  suspensionReason: SuspensionReason | undefined;

  suspensionSource: string | undefined;

  forcedSuspension: boolean;

  signatureType: MhcSignatureType | undefined;

  status: number | undefined;

  options: { [ key: string ]: string };

  receipts: { [ key: string ]: string };

  readonly isEncrypted: boolean;

}

export class DecryptedMedicalHouseContract {

  contractId: string | undefined = undefined;

  validFrom: number | undefined = undefined;

  validTo: number | undefined = undefined;

  mmNihii: string | undefined = undefined;

  hcpId: string | undefined = undefined;

  changeType: ContractChangeType | undefined = undefined;

  parentContractId: string | undefined = undefined;

  changedBy: string | undefined = undefined;

  startOfContract: number | undefined = undefined;

  startOfCoverage: number | undefined = undefined;

  endOfContract: number | undefined = undefined;

  endOfCoverage: number | undefined = undefined;

  kine: boolean = false;

  gp: boolean = false;

  ptd: boolean = false;

  nurse: boolean = false;

  noKine: boolean = false;

  noGp: boolean = false;

  noNurse: boolean = false;

  unsubscriptionReasonId: number | undefined = undefined;

  ptdStart: number | undefined = undefined;

  ptdEnd: number | undefined = undefined;

  ptdLastInvoiced: number | undefined = undefined;

  startOfSuspension: number | undefined = undefined;

  endOfSuspension: number | undefined = undefined;

  suspensionReason: SuspensionReason | undefined = undefined;

  suspensionSource: string | undefined = undefined;

  forcedSuspension: boolean = false;

  signatureType: MhcSignatureType | undefined = undefined;

  status: number | undefined = undefined;

  options: { [ key: string ]: string } = {};

  receipts: { [ key: string ]: string } = {};

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedMedicalHouseContract' = 'com.icure.sdk.model.embed.DecryptedMedicalHouseContract';

  constructor(partial: Partial<DecryptedMedicalHouseContract>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('contractId' in partial) this.contractId = partial.contractId;
    if ('validFrom' in partial) this.validFrom = partial.validFrom;
    if ('validTo' in partial) this.validTo = partial.validTo;
    if ('mmNihii' in partial) this.mmNihii = partial.mmNihii;
    if ('hcpId' in partial) this.hcpId = partial.hcpId;
    if ('changeType' in partial) this.changeType = partial.changeType;
    if ('parentContractId' in partial) this.parentContractId = partial.parentContractId;
    if ('changedBy' in partial) this.changedBy = partial.changedBy;
    if ('startOfContract' in partial) this.startOfContract = partial.startOfContract;
    if ('startOfCoverage' in partial) this.startOfCoverage = partial.startOfCoverage;
    if ('endOfContract' in partial) this.endOfContract = partial.endOfContract;
    if ('endOfCoverage' in partial) this.endOfCoverage = partial.endOfCoverage;
    if ('kine' in partial && partial.kine !== undefined) this.kine = partial.kine;
    if ('gp' in partial && partial.gp !== undefined) this.gp = partial.gp;
    if ('ptd' in partial && partial.ptd !== undefined) this.ptd = partial.ptd;
    if ('nurse' in partial && partial.nurse !== undefined) this.nurse = partial.nurse;
    if ('noKine' in partial && partial.noKine !== undefined) this.noKine = partial.noKine;
    if ('noGp' in partial && partial.noGp !== undefined) this.noGp = partial.noGp;
    if ('noNurse' in partial && partial.noNurse !== undefined) this.noNurse = partial.noNurse;
    if ('unsubscriptionReasonId' in partial) this.unsubscriptionReasonId = partial.unsubscriptionReasonId;
    if ('ptdStart' in partial) this.ptdStart = partial.ptdStart;
    if ('ptdEnd' in partial) this.ptdEnd = partial.ptdEnd;
    if ('ptdLastInvoiced' in partial) this.ptdLastInvoiced = partial.ptdLastInvoiced;
    if ('startOfSuspension' in partial) this.startOfSuspension = partial.startOfSuspension;
    if ('endOfSuspension' in partial) this.endOfSuspension = partial.endOfSuspension;
    if ('suspensionReason' in partial) this.suspensionReason = partial.suspensionReason;
    if ('suspensionSource' in partial) this.suspensionSource = partial.suspensionSource;
    if ('forcedSuspension' in partial && partial.forcedSuspension !== undefined) this.forcedSuspension = partial.forcedSuspension;
    if ('signatureType' in partial) this.signatureType = partial.signatureType;
    if ('status' in partial) this.status = partial.status;
    if ('options' in partial && partial.options !== undefined) this.options = partial.options;
    if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedMedicalHouseContract {

  contractId: string | undefined = undefined;

  validFrom: number | undefined = undefined;

  validTo: number | undefined = undefined;

  mmNihii: string | undefined = undefined;

  hcpId: string | undefined = undefined;

  changeType: ContractChangeType | undefined = undefined;

  parentContractId: string | undefined = undefined;

  changedBy: string | undefined = undefined;

  startOfContract: number | undefined = undefined;

  startOfCoverage: number | undefined = undefined;

  endOfContract: number | undefined = undefined;

  endOfCoverage: number | undefined = undefined;

  kine: boolean = false;

  gp: boolean = false;

  ptd: boolean = false;

  nurse: boolean = false;

  noKine: boolean = false;

  noGp: boolean = false;

  noNurse: boolean = false;

  unsubscriptionReasonId: number | undefined = undefined;

  ptdStart: number | undefined = undefined;

  ptdEnd: number | undefined = undefined;

  ptdLastInvoiced: number | undefined = undefined;

  startOfSuspension: number | undefined = undefined;

  endOfSuspension: number | undefined = undefined;

  suspensionReason: SuspensionReason | undefined = undefined;

  suspensionSource: string | undefined = undefined;

  forcedSuspension: boolean = false;

  signatureType: MhcSignatureType | undefined = undefined;

  status: number | undefined = undefined;

  options: { [ key: string ]: string } = {};

  receipts: { [ key: string ]: string } = {};

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedMedicalHouseContract' = 'com.icure.sdk.model.embed.EncryptedMedicalHouseContract';

  constructor(partial: Partial<EncryptedMedicalHouseContract>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('contractId' in partial) this.contractId = partial.contractId;
    if ('validFrom' in partial) this.validFrom = partial.validFrom;
    if ('validTo' in partial) this.validTo = partial.validTo;
    if ('mmNihii' in partial) this.mmNihii = partial.mmNihii;
    if ('hcpId' in partial) this.hcpId = partial.hcpId;
    if ('changeType' in partial) this.changeType = partial.changeType;
    if ('parentContractId' in partial) this.parentContractId = partial.parentContractId;
    if ('changedBy' in partial) this.changedBy = partial.changedBy;
    if ('startOfContract' in partial) this.startOfContract = partial.startOfContract;
    if ('startOfCoverage' in partial) this.startOfCoverage = partial.startOfCoverage;
    if ('endOfContract' in partial) this.endOfContract = partial.endOfContract;
    if ('endOfCoverage' in partial) this.endOfCoverage = partial.endOfCoverage;
    if ('kine' in partial && partial.kine !== undefined) this.kine = partial.kine;
    if ('gp' in partial && partial.gp !== undefined) this.gp = partial.gp;
    if ('ptd' in partial && partial.ptd !== undefined) this.ptd = partial.ptd;
    if ('nurse' in partial && partial.nurse !== undefined) this.nurse = partial.nurse;
    if ('noKine' in partial && partial.noKine !== undefined) this.noKine = partial.noKine;
    if ('noGp' in partial && partial.noGp !== undefined) this.noGp = partial.noGp;
    if ('noNurse' in partial && partial.noNurse !== undefined) this.noNurse = partial.noNurse;
    if ('unsubscriptionReasonId' in partial) this.unsubscriptionReasonId = partial.unsubscriptionReasonId;
    if ('ptdStart' in partial) this.ptdStart = partial.ptdStart;
    if ('ptdEnd' in partial) this.ptdEnd = partial.ptdEnd;
    if ('ptdLastInvoiced' in partial) this.ptdLastInvoiced = partial.ptdLastInvoiced;
    if ('startOfSuspension' in partial) this.startOfSuspension = partial.startOfSuspension;
    if ('endOfSuspension' in partial) this.endOfSuspension = partial.endOfSuspension;
    if ('suspensionReason' in partial) this.suspensionReason = partial.suspensionReason;
    if ('suspensionSource' in partial) this.suspensionSource = partial.suspensionSource;
    if ('forcedSuspension' in partial && partial.forcedSuspension !== undefined) this.forcedSuspension = partial.forcedSuspension;
    if ('signatureType' in partial) this.signatureType = partial.signatureType;
    if ('status' in partial) this.status = partial.status;
    if ('options' in partial && partial.options !== undefined) this.options = partial.options;
    if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}
