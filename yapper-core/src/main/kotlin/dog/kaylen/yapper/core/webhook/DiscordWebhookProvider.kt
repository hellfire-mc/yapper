package dog.kaylen.yapper.core.webhook

import dog.kaylen.yapper.api.webhook.MessagePayload
import dog.kaylen.yapper.api.webhook.WebhookResult

class DiscordWebhookProvider : BaseWebhookProvider() {
    override fun getServiceName(): String {
        return "Discord"
    }

    override fun push(payload: MessagePayload): WebhookResult {
        TODO("Not yet implemented")
    }
}
