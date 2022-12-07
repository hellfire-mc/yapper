package dog.kaylen.yapper.core.webhook

import dog.kaylen.yapper.api.webhook.Webhook
import dog.kaylen.yapper.api.webhook.WebhookProvider

abstract class BaseWebhookProvider : WebhookProvider {
    protected val webhooks = mutableListOf<Webhook>()

    override fun listWebhooks(): List<Webhook> {
        return this.webhooks
    }

    override fun registerWebhook(webhook: Webhook) {
        this.webhooks.add(webhook)
    }
}
