package com.icure.sdk.model

interface Identifiable<T> {
	val id: T
}

interface Revisionable<T> : Identifiable<T> {
	val rev: String?
}