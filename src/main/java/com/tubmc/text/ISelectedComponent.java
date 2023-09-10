package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.SelectorComponentBuilder;

import fun.bb1.objects.annotations.DisallowsEmptyString;

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
 * Displays all entity names that match the requested selector
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see SelectorComponentBuilder
 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Entity_Names">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Entity_Names</a>
 */
public non-sealed interface ISelectedComponent extends IComponent, ISelectorBased {
	/**
	 * @since 1.0.0
	 * @param selector The selector to use
	 * @return An instance of {@link ISelectedComponent} where {@link ISelectedComponent#getSelector()} is set to the provided selector
	 */
	public static @NotNull ISelectedComponent of(@NotNull @DisallowsEmptyString final String selector) {
		return AbstractImplementation.IMPLEMENTATION.createSelector(selector, null);
	}
	/**
	 * @since 1.0.0
	 * @param selector The selector to use
	 * @param component The separator to use
	 * @return An instance of {@link ISelectedComponent} where {@link ISelectedComponent#getSelector()} is set to the provided selector and {@link ISelectedComponent#getSeperator()} is set to the provided component
	 */
	public static @NotNull ISelectedComponent of(@NotNull @DisallowsEmptyString final String selector, @NotNull final IComponent component) {
		return AbstractImplementation.IMPLEMENTATION.createSelector(selector, component);
	}
	/**
	 * @since 1.0.0
	 * @param selector The selector to pass along to the builder (this cannot be changed via the builder)
	 * @return An instance of {@link SelectorComponentBuilder} with the selector passed to it
	 */
	public static @NotNull SelectorComponentBuilder builder(@NotNull final String selector) {
		return new SelectorComponentBuilder(selector);
	}
	/**
	 * @since 1.0.0
	 * @return The separator inserted (by the client) between all results of a {@link #getSelector()} lookup
	 */
	public @Nullable IComponent getSeperator();
	/**
	 * @since 1.0.0
	 * @param newSeperator The new separator to be inserted (by the client) between all results of {@link #getSelector()}
	 */
	public void setSeperator(final @Nullable IComponent newSeperator);
}