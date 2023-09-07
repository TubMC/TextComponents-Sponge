package com.tubmc.text;

import java.util.Collection;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;

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
	
	@Internal
	public abstract @NotNull IKeybindComponent createKeybind(final @NotNull @DisallowsEmptyString String keybind);
	
	@Internal
	public abstract @NotNull ILiteralComponent createLiteral(final @NotNull @DisallowsEmptyString String text);
	
	@Internal
	public abstract @NotNull IScoreboardComponent createScoreboard(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @Nullable @AllowsEmptyString final String value);
	
	@Internal
	public abstract @NotNull ISelectedComponent createSelector(final @NotNull @DisallowsEmptyString String selector, @Nullable final IComponent seperator);
	
	@Internal
	public abstract @NotNull ITranslatableComponent createTranslatable(final @NotNull @DisallowsEmptyString String translationKey, final @Nullable @AllowsEmptyString String fallback, final @Nullable Collection<@NotNull IComponent> insertions);
	
}
