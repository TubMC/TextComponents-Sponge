package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.LiteralComponentBuilder;

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
 * An {@link IComponent} that represents some text
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see LiteralComponentBuilder
 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Plain_Text">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Plain_Text</a>
 */
public non-sealed interface ILiteralComponent extends IComponent {
	/**
	 * @since 1.0.0
	 * @param text The message to use
	 * @return An instance of {@link ILiteralComponent} where {@link ILiteralComponent#getMessage()} is set to the provided text
	 */
	public static @NotNull ILiteralComponent of(final @NotNull @AllowsEmptyString String text) {
		return AbstractImplementation.IMPLEMENTATION.createLiteral(text);
	}
	/**
	 * @since 1.0.0
	 * @param text The text to pass along to the builder (this cannot be changed via the builder)
	 * @return An instance of {@link LiteralComponentBuilder} with the text passed to it
	 */
	public static @NotNull LiteralComponentBuilder builder(@NotNull final String text) {
		return new LiteralComponentBuilder(text);
	}
	/**
	 * @since 1.0.0
	 * @return The text this component represents
	 */
	public @Nullable @DisallowsEmptyString String getMessage();
	/**
	 * @since 1.0.0
	 * @param newMessage The new message this components represents
	 */
	public void setMessage(final @Nullable @DisallowsEmptyString String newMessage);
}