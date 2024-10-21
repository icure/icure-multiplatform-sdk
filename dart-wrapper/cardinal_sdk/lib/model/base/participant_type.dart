// This file is auto-generated


enum ParticipantType {
	admitter,
	attender,
	callbackContact,
	consultant,
	discharger,
	escort,
	referrer,
	secondaryPerformer,
	primaryPerformer,
	participation,
	translator,
	emergency,
	location;

	static String encode(ParticipantType value) {
		switch (value) {
			case ParticipantType.admitter:
				return '"Admitter"';
			case ParticipantType.attender:
				return '"Attender"';
			case ParticipantType.callbackContact:
				return '"CallbackContact"';
			case ParticipantType.consultant:
				return '"Consultant"';
			case ParticipantType.discharger:
				return '"Discharger"';
			case ParticipantType.escort:
				return '"Escort"';
			case ParticipantType.referrer:
				return '"Referrer"';
			case ParticipantType.secondaryPerformer:
				return '"SecondaryPerformer"';
			case ParticipantType.primaryPerformer:
				return '"PrimaryPerformer"';
			case ParticipantType.participation:
				return '"Participation"';
			case ParticipantType.translator:
				return '"Translator"';
			case ParticipantType.emergency:
				return '"Emergency"';
			case ParticipantType.location:
				return '"Location"';
			}
	}

}