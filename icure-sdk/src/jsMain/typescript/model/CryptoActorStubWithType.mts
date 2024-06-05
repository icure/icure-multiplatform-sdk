// auto-generated file
import {CryptoActorStub} from './CryptoActorStub.mjs';
import {DataOwnerType} from './DataOwnerType.mjs';


export class CryptoActorStubWithType {

  type: DataOwnerType;

  stub: CryptoActorStub;

  constructor(partial: Partial<CryptoActorStubWithType> & Pick<CryptoActorStubWithType, "type" | "stub">) {
    this.type = partial.type;
    this.stub = partial.stub;
  }

}
