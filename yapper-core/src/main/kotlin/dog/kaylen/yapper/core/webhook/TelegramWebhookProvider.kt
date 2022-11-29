package dog.kaylen.yapper.core.webhook

import dog.kaylen.yapper.api.webhook.MessagePayload
import dog.kaylen.yapper.api.webhook.WebhookResult

class TelegramWebhookProvider : BaseWebhookProvider() {
    override fun getServiceName(): String {
        TODO("Not yet implemented")
    }

    override fun push(payload: MessagePayload): WebhookResult {
        TODO("Not yet implemented")
    }
}
