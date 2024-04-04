package com.icure.sdk.utils.pagination

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.model.PaginatedDocumentKeyIdPair
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.base.Versionable
import com.icure.sdk.model.specializations.JsonString
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class SequentialMultiplePageIteratorTest : StringSpec({

	data class Datum(
		override val id: String = defaultCryptoService.strongRandom.randomUUID(),
		override val rev: String? = null,
		val someValue: Int
	) : Versionable<String>

	suspend fun <T: Versionable<String>, P : Any> SequentialMultiplePageIterator<T, P>.shouldHaveNoMoreElements() {
		hasNext() shouldBe false
		tryNext() shouldBe null
		shouldThrow<NoSuchElementException> { next() }
	}

	fun createIterator(): Pair<SequentialMultiplePageIterator<Datum, Int>, List<Datum>> {
		val pages = listOf(
			listOf(PaginatedList(rows = (0 until 10).map { Datum(someValue = it) }.toList())),
			listOf(PaginatedList()),
			listOf(
				PaginatedList(
					rows = (10 until 20).map { Datum(someValue = it) }.toList(),
					nextKeyPair = PaginatedDocumentKeyIdPair(startKey = "1", startKeyDocId = "id")
				),
				PaginatedList(
					rows = (20 until 30).map { Datum(someValue = it) }.toList(),
					nextKeyPair = PaginatedDocumentKeyIdPair(startKey = "2", startKeyDocId = "id")
				),
				PaginatedList(rows = (30 until 40).map { Datum(someValue = it) }.toList())
			),
			listOf(
				PaginatedList(
					rows = (40 until 50).map { Datum(someValue = it) }.toList(),
					nextKeyPair = PaginatedDocumentKeyIdPair(startKey = "1", startKeyDocId = "id")
				),
				PaginatedList(rows = (50 until 60).map { Datum(someValue = it) }.toList())
			)
		)
		val emitted = Array(pages.size) { false }
		val iterator = SequentialMultiplePageIterator(
			(0 .. 3).toList().shuffled(),
			{ a, b -> a.compareTo(b) }
		) { params, nextKeyPair ->
			when {
				!emitted[params] && nextKeyPair == null -> {
					emitted[params] = true
					pages[params][0]
				}
				nextKeyPair != null -> {
					val idx = nextKeyPair.startKey?.toInt().shouldNotBeNull()
					pages[params][idx]
				}
				else -> throw IllegalStateException("This should not happen")
			}
		}
		return iterator to pages.flatMap { p ->
			p.flatMap {
				it.rows
			}
		}
	}

	"A SequentialMultiplePageIterator can iterate over multiple pages" {
		val (iterator, controlValues) = createIterator()
		val results = mutableListOf<Datum>()

		while(iterator.hasNext()) {
			results.add(iterator.next())
		}

		results shouldContainExactly controlValues
		iterator.shouldHaveNoMoreElements()
	}

	"A SequentialMultiplePageIterator can iterate over multiple pages using tryNext" {
		val (iterator, controlValues) = createIterator()
		val results = mutableListOf<Datum?>()

		do {
			val result = iterator.tryNext()
			results.add(result)
		} while (result != null)

		results shouldContainExactly (controlValues + null)
		iterator.shouldHaveNoMoreElements()
	}

	"A SequentialMultiplePageIterator hasNext is idempotent" {
		val (iterator, controlValues) = createIterator()
		val results = mutableListOf<Datum>()

		while(iterator.hasNext()) {
			(1 .. 10).forEach { _ -> iterator.hasNext() }
			results.add(iterator.next())
		}

		results shouldContainExactly controlValues
		iterator.shouldHaveNoMoreElements()
	}

	"SequentialMultiplePageIterator - Any exception thrown in the request is not caught by the iterator" {
		class CustomException : Exception()

		val iterator = SequentialMultiplePageIterator<Datum, Int>(
			requestParameters = listOf(1,2,3,4,5,6)
		) { _, _ -> throw CustomException() }

		shouldThrow<CustomException> {
			while(iterator.hasNext()) {
				iterator.next()
			}
		}
	}

	"SequentialMultiplePageIterator - If the parameters are empty, hasNext is false" {
		val iterator = SequentialMultiplePageIterator<Datum, Int>(
			requestParameters = listOf(1,2,3,4,5,6)
		) { _, _ -> PaginatedList() }
		iterator.shouldHaveNoMoreElements()
	}

	"SequentialMultiplePageIterator - If there is a very big number of elements to skip, hasNext() will not go in stack overflow" {
		val firstPageRows = (0 until 10).map { Datum(someValue = it) }.toList()
		val lastValue = Datum(someValue = 10)
		val pages = listOf<PaginatedList<Datum, JsonString>>(
			PaginatedList(rows = firstPageRows),
			PaginatedList(rows = List(1_000_000) { firstPageRows.last() } + lastValue)
		)
		val iterator = SequentialMultiplePageIterator(
			requestParameters = listOf(0, 1)
		) { params, _ ->
			pages[params]
		}

		val results = mutableListOf<Datum>()
		while(iterator.hasNext()) {
			results.add(iterator.next())
		}

		results shouldContainExactly (firstPageRows + lastValue)
		iterator.shouldHaveNoMoreElements()
	}
})
