// auto-generated file
import {StructureElement} from './StructureElement.mjs';


export class FieldsGroup {

  group: string;

  fields: Array<StructureElement> | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.embed.form.template.FieldsGroup' = 'com.icure.sdk.model.embed.form.template.FieldsGroup';

  constructor(partial: Partial<FieldsGroup> & Pick<FieldsGroup, "group">) {
    this.group = partial.group;
    if ('fields' in partial) this.fields = partial.fields;
  }

}
