// auto-generated file

export class LetterValue {

  letter: string | undefined = undefined;

  index: string | undefined = undefined;

  coefficient: number | undefined = undefined;

  value: number | undefined = undefined;

  constructor(partial: Partial<LetterValue>) {
    if ('letter' in partial) this.letter = partial.letter;
    if ('index' in partial) this.index = partial.index;
    if ('coefficient' in partial) this.coefficient = partial.coefficient;
    if ('value' in partial) this.value = partial.value;
  }

}
