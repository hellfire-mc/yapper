package dog.kaylen.yapper.api.webhook;

import lombok.Getter;

/** An exception thrown during webhook registration. */
public class WebhookRegistrationException extends RuntimeException {
    /** The provider involved in registration. */
    @Getter private final WebhookProvider provider;
    /** The webhook which failed registration. */
    @Getter private final Webhook webhook;

    /**
     * Create a new exception instance.
     *
     * @param provider The provider involved in registration.
     * @param webhook The webhook which failed registration
     */
    public WebhookRegistrationException(WebhookProvider provider, Webhook webhook) {
        this.provider = provider;
        this.webhook = webhook;
    }

    @Override
    public String getMessage() {
        return String.format(
                "The service %s threw an error while registering webhook at '%s'",
                this.provider.getServiceName(), this.webhook.endpoint().toString());
    }
}
