package com.tubmc.text;

import java.util.Collection;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;

@Internal
interface IImplementation {
	
	@Internal
	public @NotNull IKeybindComponent createKeybind(final @NotNull @DisallowsEmptyString String keybind);
	
	@Internal
	public @NotNull ILiteralComponent createLiteral(final @NotNull @DisallowsEmptyString String text);
	
	@Internal
	public @NotNull IScoreboardComponent createScoreboard(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @Nullable @AllowsEmptyString final String value);
	
	@Internal
	public @NotNull ISelectedComponent createSelector(final @NotNull @DisallowsEmptyString String selector, @Nullable final IComponent seperator);
	
	@Internal
	public @NotNull ITranslatableComponent createTranslatable(final @NotNull @DisallowsEmptyString String translationKey, final @Nullable @AllowsEmptyString String fallback, final @Nullable Collection<@NotNull IComponent> insertions);
	
}
