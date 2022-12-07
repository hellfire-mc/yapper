package dog.kaylen.yapper.core.config

/**
 * The root configuration file.
 */
data class RootConfig(
    /**
     * The version of the configuration.
     */
    val version: Int,
    /**
     * A list of webhook configurations.
     */
    val webhooks: List<WebhookConfig>
)
