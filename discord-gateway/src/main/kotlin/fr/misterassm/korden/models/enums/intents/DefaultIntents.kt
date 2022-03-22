package fr.misterassm.korden.models.enums.intents

import fr.misterassm.korden.adapters.IntentsAdapter
import fr.misterassm.korden.factories.IntentFactory.shiftLeftTransformer

enum class DefaultIntents(private val shiftCount: Int) : IntentsAdapter {

    GUILDS(0),
    GUILD_BANS(2),
    GUILD_EMOJIS_AND_STICKERS(3),
    GUILD_INTEGRATIONS(4),
    GUILD_WEBHOOKS(5),
    GUILD_INVITES(6),
    GUILD_VOICE_STATES(7),
    GUILD_MESSAGES(9),
    GUILD_MESSAGE_REACTIONS(10),
    GUILD_MESSAGE_TYPING(11),
    DIRECT_MESSAGES(12),
    DIRECT_MESSAGE_REACTIONS(13),
    DIRECT_MESSAGE_TYPING(14),
    GUILD_SCHEDULED_EVENTS(16),
    ;

    override fun getIdentifier() = shiftLeftTransformer(shiftCount)

}
