package dog.kaylen.yapper.fabric.main

import net.fabricmc.api.ModInitializer

class Yapper : ModInitializer {
    companion object {
        lateinit var instance: Yapper
    }

    override fun onInitialize() {
        instance = this
    }
}
