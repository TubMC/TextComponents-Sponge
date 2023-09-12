package com.tubmc.text;

import java.util.Collection;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.AbstractComponentBuilder;

import fun.bb1.objects.annotations.AllowsEmptyString;
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
 * The base of all implementations
 * <br>
 * This class provides control over how elements are initialised, allowing {@link AbstractComponentBuilder} and other utilisers to create {@link IComponent}'s without needing to know implementation specifics
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 */
@Internal
abstract class AbstractImplementation {
	/**
	 * The instance of {@link IImplementation} that is used internally for {@link IComponent} creation
	 * @since 1.0.0
	 */
	@Internal
	static @NotNull AbstractImplementation IMPLEMENTATION;
	
	AbstractImplementation() {
		if (IMPLEMENTATION != null) throw new IllegalStateException("Implementation can only be defined once!");
		IMPLEMENTATION = this;
	}
	/**
	 * @since 1.0.0
	 * @param keybind The keybind that the {@link IKeybindComponent} will use
	 * @return An {@link IKeybindComponent} with {@link IKeybindComponent#getKeybind()} set to the provided keybind
	 * @see <a href="https://minecraft.fandom.com/wiki/Controls#Configurable_controls">https://minecraft.fandom.com/wiki/Controls#Configurable_controls</a>
	 */
	@Internal
	public abstract @NotNull IKeybindComponent createKeybind(final @NotNull @DisallowsEmptyString String keybind);
	/**
	 * @since 1.0.0
	 * @param text The text the {@link ILiteralComponent} will represent
	 * @return An {@link ILiteralComponent} with {@link ILiteralComponent#getMessage()} set to the provided text
	 */
	@Internal
	public abstract @NotNull ILiteralComponent createLiteral(final @NotNull @DisallowsEmptyString String text);
	/**
	 * @since 1.0.0
	 * @param selector A selector that provides one element when queried on the client
	 * @param objective The scoreboard objective to look up
	 * @param value An optional value to display, if provided the value yielded by the selector and objective lookup will be ignored
	 * @return An {@link IScoreboardComponent} with {@link IScoreboardComponent#getSelector()} and {@link IScoreboardComponent#getObjective()} set to the provided values
	 * @see <a href="https://minecraft.fandom.com/wiki/Target_selectors">https://minecraft.fandom.com/wiki/Target_selectors</a>
	 * @see <a href="https://minecraft.fandom.com/wiki/Scoreboard#Objectives">https://minecraft.fandom.com/wiki/Scoreboard#Objectives</a>
	 */
	@Internal
	public abstract @NotNull IScoreboardComponent createScoreboard(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @Nullable @AllowsEmptyString final String value);
	/**
	 * @since 1.0.0
	 * @param selector The selector the client will look up
	 * @param seperator An optional {@link IComponent} that will be inserted (by the client) between all that match the selector
	 * @return An {@link ISelectedComponent} with {@link ISelectedComponent#getSelector()} set to its provided value
	 * @see <a href="https://minecraft.fandom.com/wiki/Target_selectors">https://minecraft.fandom.com/wiki/Target_selectors</a>
	 */
	@Internal
	public abstract @NotNull ISelectedComponent createSelector(final @NotNull @DisallowsEmptyString String selector, @Nullable final IComponent seperator);
	/**
	 * @since 1.0.0
	 * @param translationKey The translation key the client will look up
	 * @param fallback The optional value the client will use if the translationKey lookup fails
	 * @param insertions Insertions to place within the translationKey (inserted by the client)
	 * @return
	 * @see <a href="https://minecraft.fandom.com/wiki/Resource_pack#Language">https://minecraft.fandom.com/wiki/Resource_pack#Language</a>
	 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Translated_Text">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Translated_Text</a>
	 */
	@Internal
	public abstract @NotNull ITranslatableComponent createTranslatable(final @NotNull @DisallowsEmptyString String translationKey, final @Nullable @AllowsEmptyString String fallback, final @Nullable Collection<@NotNull IComponent> insertions);
}