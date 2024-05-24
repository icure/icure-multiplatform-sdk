// auto-generated file
import {StateToUpdate} from './StateToUpdate.mjs';


export class State {

  name: string;

  stateToUpdate: StateToUpdate;

  canLaunchLauncher: boolean = false;

  constructor(partial: Partial<State> & Pick<State, "name" | "stateToUpdate">) {
    this.name = partial.name;
    this.stateToUpdate = partial.stateToUpdate;
    if ('canLaunchLauncher' in partial && partial.canLaunchLauncher !== undefined) this.canLaunchLauncher = partial.canLaunchLauncher;
  }

}
