package fr.misterassm.korden.adapters

// https://discord.com/developers/docs/topics/gateway#list-of-intents
interface IntentsAdapter {

    fun getIdentifier(): Int

}
