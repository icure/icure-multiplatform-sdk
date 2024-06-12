// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';


export class AdministrationQuantity {

  quantity: number | undefined = undefined;

  administrationUnit: CodeStub | undefined = undefined;

  unit: string | undefined = undefined;

  constructor(partial: Partial<AdministrationQuantity>) {
    if ('quantity' in partial) this.quantity = partial.quantity;
    if ('administrationUnit' in partial) this.administrationUnit = partial.administrationUnit;
    if ('unit' in partial) this.unit = partial.unit;
  }

}
