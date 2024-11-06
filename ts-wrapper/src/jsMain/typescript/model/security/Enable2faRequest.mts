// auto-generated file

export class Enable2faRequest {

	secret: string;

	otpLength: number;

	constructor(partial: Partial<Enable2faRequest> & Pick<Enable2faRequest, "secret" | "otpLength">) {
		this.secret = partial.secret;
		this.otpLength = partial.otpLength;
	}

}
