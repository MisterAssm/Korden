package fr.misterassm.korden.models.enums.intents

import fr.misterassm.korden.adapters.PrivilegedIntentsAdapter
import fr.misterassm.korden.factories.IntentFactory.shiftLeftTransformer

enum class PrivilegedIntents(private val shiftCount: Int) : PrivilegedIntentsAdapter {

    GUILD_MEMBERS(1),
    GUILD_PRESENCES(8),
    MESSAGE_CONTENT(15),
    ;

    override fun getIdentifier() = shiftLeftTransformer(shiftCount)

}


