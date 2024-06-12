// auto-generated file

export class NumberField {

  field: string;

  shortLabel: string | undefined = undefined;

  rows: number | undefined = undefined;

  columns: number | undefined = undefined;

  grows: boolean | undefined = undefined;

  multiline: boolean | undefined = undefined;

  schema: string | undefined = undefined;

  tags: Array<string> | undefined = undefined;

  codifications: Array<string> | undefined = undefined;

  options: { [ key: string ]: string } | undefined = undefined;

  labels: { [ key: string ]: string } | undefined = undefined;

  value: string | undefined = undefined;

  unit: string | undefined = undefined;

  required: boolean | undefined = undefined;

  hideCondition: string | undefined = undefined;

  now: boolean | undefined = undefined;

  translate: boolean | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.embed.form.template.NumberField' = 'com.icure.sdk.model.embed.form.template.NumberField';

  constructor(partial: Partial<NumberField> & Pick<NumberField, "field">) {
    this.field = partial.field;
    if ('shortLabel' in partial) this.shortLabel = partial.shortLabel;
    if ('rows' in partial) this.rows = partial.rows;
    if ('columns' in partial) this.columns = partial.columns;
    if ('grows' in partial) this.grows = partial.grows;
    if ('multiline' in partial) this.multiline = partial.multiline;
    if ('schema' in partial) this.schema = partial.schema;
    if ('tags' in partial) this.tags = partial.tags;
    if ('codifications' in partial) this.codifications = partial.codifications;
    if ('options' in partial) this.options = partial.options;
    if ('labels' in partial) this.labels = partial.labels;
    if ('value' in partial) this.value = partial.value;
    if ('unit' in partial) this.unit = partial.unit;
    if ('required' in partial) this.required = partial.required;
    if ('hideCondition' in partial) this.hideCondition = partial.hideCondition;
    if ('now' in partial) this.now = partial.now;
    if ('translate' in partial) this.translate = partial.translate;
  }

}
