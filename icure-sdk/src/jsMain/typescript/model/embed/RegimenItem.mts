// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {AdministrationQuantity} from './AdministrationQuantity.mjs';
import {Weekday} from './Weekday.mjs';


export class RegimenItem {

  date: number | undefined = undefined;

  dayNumber: number | undefined = undefined;

  weekday: Weekday | undefined = undefined;

  dayPeriod: CodeStub | undefined = undefined;

  timeOfDay: number | undefined = undefined;

  administratedQuantity: AdministrationQuantity | undefined = undefined;

  constructor(partial: Partial<RegimenItem>) {
    if ('date' in partial) this.date = partial.date;
    if ('dayNumber' in partial) this.dayNumber = partial.dayNumber;
    if ('weekday' in partial) this.weekday = partial.weekday;
    if ('dayPeriod' in partial) this.dayPeriod = partial.dayPeriod;
    if ('timeOfDay' in partial) this.timeOfDay = partial.timeOfDay;
    if ('administratedQuantity' in partial) this.administratedQuantity = partial.administratedQuantity;
  }

}
