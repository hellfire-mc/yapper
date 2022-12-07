package dog.kaylen.yapper.core.config

import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addFileSource
import com.sksamuel.hoplite.addStreamSource
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.exists

/**
 * A generic configuration provider.
 */
class ConfigProvider(private val file: File) {
    companion object {
        /**
         * Create a new config provider from the given path.
         */
        fun fromPath(path: String): ConfigProvider {
            return fromPath(Path.of(path))
        }

        /**
         * Create a new config provider from the given path.
         */
        fun fromPath(path: Path): ConfigProvider {
            val file = path.toFile()
            // ensure the file exists
            if (!file.exists()) {
                throw NoSuchFileException(file)
            }

            return ConfigProvider(file)
        }

        /**
         * Write the default configuration to the target path.
         */
        fun writeDefaultsTo(path: String) {
            return writeDefaultsTo(Path.of(path))
        }

        /**
         * Write the default configuration to the target path.
         */
        fun writeDefaultsTo(path: Path) {
            // don't write defaults if the file exists
            if (path.exists()) {
                return
            }
            // open stream
            val stream = Companion::class.java.classLoader.getResource("yapper.defaults.toml")?.openStream()
                ?: throw Exception("Failed to find default config resource")
            // copy
            Files.copy(stream, path)
        }
    }

    private var cache: RootConfig? = null

    fun config(): RootConfig {
        if (this.cache != null) {
            return this.cache!!
        }

        // load defaults
        val stream = Companion::class.java.classLoader.getResource("yapper.defaults.toml")?.openStream()
            ?: throw Exception("Failed to find default config resource")

        this.cache = ConfigLoaderBuilder.default()
            .addFileSource(this.file)
            .addStreamSource(stream, "toml")
            .build()
            .loadConfigOrThrow()

        return this.cache!!
    }

    fun reload(): Boolean {
        val result = ConfigLoaderBuilder.default()
            .addFileSource(this.file)
            .build()
            .loadConfig<RootConfig>()
        // return false if invalid
        if (result.isInvalid()) {
            return false
        }
        this.cache = result.getUnsafe()
        return true
    }
}
