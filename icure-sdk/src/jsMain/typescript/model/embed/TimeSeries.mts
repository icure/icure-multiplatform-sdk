// auto-generated file

export class TimeSeries {

  fields: Array<string> = [];

  samples: Array<Array<number>> = [];

  min: Array<number> = [];

  max: Array<number> = [];

  mean: Array<number> = [];

  median: Array<number> = [];

  variance: Array<number> = [];

  constructor(partial: Partial<TimeSeries>) {
    if ('fields' in partial && partial.fields !== undefined) this.fields = partial.fields;
    if ('samples' in partial && partial.samples !== undefined) this.samples = partial.samples;
    if ('min' in partial && partial.min !== undefined) this.min = partial.min;
    if ('max' in partial && partial.max !== undefined) this.max = partial.max;
    if ('mean' in partial && partial.mean !== undefined) this.mean = partial.mean;
    if ('median' in partial && partial.median !== undefined) this.median = partial.median;
    if ('variance' in partial && partial.variance !== undefined) this.variance = partial.variance;
  }

}
