package fr.misterassm.korden.models.enums

import fr.misterassm.korden.models.enums.ClientAction.*
import fr.misterassm.korden.serializers.GatewayOpCodesSerializer

/**
 * All gateway events in Discord are tagged with an opcode that denotes the payload type.
 * Your connection to our gateway may also sometimes close. When it does, you will receive a close code that tells you what happened.
 */
@kotlinx.serialization.Serializable(with = GatewayOpCodesSerializer::class)
enum class GatewayOpCodes(
    val code: Int,
    val clientAction: ClientAction,
) {

    /**
     * Unknown code. Is it up to date ?
     */
    UNKNOWN(Int.MIN_VALUE, ClientAction.UNKNOWN),

    /**
     * 	An event was dispatched.
     */
    DISPATCH(0, RECEIVE),

    /**
     * 	Fired periodically by the client to keep the connection alive.
     */
    HEARTBEAT(1, SEND_AND_RECEIVE),

    /**
     * Starts a new session during the initial handshake.
     */
    IDENTIFY(2, SEND),

    /**
     * 	Update the client's presence.
     */
    PRESENCE_UPDATE(3, SEND),

    /**
     * 	Used to join/leave or move between voice channels.
     */
    VOICE_STATE_UPDATE(4, SEND),

    /**
     * Resume a previous session that was disconnected.
     */
    RESUME(6, SEND),

    /**
     * You should attempt to reconnect and resume immediately.
     */
    RECONNECT(7, RECEIVE),

    /**
     * Request information about offline guild members in a large guild.
     */
    REQUEST_GUILD_MEMBERS(8, SEND),

    /**
     * The session has been invalidated. You should reconnect and identify/resume accordingly.
     */
    INVALID_SESSION(9, RECEIVE),

    /**
     * 	Sent immediately after connecting, contains the ``heartbeat_interval`` to use.
     */
    HELLO(10, RECEIVE),

    /**
     * 	Sent in response to receiving a heartbeat to acknowledge that it has been received.
     */
    HEARTBEAT_ACK(11, RECEIVE)

}
