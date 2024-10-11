// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {ReferenceRange} from './ReferenceRange.mjs';


export class Measure {

	value: number | undefined = undefined;

	ref: number | undefined = undefined;

	severity: number | undefined = undefined;

	severityCode: string | undefined = undefined;

	evolution: number | undefined = undefined;

	unit: string | undefined = undefined;

	unitCodes: Array<CodeStub> | undefined = undefined;

	comment: string | undefined = undefined;

	comparator: string | undefined = undefined;

	sign: string | undefined = undefined;

	referenceRanges: Array<ReferenceRange> = [];

	constructor(partial: Partial<Measure>) {
		if ('value' in partial) this.value = partial.value;
		if ('ref' in partial) this.ref = partial.ref;
		if ('severity' in partial) this.severity = partial.severity;
		if ('severityCode' in partial) this.severityCode = partial.severityCode;
		if ('evolution' in partial) this.evolution = partial.evolution;
		if ('unit' in partial) this.unit = partial.unit;
		if ('unitCodes' in partial) this.unitCodes = partial.unitCodes;
		if ('comment' in partial) this.comment = partial.comment;
		if ('comparator' in partial) this.comparator = partial.comparator;
		if ('sign' in partial) this.sign = partial.sign;
		if ('referenceRanges' in partial && partial.referenceRanges !== undefined) this.referenceRanges = partial.referenceRanges;
	}

}
