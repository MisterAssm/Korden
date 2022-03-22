package fr.misterassm.korden.adapters

import fr.misterassm.korden.factories.BitSetFactory

abstract class BitSetAdapter(val rawValue: Int) : Set<IntentsAdapter> {

    abstract fun and(newValue: Int): BitSetFactory

    abstract fun and(bitSetFactory: BitSetFactory): BitSetFactory

    abstract fun and(intentsAdapter: IntentsAdapter): BitSetFactory

    abstract fun nand(newValue: Int): BitSetFactory

    abstract fun nand(bitSetFactory: BitSetFactory): BitSetFactory

    abstract fun nand(intentsAdapter: IntentsAdapter): BitSetFactory

    abstract fun or(newValue: Int): BitSetFactory

    abstract fun or(bitSetFactory: BitSetFactory): BitSetFactory

    abstract fun or(intentsAdapter: IntentsAdapter): BitSetFactory

    abstract fun xor(newValue: Int): BitSetFactory

    abstract fun xor(bitSetFactory: BitSetFactory): BitSetFactory

    abstract fun xor(intentsAdapter: IntentsAdapter): BitSetFactory

    abstract fun not(): BitSetFactory

    abstract operator fun plus(bitSetFactory: BitSetFactory): BitSetFactory

    abstract operator fun plus(intentsAdapter: IntentsAdapter): BitSetFactory

    abstract operator fun minus(bitSetFactory: BitSetFactory): BitSetFactory

    abstract operator fun minus(intentsAdapter: IntentsAdapter): BitSetFactory

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BitSetAdapter) return false

        if (rawValue != other.rawValue) return false

        return true
    }

    override fun hashCode(): Int {
        return rawValue.hashCode()
    }

    override fun toString(): String {
        return "BitCollectionAdapter(rawValue=$rawValue)"
    }

}
