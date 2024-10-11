package com.icure.cardinal.sdk.js.kerberus

import com.icure.kerberus.Solution

fun Solution_fromJs(solutionJs: SolutionJs): Solution = Solution(
	id = solutionJs.id,
	nonces = solutionJs.nonces.toList()
)