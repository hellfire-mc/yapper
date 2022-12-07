package dog.kaylen.yapper.fabric

import dog.kaylen.yapper.api.User
import dog.kaylen.yapper.api.webhook.MessagePayload
import dog.kaylen.yapper.core.config.ConfigProvider
import dog.kaylen.yapper.core.webhook.WebhookRegistry
import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents
import net.kyori.adventure.text.Component

class Yapper : DedicatedServerModInitializer {
    companion object {
        lateinit var instance: Yapper
    }

    /**
     * The configuration provider.
     */
    lateinit var configProvider: ConfigProvider

    /**
     * The webhook registry.
     */
    val webhookRegistry = WebhookRegistry()

    /**
     * The mod configuration.
     */
    val config get() = this.configProvider.config()

    override fun onInitializeServer() {
        instance = this
        // config path
        val configPath = FABRIC_LOADER.configDir.resolve("yapper.toml")
        ConfigProvider.writeDefaultsTo(configPath)
        // create config provider
        this.configProvider = ConfigProvider.fromPath(configPath)
        GLOBAL_LOGGER.info("Configuration provider initialized.")
        // load webhooks
        this.webhookRegistry.loadWebhooks(this.config)

        // create chat event listener - handles players
        ServerMessageEvents.CHAT_MESSAGE.register(
            ServerMessageEvents.ChatMessage { message, sender, _ ->
                // ignore non-players
                if (!sender.isPlayer) {
                    return@ChatMessage
                }
                val payload = MessagePayload(
                    User(sender.uuid, sender.name.string),
                    Component.text(message.content.string)
                )
                this.webhookRegistry.push(payload)
            }
        )

        // create command message listener - handles commands, the console, and command blocks
        ServerMessageEvents.COMMAND_MESSAGE.register(
            ServerMessageEvents.CommandMessage { message, source, _ ->
                val author = if (source.isExecutedByPlayer) {
                    User(source.player!!.uuid, source.player!!.name.toString())
                } else {
                    User.getConsoleUser()
                }
                val payload = MessagePayload(
                    author,
                    Component.text(message.content.string)
                )
                this.webhookRegistry.push(payload)
            }
        )

        ServerMessageEvents.GAME_MESSAGE.register(
            ServerMessageEvents.GameMessage { _, message, _ ->
                val author = User.getConsoleUser()
                val payload = MessagePayload(
                    author,
                    Component.text(message.string)
                )
                this.webhookRegistry.push(payload)
            }
        )

        GLOBAL_LOGGER.info("Registered event handlers")
    }
}
