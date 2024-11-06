// auto-generated file
import {CodeIdentification} from './CodeIdentification.mjs';


export class CodeStub implements CodeIdentification<string | undefined> {

	id: string | undefined = undefined;

	context: string | undefined = undefined;

	type: string | undefined = undefined;

	code: string | undefined = undefined;

	version: string | undefined = undefined;

	contextLabel: string | undefined = undefined;

	label: { [ key: string ]: string } | undefined = undefined;

	constructor(partial: Partial<CodeStub>) {
		if ('id' in partial) this.id = partial.id;
		if ('context' in partial) this.context = partial.context;
		if ('type' in partial) this.type = partial.type;
		if ('code' in partial) this.code = partial.code;
		if ('version' in partial) this.version = partial.version;
		if ('contextLabel' in partial) this.contextLabel = partial.contextLabel;
		if ('label' in partial) this.label = partial.label;
	}

}
