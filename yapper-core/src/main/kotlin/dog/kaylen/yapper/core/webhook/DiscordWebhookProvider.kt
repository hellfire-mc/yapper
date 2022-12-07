package dog.kaylen.yapper.core.webhook

import com.github.kittinunf.fuel.httpPost
import dog.kaylen.yapper.api.webhook.MessagePayload
import dog.kaylen.yapper.api.webhook.WebhookResult
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DiscordWebhookProvider : BaseWebhookProvider() {
    @Serializable
    data class WebhookPayload(
        val content: String,
        val username: String,
        val avatar_url: String
    )

    override fun getServiceName(): String {
        return "Discord"
    }

    override fun push(payload: MessagePayload): WebhookResult {
        val webhookPayload = WebhookPayload(
            payload.toString(),
            payload.author.name,
            payload.author.avatarURL
        )
        // send requests
        webhooks.filter { !it.disabled }.forEach {
            it.endpoint.toString()
                .httpPost()
                .header("Content-Type", "application/json")
                .body(Json.encodeToString(webhookPayload))
                .response { _, _, _ -> run {} }
        }
        // default to ok
        return WebhookResult.OK
    }
}
