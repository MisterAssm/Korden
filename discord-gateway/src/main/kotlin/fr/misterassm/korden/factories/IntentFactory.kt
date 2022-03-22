package fr.misterassm.korden.factories

import fr.misterassm.korden.adapters.IntentsAdapter
import fr.misterassm.korden.models.enums.intents.DefaultIntents
import fr.misterassm.korden.models.enums.intents.PrivilegedIntents

@Suppress("UPPER_BOUND_VIOLATED_WARNING", "UNCHECKED_CAST")
object IntentFactory {

    val shiftLeftTransformer: (Int) -> Int get() = { 1 shl it }

    val rawTransformer: (Collection<IntentsAdapter>) -> Int
        get() = { array ->
            array.map { it.getIdentifier() }.reduce { acc, i -> acc or i }
        }

    fun allIntentsSet(): MutableSet<IntentsAdapter> = mutableSetOf<IntentsAdapter>().apply {
        addAll(DefaultIntents.values())
        addAll(PrivilegedIntents.values())
    }

    inline fun <reified T : Enum<out IntentsAdapter>> valuesOf(): MutableSet<out IntentsAdapter> =
        mutableSetOf(*enumValues<T>() as Array<out IntentsAdapter>)

    inline fun <reified T : Enum<out IntentsAdapter>> allIntentsRawOf(): Int =
        rawTransformer(valuesOf<T>())

    fun allIntentsRaw(): Int = rawTransformer(allIntentsSet())

}
