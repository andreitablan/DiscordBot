package exceptions;

import net.dv8tion.jda.api.entities.MessageChannel;

public class QuestionNotFoundException extends Exception {
    /**
     * The exception for not finding a question in the database.
     *
     * @param msgString The message from the user.
     * @param channel   The channel where the message is sent.
     */
    public QuestionNotFoundException(String msgString, MessageChannel channel) {
        channel.sendMessage("There is no definition for \"" + msgString + "\" in the database.").queue();
    }
}
