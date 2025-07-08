// auto-generated file
import {HealthcareParty} from './HealthcareParty.mjs';
import {User} from './User.mjs';


export class UserAndHealthcareParty {

	user: User;

	healthcareParty: HealthcareParty;

	constructor(partial: Partial<UserAndHealthcareParty> & Pick<UserAndHealthcareParty, "user" | "healthcareParty">) {
		this.user = partial.user;
		this.healthcareParty = partial.healthcareParty;
	}

}
