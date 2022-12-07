package dog.kaylen.yapper.core.webhook

import dog.kaylen.yapper.api.webhook.MessagePayload
import dog.kaylen.yapper.api.webhook.WebhookResult

class TelegramWebhookProvider : BaseWebhookProvider() {
    override fun getServiceName(): String {
        return "Telegram"
    }

    override fun push(payload: MessagePayload): WebhookResult {
        return WebhookResult.ERROR
    }
}
