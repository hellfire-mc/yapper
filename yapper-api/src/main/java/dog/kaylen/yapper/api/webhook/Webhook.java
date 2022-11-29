package dog.kaylen.yapper.api.webhook;

import java.io.Serializable;
import java.net.URL;
import java.util.Optional;

/**
 * Represents a generic webhook instance.
 *
 * @param endpoint The webhook's endpoint.
 * @param secret A secret used when sending the webhook.
 */
public record Webhook(URL endpoint, Optional<String> secret) implements Serializable {}
