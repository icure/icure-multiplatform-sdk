//package com.icure.sdk.utils.pagination
//
//import com.icure.kryptom.crypto.defaultCryptoService
//import com.icure.sdk.model.PaginatedDocumentKeyIdPair
//import com.icure.sdk.model.PaginatedList
//import io.kotest.assertions.throwables.shouldThrow
//import io.kotest.core.spec.style.StringSpec
//import io.kotest.matchers.collections.shouldContainExactly
//import io.kotest.matchers.shouldBe
//import kotlinx.serialization.json.JsonPrimitive
//
//class SingleSourcePageIteratorTest : StringSpec({
//
//	data class Datum(
//		val id: String = defaultCryptoService.strongRandom.randomUUID(),
//		val someValue: Int
//	)
//
//	val firstPage = PaginatedList(
//		rows = List(10) { Datum(someValue = it)},
//		nextKeyPair = PaginatedDocumentKeyIdPair(startKey = JsonPrimitive("some key"), startKeyDocId = "some id")
//	)
//	val secondPage = PaginatedList<Datum>(rows = List(10) { Datum(someValue = it)})
//
//	suspend fun <T: Any> SingleSourcePageIterator<T>.shouldHaveNoMoreElements() {
//		hasNext() shouldBe false
//		tryNext() shouldBe null
//		shouldThrow<NoSuchElementException> { next() }
//	}
//
//	fun createIterator(): SingleSourcePageIterator<Datum> {
//		var firstEmitted = false
//		return SingleSourcePageIterator {
//			when {
//				it == null && !firstEmitted -> {
//					firstEmitted = true
//					firstPage
//				}
//				it != null -> secondPage
//				else -> throw IllegalStateException("This should not happen")
//			}
//		}
//	}
//
//	"A SingleSourceIterator can iterate over multiple pages" {
//		val iterator = createIterator()
//		val results = mutableListOf<Datum>()
//
//		while(iterator.hasNext()) {
//			results.add(iterator.next())
//		}
//
//		results shouldContainExactly (firstPage.rows + secondPage.rows)
//		iterator.shouldHaveNoMoreElements()
//	}
//
//	"A SingleSourceIterator can iterate over multiple pages using tryNext" {
//		val iterator = createIterator()
//		val results = mutableListOf<Datum?>()
//
//		do {
//			val result = iterator.tryNext()
//			results.add(result)
//		} while (result != null)
//
//		results shouldContainExactly (firstPage.rows + secondPage.rows + null)
//		iterator.shouldHaveNoMoreElements()
//	}
//
//	"A SingleSourceIterator hasNext is idempotent" {
//		val iterator = createIterator()
//		val results = mutableListOf<Datum>()
//
//		while(iterator.hasNext()) {
//			(1 .. 10).forEach { _ -> iterator.hasNext() }
//			results.add(iterator.next())
//		}
//
//		results shouldContainExactly (firstPage.rows + secondPage.rows)
//		iterator.shouldHaveNoMoreElements()
//	}
//
//	"SingleSourceIterator - Any exception thrown in the request is not caught by the iterator" {
//		class CustomException : Exception()
//
//		var firstEmitted = false
//		val iterator = SingleSourcePageIterator {
//			when {
//				it == null && !firstEmitted -> {
//					firstEmitted = true
//					firstPage
//				}
//				it != null -> throw CustomException()
//				else -> throw IllegalStateException("This should not happen")
//			}
//		}
//		shouldThrow<CustomException> {
//			while(iterator.hasNext()) {
//				iterator.next()
//			}
//		}
//	}
//
//	"SingleSourceIterator - If the request returns an empty page, hasNext is false" {
//		val iterator = SingleSourcePageIterator<Datum> {
//			PaginatedList()
//		}
//		iterator.shouldHaveNoMoreElements()
//	}
//
//})
