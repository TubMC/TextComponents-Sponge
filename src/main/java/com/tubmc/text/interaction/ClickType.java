package com.tubmc.text.interaction;

public enum ClickType implements IInteractableType<ClickInteraction> {
	/**
	 * Executes the command {@link ClickInteraction#data()}
	 * 
	 * @since 1.0.0
	 */
	EXECUTE,
	/**
	 * Suggests the command {@link ClickInteraction#data()} for execution
	 * 
	 * @since 1.0.0
	 */
	SUGGEST,
	/**
	 * Opens the {@link ClickInteraction#data()} in the users web-browser
	 * 
	 * @since 1.0.0
	 */
	OPEN_URL,
	/**
	 * Goes to the page {@link ClickInteraction#data()}
	 * 
	 * @since 1.0.0
	 * 
	 * @apiNote This only works if the player is in a book interface
	 */
	GOTO_PAGE,
	/**
	 * Copies the {@link ClickInteraction#data()} to the clipboard
	 * 
	 * @since 1.0.0
	 */
	CLIPBOARD,
	/**
	 * Here for compatibility
	 * 
	 * @apiNote For security reasons the client ignores these
	 * 
	 * @since 1.0.0
	 * @deprecated
	 */
	@Deprecated
	OPEN_FILE
	;
}
