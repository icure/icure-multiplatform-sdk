// auto-generated file
import {Code} from '../../Code.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class CodeByRegionTypeLabelLanguageFilter implements AbstractFilter<Code> {

  desc: string | undefined = undefined;

  region: string | undefined = undefined;

  type: string;

  language: string;

  label: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter' = 'com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter';

  constructor(partial: Partial<CodeByRegionTypeLabelLanguageFilter> & Pick<CodeByRegionTypeLabelLanguageFilter, "type" | "language">) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('region' in partial) this.region = partial.region;
    this.type = partial.type;
    this.language = partial.language;
    if ('label' in partial) this.label = partial.label;
  }

}
