package com.icure.cardinal.sdk.utils

import co.touchlab.kermit.Logger

private val base = Logger

fun getLogger(tag: String) =
	base.withTag(tag)