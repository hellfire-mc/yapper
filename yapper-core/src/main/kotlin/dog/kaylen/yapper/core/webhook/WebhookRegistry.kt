package dog.kaylen.yapper.core.webhook

import dog.kaylen.yapper.api.webhook.MessagePayload
import dog.kaylen.yapper.api.webhook.Webhook
import dog.kaylen.yapper.core.config.RootConfig
import dog.kaylen.yapper.core.config.WebhookConfig
import java.net.URL
import java.util.*

/**
 * A registry of all webhooks.
 */
class WebhookRegistry {
    /**
     * A map of all providers.
     */
    private val providers = mapOf(
        "discord" to DiscordWebhookProvider(),
        "telegram" to TelegramWebhookProvider()
    )

    /**
     * Load all webhooks from the config.
     */
    fun loadWebhooks(config: RootConfig) {
        config.webhooks.forEach { this.loadWebhook(it) }
    }

    /**
     * Load the given webhook.
     */
    fun loadWebhook(webhook: WebhookConfig) {
        val provider = this.providers[webhook.provider.lowercase()] ?: throw Exception("Invalid webhook provider")
        provider.registerWebhook(
            Webhook(
                URL(webhook.endpoint),
                Optional.empty(),
                webhook.disabled
            )
        )
    }

    /**
     * Trigger all webhooks in the registry.
     */
    fun push(payload: MessagePayload) {
        providers.values.forEach { it.push(payload) }
    }
}
