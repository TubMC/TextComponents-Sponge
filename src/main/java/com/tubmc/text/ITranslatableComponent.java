package com.tubmc.text;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.TranslatableComponentBuilder;

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
 * Displays the value of a translation lookup on {@link #getTranslationKey()} or its fallback ({@link #getTranslationFallback()})
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see TranslatableComponentBuilder
 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Translated_Text">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Translated_Text</a>
 */
public non-sealed interface ITranslatableComponent extends IComponent {
	/**
	 * @since 1.0.0
	 * @param translationKey The translation identifier to use
	 * @return An instance of {@link ITranslatableComponent}
	 */
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, null, null);
	}
	/**
	 * @since 1.0.0
	 * @param translationKey The translation identifier to use
	 * @param fallback The message used when {@link #getTranslationKey()} has no valid translation
	 * @return An instance of {@link ITranslatableComponent}
	 */
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey, @NotNull final String fallback) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, fallback, null);
	}
	/**
	 * @since 1.0.0
	 * @param translationKey The translation identifier to use
	 * @param fallback The message used when {@link #getTranslationKey()} has no valid translation
	 * @param inserts A new {@link Collection} of {@link IComponent}'s (for the client) to insert into the result of {@link #getTranslationKey()}
	 * @return An instance of {@link ITranslatableComponent}
	 */
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey, @NotNull final String fallback, @NotNull final Collection<IComponent> inserts) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, fallback, inserts);
	}
	/**
	 * @since 1.0.0
	 * @param translationKey The translation identifier to use
	 * @param inserts A new {@link Collection} of {@link IComponent}'s (for the client) to insert into the result of {@link #getTranslationKey()}
	 * @return An instance of {@link ITranslatableComponent}
	 */
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey, @NotNull final Collection<IComponent> inserts) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, null, inserts);
	}
	/**
	 * @since 1.0.0
	 * @param translationKey The translation identifier to pass along to the builder (this cannot be changed via the builder)
	 * @return An instance of {@link TranslatableComponentBuilder} with the translationKey passed to it
	 */
	public static @NotNull TranslatableComponentBuilder builder(@NotNull final String translationKey) {
		return new TranslatableComponentBuilder(translationKey);
	}
	/**
	 * @since 1.0.0
	 * @return The translation key the client will lookup
	 */
	public @NotNull @DisallowsEmptyString String getTranslationKey();
	/**
	 * @since 1.0.0
	 * @param newTranslationKey The translation key the client will lookup
	 */
	public void setTranslationKey(final @NotNull @DisallowsEmptyString String newTranslationKey);
	/**
	 * @since 1.0.0
	 * @return The message used when {@link #getTranslationKey()} has no valid translation
	 */
	public @Nullable @AllowsEmptyString String getTranslationFallback();
	/**
	 * @since 1.0.0
	 * @param newFallback The message used when {@link #getTranslationKey()} has no valid translation
	 */
	public void setTranslationFallback(@Nullable @AllowsEmptyString String newFallback);
	/**
	 * @since 1.0.0
	 * @return The contents placed into the {@link #getTranslationKey()}
	 * @see https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Translated_Text
	 */
	public @Nullable Collection<@NotNull IComponent> getInsertions();
	/**
	 * @since 1.0.0
	 * @param newInsertions A new {@link Collection} of {@link IComponent}'s for the client to insert into the result of {@link #getTranslationKey()}
	 */
	public void setInsertions(@NotNull final Collection<@NotNull IComponent> newInsertions);
}