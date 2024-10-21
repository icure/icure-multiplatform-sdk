// This file is auto-generated


enum AppendixType {
	externalLink,
	video,
	description;

	static String encode(AppendixType value) {
		switch (value) {
			case AppendixType.externalLink:
				return '"ExternalLink"';
			case AppendixType.video:
				return '"Video"';
			case AppendixType.description:
				return '"Description"';
			}
	}

}