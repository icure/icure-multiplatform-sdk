// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {View} from './View.mjs';


export class DesignDocument {

	id: string;

	rev: string | undefined = undefined;

	revHistory: { [ key: string ]: string } = {};

	language: string | undefined = undefined;

	views: { [ key: string ]: View } = {};

	lists: { [ key: string ]: string } = {};

	shows: { [ key: string ]: string } = {};

	updateHandlers: { [ key: string ]: string } | undefined = undefined;

	filters: { [ key: string ]: string } = {};

	constructor(partial: Partial<DesignDocument>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('revHistory' in partial && partial.revHistory !== undefined) this.revHistory = partial.revHistory;
		if ('language' in partial) this.language = partial.language;
		if ('views' in partial && partial.views !== undefined) this.views = partial.views;
		if ('lists' in partial && partial.lists !== undefined) this.lists = partial.lists;
		if ('shows' in partial && partial.shows !== undefined) this.shows = partial.shows;
		if ('updateHandlers' in partial) this.updateHandlers = partial.updateHandlers;
		if ('filters' in partial && partial.filters !== undefined) this.filters = partial.filters;
	}

}
