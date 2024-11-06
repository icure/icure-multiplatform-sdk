// auto-generated file

export class ShamirUpdateRequest {

	notariesIds: Array<string>;

	minShares: number;

	constructor(partial: Partial<ShamirUpdateRequest> & Pick<ShamirUpdateRequest, "notariesIds" | "minShares">) {
		this.notariesIds = partial.notariesIds;
		this.minShares = partial.minShares;
	}

}
