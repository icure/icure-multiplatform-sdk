// auto-generated file


enum Laterality {
	left,
	right;

	static String encode(Laterality value) {
		switch (value) {
			case Laterality.left:
				return 'left';
			case Laterality.right:
				return 'right';
			}
	}


	static Laterality fromJSON(String data) {
		switch (data) {
			case "left":
				return Laterality.left;
			case "right":
				return Laterality.right;
			default:
				throw ArgumentError('Invalid Laterality entry value $data');
			}
	}

}