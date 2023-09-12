package com.tubmc.text.interaction;

import com.tubmc.text.IComponent;

/**
 *    Copyright 2023 TubMC.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
/**
 * Lists actions that can occur when an {@link IComponent} is clicked
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see ClickInteraction
 */
public enum ClickType {
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