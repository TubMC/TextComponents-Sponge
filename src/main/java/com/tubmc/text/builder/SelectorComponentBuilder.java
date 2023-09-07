package com.tubmc.text.builder;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import com.tubmc.text.IComponent;
import com.tubmc.text.ILiteralComponent;
import com.tubmc.text.ISelectedComponent;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;
import fun.bb1.objects.defineables.ITypedBuilder;

public final class SelectorComponentBuilder extends AbstractComponentBuilder<SelectorComponentBuilder> {
	
	private final @NotNull @DisallowsEmptyString String selector;
	private @Nullable IComponent seperator;
	
	@Internal
	public SelectorComponentBuilder(@NotNull final String selector) {
		this.selector = selector;
	}
	
	public final @NotNull SelectorComponentBuilder seperator(@NotNull @AllowsEmptyString final String seperator) {
		this.seperator = ILiteralComponent.of(seperator);
		return this;
	}
	
	public final @NotNull SelectorComponentBuilder seperator(@NotNull final IComponent seperator) {
		this.seperator = seperator;
		return this;
	}
	
	public final @NotNull SelectorComponentBuilder defaultSeperator() {
		this.seperator = null;
		return this;
	}
	
	private final @NotNull SelectorComponentBuilder seperator(@NotNull final ITypedBuilder<IComponent> insert) {
		this.seperator = insert.build();
		return this;
	}
	
	public final @NotNull SelectorComponentBuilder literalSeperator(@NotNull @DisallowsEmptyString final String text, @NotNull final Consumer<LiteralComponentBuilder> consumer) {
		final LiteralComponentBuilder builder = new LiteralComponentBuilder(text);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	
	public final @NotNull SelectorComponentBuilder keybindSeperator(@NotNull @DisallowsEmptyString final String keybind, @NotNull final Consumer<KeybindComponentBuilder> consumer) {
		final KeybindComponentBuilder builder = new KeybindComponentBuilder(keybind);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	
	public final @NotNull SelectorComponentBuilder translationSeperator(@NotNull @DisallowsEmptyString final String translationKey, @NotNull final Consumer<SelectorComponentBuilder> consumer) {
		final SelectorComponentBuilder builder = new SelectorComponentBuilder(translationKey);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	
	public final @NotNull SelectorComponentBuilder selectorSeperator(@NotNull @DisallowsEmptyString final String selector, @NotNull final Consumer<SelectorComponentBuilder> consumer) {
		final SelectorComponentBuilder builder = new SelectorComponentBuilder(selector);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	
	public final @NotNull SelectorComponentBuilder scoreboardSeperator(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @NotNull final Consumer<ScoreboardComponentBuilder> consumer) {
		final ScoreboardComponentBuilder builder = new ScoreboardComponentBuilder(selector, objective);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	
	@Override
	protected final @NotNull SelectorComponentBuilder self() {
		return this;
	}

	@Override
	public final @NotNull ISelectedComponent build() {
		if (this.seperator == null) {
			return this.applyCommon(ISelectedComponent.of(this.selector));
		}
		return this.applyCommon(ISelectedComponent.of(this.selector, this.seperator));
	}
	
}
