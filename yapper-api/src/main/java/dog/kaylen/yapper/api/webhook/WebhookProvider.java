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
     * Register the target webhook.
     *
     * @param webhook The webhook being registered.
     */
    void registerWebhook(@NotNull Webhook webhook);

    /**
     * Register the given list of webhooks.
     *
     * @param webhooks The list of webhooks.
     */
    default void registerWebhooks(@NotNull List<Webhook> webhooks) {
        webhooks.forEach(this::registerWebhook);
    }

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
