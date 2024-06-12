// auto-generated file
import {ApplicationSettings} from '../model/ApplicationSettings.mjs';


export interface ApplicationSettingsApi {

	getApplicationSettings(): Promise<Array<ApplicationSettings>>;

	createApplicationSettings(applicationSettings: ApplicationSettings): Promise<ApplicationSettings>;

	updateApplicationSettings(applicationSettings: ApplicationSettings): Promise<ApplicationSettings>;

}
