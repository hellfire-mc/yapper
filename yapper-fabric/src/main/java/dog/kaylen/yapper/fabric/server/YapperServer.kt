package dog.kaylen.yapper.fabric.server

import net.fabricmc.api.ModInitializer

class YapperServer : ModInitializer {
    companion object {
        lateinit var instance: YapperServer
    }

    override fun onInitialize() {
        instance = this
    }
}
