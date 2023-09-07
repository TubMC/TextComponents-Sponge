package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.SelectorComponentBuilder;

import fun.bb1.objects.annotations.DisallowsEmptyString;

/**
 * Displays all entity names that match the requested selector
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Entity_Names">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Entity_Names</a>
 */
public non-sealed interface ISelectedComponent extends IComponent, ISelectorBased {
	
	public static @NotNull ISelectedComponent of(@NotNull @DisallowsEmptyString final String selector) {
		return IMPLEMENTATION.createSelector(selector, null);
	}
	
	public static @NotNull ISelectedComponent of(@NotNull @DisallowsEmptyString final String selector, @NotNull final IComponent component) {
		return IMPLEMENTATION.createSelector(selector, component);
	}
	
	public static @NotNull SelectorComponentBuilder builder(@NotNull final String selector) {
		return new SelectorComponentBuilder(selector);
	}
	
	public @Nullable IComponent getSeperator();
	
	public void setSeperator(final @Nullable IComponent newSeperator);

	
}
