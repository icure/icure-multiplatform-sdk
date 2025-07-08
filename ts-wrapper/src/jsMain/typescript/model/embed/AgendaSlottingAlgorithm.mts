// auto-generated file

export type AgendaSlottingAlgorithm = AgendaSlottingAlgorithm.FixedIntervals;

export namespace AgendaSlottingAlgorithm {

	export class FixedIntervals {

		intervalMinutes: number;

		readonly $ktClass: 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals' = 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals';

		constructor(partial: Partial<FixedIntervals> & Pick<FixedIntervals, "intervalMinutes">) {
			this.intervalMinutes = partial.intervalMinutes;
		}

	}

}
