package dog.kaylen.yapper.fabric.client

import MOD_METADATA
import net.fabricmc.api.ClientModInitializer

class YapperClient : ClientModInitializer {
    companion object {
        lateinit var instance: YapperClient
    }

    override fun onInitializeClient() {
        instance = this
        CLIENT_LOGGER.info("Initializing Yapper v${MOD_METADATA.version}")
    }
}
