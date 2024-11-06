package com.icure.cardinal.sdk.utils

enum class CardinalPlatform {
	Android,
	Ios,
	Browser,
	Node,
	Jvm,
	Mac,
	Linux,
	Windows
}

expect val currentPlatform: CardinalPlatform