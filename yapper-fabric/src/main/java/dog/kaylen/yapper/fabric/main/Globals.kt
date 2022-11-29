import net.fabricmc.loader.api.FabricLoader
import org.slf4j.LoggerFactory

/**
 * The mod ID.
 */
const val MOD_ID = "yapper"

/**
 * The mod metadata.
 */
val MOD_METADATA get() = FabricLoader.getInstance().getModContainer(MOD_ID).get().metadata

/**
 * The global logging instance.
 */
val GLOBAL_LOGGER = LoggerFactory.getLogger(MOD_ID)
