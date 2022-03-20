package fr.misterassm.korden.adapters

// https://discord.com/developers/docs/topics/gateway#list-of-intents
interface IntentsAdapter {

    val formateShl: (Int) -> Int
        get() = { 1 shl it }

    fun getIdentifier(): Int

}
