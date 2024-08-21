package com.icure.sdk.utils

enum class IcurePlatform {
	Android,
	Ios,
	Browser,
	Node,
	Jvm,
	Mac,
	Linux,
	Windows
}

expect val currentPlatform: IcurePlatform