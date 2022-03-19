package fr.misterassm.korden.serializers

import fr.misterassm.korden.models.enums.GatewayOpCodes
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object GatewayOpCodesSerializer : KSerializer<GatewayOpCodes> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("op", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): GatewayOpCodes = GatewayOpCodes.values()
        .firstOrNull { it.code == decoder.decodeInt() } ?: GatewayOpCodes.UNKNOWN

    override fun serialize(encoder: Encoder, value: GatewayOpCodes) = encoder.encodeInt(value.code)
}
