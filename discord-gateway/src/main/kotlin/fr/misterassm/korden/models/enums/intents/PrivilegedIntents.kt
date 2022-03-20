package fr.misterassm.korden.models.enums.intents

import fr.misterassm.korden.adapters.PrivilegedIntentsAdapter

enum class PrivilegedIntents(private val code: Int) : PrivilegedIntentsAdapter {

    GUILD_MEMBERS(1 shl 1),
    GUILD_PRESENCES(1 shl 8),
    MESSAGE_CONTENT(1 shl 15),
    ;

    override fun getIdentifier() = this.code

}
