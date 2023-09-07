package com.tubmc.text;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.TranslatableComponentBuilder;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;

public non-sealed interface ITranslatableComponent extends IComponent {
	
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, null, null);
	}
	
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey, @NotNull final String fallback) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, fallback, null);
	}
	
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey, @NotNull final String fallback, @NotNull final Collection<IComponent> inserts) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, fallback, inserts);
	}
	
	public static @NotNull ITranslatableComponent of(@NotNull final String translationKey, @NotNull final Collection<IComponent> inserts) {
		return AbstractImplementation.IMPLEMENTATION.createTranslatable(translationKey, null, inserts);
	}
	
	public static @NotNull TranslatableComponentBuilder builder(@NotNull final String translationKey) {
		return new TranslatableComponentBuilder(translationKey);
	}
	
	public @NotNull @DisallowsEmptyString String getTranslationKey();
	
	public void setTranslationKey(final @NotNull @DisallowsEmptyString String newTranslationKey);
	/**
	 * @return The message used when {@link #getTranslationKey()} has no valid translation
	 */
	public @Nullable @AllowsEmptyString String getTranslationFallback();
	
	public void setTranslationFallback(@Nullable @AllowsEmptyString String newFallback);
	/**
	 * @return The contents placed into the {@link #getTranslationKey()}
	 * @see https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Translated_Text
	 */
	public @Nullable Collection<@NotNull IComponent> getInsertions();
	
	public void setInsertions(@NotNull final Collection<@NotNull IComponent> newInsertions);
	
}
