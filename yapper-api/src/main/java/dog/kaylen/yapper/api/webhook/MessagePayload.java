package dog.kaylen.yapper.api.webhook;

import dog.kaylen.yapper.api.User;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.NotNull;

/** A message payload. */
public record MessagePayload(@NotNull User author, @NotNull TextComponent content) {
    @Override
    public String toString() {
        return PlainTextComponentSerializer.plainText().serialize(content);
    }
}
