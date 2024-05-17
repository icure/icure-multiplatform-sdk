package com.icure.sdk.utils.collections

class MutableStack<T> {
	private var head: Node<T>? = null

	data class Node<T>(
		val value: T,
		var next: Node<T>? = null
	)

	fun push(value: T) {
		head = Node(value, head)
	}

	fun pop(): T {
		val value = head?.value ?: throw NoSuchElementException()
		head = head?.next
		return value
	}
}
