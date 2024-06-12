// auto-generated file
import {Trigger} from './Trigger.mjs';


export class Launcher {

  name: string;

  triggerer: Trigger;

  shouldPassValue: boolean = false;

  constructor(partial: Partial<Launcher> & Pick<Launcher, "name" | "triggerer">) {
    this.name = partial.name;
    this.triggerer = partial.triggerer;
    if ('shouldPassValue' in partial && partial.shouldPassValue !== undefined) this.shouldPassValue = partial.shouldPassValue;
  }

}
