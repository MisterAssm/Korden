package fr.misterassm.korden.factories

import fr.misterassm.korden.adapters.BitSetAdapter
import fr.misterassm.korden.adapters.IntentsAdapter
import java.lang.Integer.bitCount
import kotlin.contracts.ExperimentalContracts

class BitSetFactory(rawValue: Int) : BitSetAdapter(rawValue) {

    constructor(vararg intents: IntentsAdapter) : this(IntentFactory.rawTransformer(intents.toList()))

    override fun and(newValue: Int): BitSetFactory = BitSetFactory(rawValue and newValue)

    override fun and(bitSetFactory: BitSetFactory): BitSetFactory = and(bitSetFactory.rawValue)

    override fun and(intentsAdapter: IntentsAdapter): BitSetFactory = and(intentsAdapter.getIdentifier())

    override fun nand(newValue: Int): BitSetFactory = BitSetFactory(rawValue and newValue.inv())

    override fun nand(bitSetFactory: BitSetFactory): BitSetFactory = nand(bitSetFactory.rawValue)

    override fun nand(intentsAdapter: IntentsAdapter): BitSetFactory = nand(intentsAdapter.getIdentifier())

    override fun or(newValue: Int): BitSetFactory = BitSetFactory(rawValue or newValue)

    override fun or(bitSetFactory: BitSetFactory): BitSetFactory = or(bitSetFactory.rawValue)

    override fun or(intentsAdapter: IntentsAdapter): BitSetFactory = or(intentsAdapter.getIdentifier())

    override fun xor(newValue: Int): BitSetFactory = BitSetFactory(rawValue xor newValue)

    override fun xor(bitSetFactory: BitSetFactory): BitSetFactory = xor(bitSetFactory.rawValue)

    override fun xor(intentsAdapter: IntentsAdapter): BitSetFactory = xor(intentsAdapter.getIdentifier())

    override fun not(): BitSetFactory = BitSetFactory(rawValue.inv() and IntentFactory.allIntentsRaw())

    inline fun <reified T : Enum<out IntentsAdapter>> notOf(): BitSetFactory =
        BitSetFactory(rawValue.inv() and IntentFactory.allIntentsRawOf<T>())

    override fun plus(bitSetFactory: BitSetFactory): BitSetFactory = or(bitSetFactory)

    override fun plus(intentsAdapter: IntentsAdapter): BitSetFactory = or(intentsAdapter)

    override fun minus(bitSetFactory: BitSetFactory): BitSetFactory = nand(bitSetFactory)

    override fun minus(intentsAdapter: IntentsAdapter): BitSetFactory = nand(intentsAdapter)

    override val size: Int
        get() = bitCount(rawValue)

    override fun contains(element: IntentsAdapter): Boolean = (element.getIdentifier() and rawValue) > 0

    override fun containsAll(elements: Collection<IntentsAdapter>): Boolean = elements.all { contains(it) }

    override fun isEmpty(): Boolean = size == 0

    @OptIn(ExperimentalContracts::class)
    override fun iterator(): Iterator<IntentsAdapter> = IntentFactory.allIntentsSet().apply {
        removeIf { !contains(it) }
    }.iterator()

}
