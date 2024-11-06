package com.icure.cardinal.sdk.utils.collections

import kotlin.jvm.JvmInline

@JvmInline
internal value class DirectedGraph<T>(val nodesToEdges: Map<T, Set<T>>) {
	companion object {
		/**
		 * Creates a graph from a series of edges and optionally additional nodes.
		 * @param additionalNodes nodes to include in the resulting graph even if they do not appear in any edge.
		 * @param edges edges between nodes (from, to).
		 * @return a graph built using the provided parameters.
		 */
		fun <T> fromEdges(
			vararg edges: Pair<T, T>,
			additionalNodes: Collection<T> = emptySet(),
		): DirectedGraph<T> {
			val allNodes = edges.flatMapTo(additionalNodes.toMutableSet()) { (from, to) -> listOf(from, to) }
			val groupedEdges = edges.groupBy { it.first }.mapValues { (_, v) -> v.mapTo(mutableSetOf()) { it.second } }
			return DirectedGraph(allNodes.associateWith { groupedEdges[it] ?: emptySet() })
		}
	}

	private data class TarjanNodeInfo<T>(
		val node: T,
		var index: Int? = null,
		var lowlink: Int? = null,
		var onStack: Boolean = false
	)
	fun acyclic(): StronglyConnectedGraph<T> {
		var index = 0
		val nodeStack = MutableStack<TarjanNodeInfo<T>>()
		val nodesInfo = nodesToEdges.keys.associateWith { TarjanNodeInfo(it) }

		val originalLabelToAcyclicLabel = mutableMapOf<T, T>()
		val acyclicLabelToGroup = mutableMapOf<T, Set<T>>()

		fun strongConnect(fromInfo: TarjanNodeInfo<T>) {
			fromInfo.index = index
			fromInfo.lowlink = index
			index++
			nodeStack.push(fromInfo)
			fromInfo.onStack = true

			nodesToEdges.getValue(fromInfo.node).forEach { toNode ->
				val toInfo = nodesInfo.getValue(toNode)
				if (toInfo.index == null) {
					strongConnect(toInfo)
					fromInfo.lowlink = minOf(fromInfo.lowlink!!, toInfo.lowlink!!)
				} else if (toInfo.onStack) {
					fromInfo.lowlink = minOf(fromInfo.lowlink!!, toInfo.lowlink!!)
				}
			}

			if (fromInfo.lowlink == fromInfo.index) {
				val stronglyConnectedSet = mutableSetOf<T>()
				lateinit var latest: TarjanNodeInfo<T>
				do {
					latest = nodeStack.pop()
					latest.onStack = false
					stronglyConnectedSet.add(latest.node)
				} while (latest != fromInfo)
				val acyclicLabel = fromInfo.node
				stronglyConnectedSet.forEach { originalLabelToAcyclicLabel[it] = acyclicLabel }
				acyclicLabelToGroup[acyclicLabel] = stronglyConnectedSet.toSet()
			}
		}

		nodesInfo.values.forEach { if (it.index == null) strongConnect(it) }

		val acyclicGraph = DirectedGraph(nodesToEdges.keys.mapNotNull { k ->
			val kAcyclic = originalLabelToAcyclicLabel.getValue(k)
			if (kAcyclic != k) null else {
				val members =
					acyclicLabelToGroup.getValue(kAcyclic)
				val originalLabelOfToNodes =
					members.flatMap { nodesToEdges.getValue(it) }.toSet()
				val acyclicLabelsOfToNodes =
					originalLabelOfToNodes.map { originalLabelToAcyclicLabel.getValue(it) }.toSet()
				kAcyclic to (acyclicLabelsOfToNodes - kAcyclic)
			}
		}.toMap())

		return StronglyConnectedGraph(
			acyclicGraph,
			originalLabelToAcyclicLabel,
			acyclicLabelToGroup
		)
	}
}

internal data class StronglyConnectedGraph<T>(
	val acyclicGraph: DirectedGraph<T>,
	val originalLabelToAcyclicLabel: Map<T, T>,
	val acyclicLabelToGroup: Map<T, Set<T>>,
) {
	/**
	 * Get the nodes reachable from each node in an acyclic graph. Exclude the node itself.
	 * @return all nodes reachable from each node in the graph with 1 or more steps.
	 */
	val reachSets: Map<T, Set<T>> by lazy {
		val res = mutableMapOf<T, Set<T>>()
		fun calculateAndCacheReachSetRecursive(node: T): Set<T> =
			res.getOrPut(node) {
				acyclicGraph.nodesToEdges.getValue(node).flatMap {
					calculateAndCacheReachSetRecursive(it) + it
				}.toSet()
			}
		acyclicGraph.nodesToEdges.keys.forEach { calculateAndCacheReachSetRecursive(it) }
		res
	}
}