// auto-generated file

export class LabelledOccurence {

  label: string;

  occurence: number;

  constructor(partial: Partial<LabelledOccurence> & Pick<LabelledOccurence, "label" | "occurence">) {
    this.label = partial.label;
    this.occurence = partial.occurence;
  }

}
