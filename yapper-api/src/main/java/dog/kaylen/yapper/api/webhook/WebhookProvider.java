package dog.kaylen.yapper.api.webhook;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/** Provides support for a service using webhooks. */
public interface WebhookProvider {
    /**
     * @return The name of this service.
     */
    @NotNull String getServiceName();

    /**
     * Register the given list of webhooks.
     *
     * @param webhooks The list of webhooks.
     */
    void registerWebhooks(@NotNull List<Webhook> webhooks);

    /**
     * @return A list of loaded webhooks.
     */
    @NotNull List<Webhook> listWebhooks();

    /**
     * Push a message to this provider.
     *
     * @param payload The message to push.
     * @return A {@link WebhookResult} instance.
     */
    @NotNull WebhookResult push(@NotNull MessagePayload payload);
}
