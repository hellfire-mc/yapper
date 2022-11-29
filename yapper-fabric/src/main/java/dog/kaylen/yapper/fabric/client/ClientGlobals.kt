package dog.kaylen.yapper.fabric.client

import MOD_ID
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * The client instance.
 */
val CLIENT = YapperClient.instance

/**
 * The client logging instance.
 */
val CLIENT_LOGGER: Logger = LoggerFactory.getLogger("$MOD_ID-client")
