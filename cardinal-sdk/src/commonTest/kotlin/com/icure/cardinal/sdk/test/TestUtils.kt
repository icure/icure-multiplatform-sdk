package com.icure.cardinal.sdk.test

import io.kotest.core.spec.style.StringSpec
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job

// A job that is automatically canceled when the string spec terminates
fun StringSpec.autoCancelJob() = Job().also { j -> afterSpec { j.cancel(CancellationException("Tests completed")) } }