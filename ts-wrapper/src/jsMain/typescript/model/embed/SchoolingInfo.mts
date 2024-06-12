// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';


export class SchoolingInfo {

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  school: string | undefined = undefined;

  typeOfEducation: CodeStub | undefined = undefined;

  constructor(partial: Partial<SchoolingInfo>) {
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('school' in partial) this.school = partial.school;
    if ('typeOfEducation' in partial) this.typeOfEducation = partial.typeOfEducation;
  }

}
