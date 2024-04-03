package com.icure.sdk.utils.pagination

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.model.Identifiable
import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.base.Versionable
import com.icure.sdk.model.specializations.JsonString
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class MultipleSourcePageIteratorTest : StringSpec({

	data class Datum(
		override val id: String = defaultCryptoService.strongRandom.randomUUID(),
		override val rev: String? = null,
		val someValue: Int
	) : Versionable<String>

	fun createIterator(): Pair<MultipleSourcePageIterator<Datum, Int>, List<Datum>> {
		val firstPagesElements = List(60) { Datum(someValue = it) }
		val firstPages = Array<PaginatedList<Datum, JsonString>>(7) {
			if(it <= 2) PaginatedList(nextKeyPair = PaginatedDocumentKeyIdPair(startKey = "second_page", startKeyDocId = "some id"))
			else PaginatedList()
		}
		firstPagesElements.forEachIndexed { index, datum ->
			(1 .. 6).forEach {
				if(index % it == 0) {
					val page = firstPages[it-1]
					firstPages[it-1] = page.copy(
						rows = page.rows + datum
					)
				}
			}
		}
		val secondPagesElements = List(30) { Datum(someValue = it + 70)}
		val secondPages = Array<PaginatedList<Datum, JsonString>>(3) {
			if(it == 0) PaginatedList(nextKeyPair = PaginatedDocumentKeyIdPair(startKey = "third_page", startKeyDocId = "some id"))
			else PaginatedList()
		}
		secondPagesElements.forEachIndexed { index, datum ->
			(1 .. 3).forEach {
				if(index % it == 0) {
					val page = secondPages[it-1]
					secondPages[it-1] = page.copy(
						rows = page.rows + datum
					)
				}
			}
		}
		val thirdPagesElements = List(10) { Datum(someValue = it + 110)}
		val thirdPages = Array<PaginatedList<Datum, JsonString>>(1) {
			PaginatedList(rows = thirdPagesElements)
		}
		val firstPageEmitted = Array(7) { false }
		val iterator = MultipleSourcePageIterator(
			requestParameters = List(7) { it },
			elementComparator = { a, b -> a.someValue.compareTo(b.someValue) }
		) { params, nextKeyPair ->
			when {
				nextKeyPair == null && !firstPageEmitted[params] -> {
					firstPageEmitted[params] = true
					firstPages[params]
				}
				nextKeyPair?.startKey == "second_page" -> {
					secondPages[params]
				}
				nextKeyPair?.startKey == "third_page" -> {
					thirdPages[params]
				}
				else -> throw IllegalStateException("This should not happen")
			}
		}
		return iterator to (firstPagesElements + secondPagesElements + thirdPagesElements)
	}

	suspend fun <T: Versionable<String>, P : Any> MultipleSourcePageIterator<T, P>.shouldHaveNoMoreElements() {
		hasNext() shouldBe false
		tryNext() shouldBe null
		shouldThrow<NoSuchElementException> { next() }
	}

	"A MultipleSourceIterator can iterate over multiple pages" {
		val (iterator, controlValues) = createIterator()
		val results = mutableListOf<Datum>()

		while(iterator.hasNext()) {
			results.add(iterator.next())
		}

		results shouldContainExactly controlValues
		iterator.shouldHaveNoMoreElements()
	}

	"A MultipleSourceIterator can iterate over multiple pages using tryNext" {
		val (iterator, controlValues) = createIterator()
		val results = mutableListOf<Datum?>()

		do {
			val result = iterator.tryNext()
			results.add(result)
		} while (result != null)

		results shouldContainExactly (controlValues + null)
		iterator.shouldHaveNoMoreElements()
	}

	"A MultipleSourceIterator hasNext is idempotent" {
		val (iterator, controlValues) = createIterator()
		val results = mutableListOf<Datum>()

		while(iterator.hasNext()) {
			(1 .. 10).forEach { _ -> iterator.hasNext() }
			results.add(iterator.next())
		}

		results shouldContainExactly controlValues
		iterator.shouldHaveNoMoreElements()
	}

	"MultipleSourceIterator - Any exception thrown in the request is not caught by the iterator" {
		class CustomException : Exception()

		val iterator = MultipleSourcePageIterator<Datum, Int>(
			requestParameters = listOf(1,2,3,4,5,6)
		) { _, _ -> throw CustomException() }

		shouldThrow<CustomException> {
			while(iterator.hasNext()) {
				iterator.next()
			}
		}
	}

	"MultipleSourceIterator - If the request returns an empty page, hasNext is false" {
		val iterator = MultipleSourcePageIterator<Datum, Int>(
			requestParameters = listOf(1,2,3,4,5,6)
		) { _, _ -> PaginatedList() }
		iterator.shouldHaveNoMoreElements()
	}

	"A MultipleSourceIterator will ignore any duplicate based on the id" {
		val elements = listOf(
			Datum(someValue = 1),
			Datum(someValue = 2),
			Datum(someValue = 3),
			Datum(someValue = 4)
		)
		val firstPage = PaginatedList<Datum, JsonString>(rows = listOf(elements[0], elements[0], elements[1], elements[1], elements[3]))
		val secondPages = listOf(
			PaginatedList(
				rows = listOf(elements[0], elements[0], elements[0], elements[1], elements[2]),
				nextKeyPair = PaginatedDocumentKeyIdPair("key", "id")
			),
			PaginatedList(rows = listOf(elements[2], elements[2], elements[3], elements[3], elements[3]),)
		)
		var firstEmitted = false
		var secondEmitted = false
		val iterator = MultipleSourcePageIterator(
			requestParameters = List(2) { it },
			elementComparator = { a, b -> a.someValue.compareTo(b.someValue) }
		) { params, nextKeyPair ->
			when {
				params == 0 && !firstEmitted -> {
					firstEmitted = true
					firstPage
				}
				params == 1 && !secondEmitted -> {
					secondEmitted = true
					secondPages.first()
				}
				nextKeyPair?.startKey == "key" -> secondPages.last()

				else -> throw IllegalStateException("This should not happen")
			}
		}

		val results = mutableListOf<Datum>()
		while(iterator.hasNext()) {
			results.add(iterator.next())
		}

		results shouldContainExactly elements
		iterator.shouldHaveNoMoreElements()
	}

})
