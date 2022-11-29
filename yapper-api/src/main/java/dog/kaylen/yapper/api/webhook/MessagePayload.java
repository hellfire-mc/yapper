package dog.kaylen.yapper.api.webhook;

import dog.kaylen.yapper.api.User;
import net.kyori.adventure.text.TextComponent;
import org.jetbrains.annotations.NotNull;

/** A message payload. */
public record MessagePayload(@NotNull User author, @NotNull TextComponent content) {}
