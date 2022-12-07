package dog.kaylen.yapper.api.sync;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Represents an encodable data-type sendable across pub-sub.
 *
 * @param <T>
 */
public interface Encodable<T> {
    /**
     * @return The byte representation of this
     */
    ByteArrayOutputStream toBytes();

    /**
     * Decode a byte array into this type.
     *
     * @param bytes The byte array
     * @return The type.
     */
    T fromBytes(ByteArrayInputStream bytes);
}
