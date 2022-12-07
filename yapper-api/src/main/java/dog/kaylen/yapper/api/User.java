package dog.kaylen.yapper.api;

import java.util.UUID;

/**
 * An author of a message.
 *
 * @param uniqueId The unique ID of the player.
 * @param name The name of the player.
 */
public record User(UUID uniqueId, String name) {
    /**
     * @return The "CONSOLE" user.
     */
    public static User getConsoleUser() {
        return new User(UUID.fromString("f78a4d8d-d51b-4b39-98a3-230f2de0c670"), "CONSOLE");
    }

    /**
     * @return An avatar URL representing the rendered player head.
     */
    public String getAvatarURL() {
        return "https://crafatar.com/avatars/" + this.uniqueId;
    }
}
