// auto-generated file

export class View {

  map: string;

  reduce: string | undefined = undefined;

  constructor(partial: Partial<View> & Pick<View, "map">) {
    this.map = partial.map;
    if ('reduce' in partial) this.reduce = partial.reduce;
  }

}
