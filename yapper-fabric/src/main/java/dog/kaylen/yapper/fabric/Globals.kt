package dog.kaylen.yapper.fabric

import net.fabricmc.loader.api.FabricLoader
import org.slf4j.LoggerFactory

/**
 * The mod ID.
 */
const val MOD_ID = "yapper"

/**
 * The Fabric instance.
 */
val FABRIC_LOADER get() = FabricLoader.getInstance()

/**
 * The mod container.
 */
val MOD_CONTAINER get() = FabricLoader.getInstance().getModContainer(MOD_ID).get()

/**
 * The mod metadata.
 */
val MOD_METADATA get() = MOD_CONTAINER.metadata

/**
 * The global logging instance.
 */
val GLOBAL_LOGGER = LoggerFactory.getLogger(MOD_ID)
