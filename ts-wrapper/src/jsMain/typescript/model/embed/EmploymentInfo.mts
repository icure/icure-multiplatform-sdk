// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {Employer} from './Employer.mjs';


export class EmploymentInfo {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	professionType: CodeStub | undefined = undefined;

	employer: Employer | undefined = undefined;

	constructor(partial: Partial<EmploymentInfo>) {
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('professionType' in partial) this.professionType = partial.professionType;
		if ('employer' in partial) this.employer = partial.employer;
	}

}
