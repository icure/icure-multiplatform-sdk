// This file is auto-generated


enum AppendixType {
	externalLink,
	video,
	description;

	static String encode(AppendixType value) {
		switch (value) {
			case AppendixType.externalLink:
				return '"externalLink"';
			case AppendixType.video:
				return '"video"';
			case AppendixType.description:
				return '"description"';
			}
	}


	static AppendixType fromJSON(String data) {
		switch (data) {
			case "externalLink":
				return AppendixType.externalLink;
			case "video":
				return AppendixType.video;
			case "description":
				return AppendixType.description;
			default:
				throw ArgumentError('Invalid AppendixType entry value $data');
			}
	}

}