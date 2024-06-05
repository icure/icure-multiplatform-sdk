// auto-generated file
import {Action} from './Action.mjs';
import {Section} from './Section.mjs';


export class FormTemplateLayout {

  form: string;

  actions: Array<Action> = [];

  sections: Array<Section> = [];

  description: string | undefined = undefined;

  keywords: Array<string> | undefined = undefined;

  constructor(partial: Partial<FormTemplateLayout> & Pick<FormTemplateLayout, "form">) {
    this.form = partial.form;
    if ('actions' in partial && partial.actions !== undefined) this.actions = partial.actions;
    if ('sections' in partial && partial.sections !== undefined) this.sections = partial.sections;
    if ('description' in partial) this.description = partial.description;
    if ('keywords' in partial) this.keywords = partial.keywords;
  }

}
