// auto-generated file
import {StructureElement} from './StructureElement.mjs';


export class Section {

	section: string;

	fields: Array<StructureElement>;

	description: string | undefined = undefined;

	keywords: Array<string> | undefined = undefined;

	constructor(partial: Partial<Section> & Pick<Section, "section" | "fields">) {
		this.section = partial.section;
		this.fields = partial.fields;
		if ('description' in partial) this.description = partial.description;
		if ('keywords' in partial) this.keywords = partial.keywords;
	}

}
