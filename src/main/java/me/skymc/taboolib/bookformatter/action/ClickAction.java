package me.skymc.taboolib.bookformatter.action;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import net.md_5.bungee.api.chat.ClickEvent;

/**
 * @author sky
 * @since 2018-03-08 22:38:04
 */
public interface ClickAction {
	
    /**
     * Get the Chat-Component action
     * @return the Chat-Component action
     */
    ClickEvent.Action action();

    /**
     * The value paired to the action
     * @return the value paired tot the action
     */
    String value();


    /**
     * Creates a command action: when the player clicks, the command passed as parameter gets executed with the clicker as sender
     * @param command the command to be executed
     * @return a new ClickAction
     */
    static ClickAction runCommand(String command) {
        return new SimpleClickAction(ClickEvent.Action.RUN_COMMAND, command);
    }

    /**
     * Creates a suggest_command action: when the player clicks, the book closes and the chat opens with the parameter written into it
     * @param command the command to be suggested
     * @return a new ClickAction
     */
    static ClickAction suggestCommand(String command) {
        return new SimpleClickAction(ClickEvent.Action.SUGGEST_COMMAND, command);
    }

    /**
     * Creates a open_utl action: when the player clicks the url passed as argument will open in the browser
     * @param url the url to be opened
     * @return a new ClickAction
     */
    static ClickAction openUrl(String url) {
        if(url.startsWith("http://") || url.startsWith("https://"))
            return new SimpleClickAction(ClickEvent.Action.OPEN_URL, url);
        else
            throw new IllegalArgumentException("Invalid url: \"" + url + "\", it should start with http:// or https://");
    }

    /**
     * Creates a change_page action: when the player clicks the book page will be set at the value passed as argument
     * @param page the new page
     * @return a new ClickAction
     */
    static ClickAction changePage(int page) {
        return new SimpleClickAction(ClickEvent.Action.CHANGE_PAGE, Integer.toString(page));
    }

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    class SimpleClickAction implements ClickAction {
        private final ClickEvent.Action action;
        private final String value;
    }
}