package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.KeybindComponentBuilder;

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
 * An {@link IComponent} that represents a keybind
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see KeybindComponentBuilder
 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Keybind">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Keybind</a>
 */
public non-sealed interface IKeybindComponent extends IComponent {
	/**
	 * @since 1.0.0
	 * @param keybind The keybind to use
	 * @return An instance of {@link IKeybindComponent} where {@link IKeybindComponent#getKeybind()} is set to the provided keybind
	 */
	public static @NotNull IKeybindComponent of(final @NotNull @DisallowsEmptyString String keybind) {
		return AbstractImplementation.IMPLEMENTATION.createKeybind(keybind);
	}
	/**
	 * @since 1.0.0
	 * @param keybind The keybind to pass along to the builder (this cannot be changed via the builder)
	 * @return An instance of {@link KeybindComponentBuilder} with the keybind passed to it
	 */
	public static @NotNull KeybindComponentBuilder builder(@NotNull final String keybind) {
		return new KeybindComponentBuilder(keybind);
	}
	/**
	 * @since 1.0.0
	 * @return The keybind this element represents
	 */
	public @Nullable @DisallowsEmptyString String getKeybind();
	/**
	 * @since 1.0.0
	 * @param newKeybind The new keybind for this element to represent
	 */
	public void setKeybind(final @Nullable @DisallowsEmptyString String newKeybind);
}