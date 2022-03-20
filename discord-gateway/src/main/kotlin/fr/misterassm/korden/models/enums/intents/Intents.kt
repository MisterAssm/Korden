package fr.misterassm.korden.models.enums.intents

import fr.misterassm.korden.adapters.IntentsAdapter

enum class Intents(private val code: Int) : IntentsAdapter {

    GUILDS(1 shl 0),
    GUILD_BANS(1 shl 2),
    GUILD_EMOJIS_AND_STICKERS(1 shl 3),
    GUILD_INTEGRATIONS(1 shl 4),
    GUILD_WEBHOOKS(1 shl 5),
    GUILD_INVITES(1 shl 6),
    GUILD_VOICE_STATES(1 shl 7),
    GUILD_MESSAGES(1 shl 9),
    GUILD_MESSAGE_REACTIONS(1 shl 10),
    GUILD_MESSAGE_TYPING(1 shl 11),
    DIRECT_MESSAGES(1 shl 12),
    DIRECT_MESSAGE_REACTIONS(1 shl 13),
    DIRECT_MESSAGE_TYPING(1 shl 14),
    GUILD_SCHEDULED_EVENTS(1 shl 16),
    ;

    override fun getIdentifier() = this.code

}
