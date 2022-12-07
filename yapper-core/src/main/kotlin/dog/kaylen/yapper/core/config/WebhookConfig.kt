package dog.kaylen.yapper.core.config

/**
 * A webhook configuration entry.
 */
data class WebhookConfig(
    /**
     * The provider.
     */
    val provider: String,
    /**
     * The webhook endpoint
     */
    val endpoint: String,
    /**
     * Whether this webhook is disabled.
     */
    val disabled: Boolean = false
)
