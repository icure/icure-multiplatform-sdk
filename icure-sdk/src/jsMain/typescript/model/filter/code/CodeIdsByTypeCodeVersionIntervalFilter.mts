// auto-generated file
import {Code} from '../../Code.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class CodeIdsByTypeCodeVersionIntervalFilter implements AbstractFilter<Code> {

  desc: string | undefined = undefined;

  startType: string | undefined = undefined;

  startCode: string | undefined = undefined;

  startVersion: string | undefined = undefined;

  endType: string | undefined = undefined;

  endCode: string | undefined = undefined;

  endVersion: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter' = 'com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter';

  constructor(partial: Partial<CodeIdsByTypeCodeVersionIntervalFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('startType' in partial) this.startType = partial.startType;
    if ('startCode' in partial) this.startCode = partial.startCode;
    if ('startVersion' in partial) this.startVersion = partial.startVersion;
    if ('endType' in partial) this.endType = partial.endType;
    if ('endCode' in partial) this.endCode = partial.endCode;
    if ('endVersion' in partial) this.endVersion = partial.endVersion;
  }

}
