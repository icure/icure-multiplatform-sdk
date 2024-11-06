@file:JsModule("kerberus")
package com.icure.cardinal.sdk.js.kerberus

@JsName("Solution")
external interface SolutionJs {
	val id: String
	val nonces: Array<String>
}