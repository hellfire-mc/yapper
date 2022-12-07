package dog.kaylen.yapper.api.webhook;

import java.io.Serializable;
import java.net.URL;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a generic webhook instance.
 *
 * @param endpoint The webhook's endpoint.
 * @param secret A secret used when sending the webhook.
 * @param disabled Whether this webhook is disabled.
 */
public record Webhook(@NotNull URL endpoint, @NotNull Optional<String> secret, boolean disabled)
        implements Serializable {}
