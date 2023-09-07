package com.tubmc.text.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import com.tubmc.text.IComponent;
import com.tubmc.text.ILiteralComponent;
import com.tubmc.text.ITranslatableComponent;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;
import fun.bb1.objects.defineables.ITypedBuilder;

public final class TranslatableComponentBuilder extends AbstractComponentBuilder<TranslatableComponentBuilder> {
	
	private final @NotNull @DisallowsEmptyString String translation;
	private @Nullable @AllowsEmptyString String fallback;
	private final @NotNull Collection<@NotNull IComponent> inserts = new ArrayList<@NotNull IComponent>();
	
	@Internal
	public TranslatableComponentBuilder(@NotNull final String translation) {
		this.translation = translation;
	}
	
	public final @NotNull TranslatableComponentBuilder fallbackTo(@NotNull @DisallowsEmptyString final String fallback) {
		this.fallback = fallback;
		return this;
	}
	
	public final @NotNull TranslatableComponentBuilder noFallback() {
		this.fallback = null;
		return this;
	}
	
	public final @NotNull TranslatableComponentBuilder insert(@NotNull @DisallowsEmptyString final String insert) {
		this.inserts.add(ILiteralComponent.of(insert));
		return this;
	}
	
	public final @NotNull TranslatableComponentBuilder insert(@NotNull final IComponent insert) {
		this.inserts.add(insert);
		return this;
	}
	
	private final @NotNull TranslatableComponentBuilder insert(@NotNull final ITypedBuilder<IComponent> insert) {
		this.inserts.add(insert.build());
		return this;
	}
	
	public final @NotNull TranslatableComponentBuilder insertLiteral(@NotNull @DisallowsEmptyString final String text, @NotNull final Consumer<LiteralComponentBuilder> consumer) {
		final LiteralComponentBuilder builder = new LiteralComponentBuilder(text);
		consumer.accept(builder);
		return this.insert(builder);
	}
	
	public final @NotNull TranslatableComponentBuilder insertKeybind(@NotNull @DisallowsEmptyString String keybind, Consumer<KeybindComponentBuilder> consumer) {
		final KeybindComponentBuilder builder = new KeybindComponentBuilder(keybind);
		consumer.accept(builder);
		return this.insert(builder);
	}
	
	public final @NotNull TranslatableComponentBuilder insertTranslation(@NotNull @DisallowsEmptyString String translationKey, Consumer<TranslatableComponentBuilder> consumer) {
		final TranslatableComponentBuilder builder = new TranslatableComponentBuilder(translationKey);
		consumer.accept(builder);
		return this.insert(builder);
	}
	
	public final @NotNull TranslatableComponentBuilder insertSelector(@NotNull @DisallowsEmptyString String selector, Consumer<SelectorComponentBuilder> consumer) {
		final SelectorComponentBuilder builder = new SelectorComponentBuilder(selector);
		consumer.accept(builder);
		return this.insert(builder);
	}
	
	public final @NotNull TranslatableComponentBuilder insertScoreboard(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @NotNull final Consumer<ScoreboardComponentBuilder> consumer) {
		final ScoreboardComponentBuilder builder = new ScoreboardComponentBuilder(selector, objective);
		consumer.accept(builder);
		return this;
	}
	
	public final @NotNull TranslatableComponentBuilder noInserts() {
		this.inserts.clear();
		return this;
	}
	
	@Override
	protected final @NotNull TranslatableComponentBuilder self() {
		return this;
	}

	@Override
	public final @NotNull ITranslatableComponent build() {
		if (this.inserts.size() == 0) {
			if (this.fallback == null) {
				return this.applyCommon(ITranslatableComponent.of(this.translation));
			}
			return this.applyCommon(ITranslatableComponent.of(this.translation, this.fallback));
		}
		if (this.fallback == null) {
			return this.applyCommon(ITranslatableComponent.of(this.translation, this.inserts));
		}
		return this.applyCommon(ITranslatableComponent.of(this.translation, this.fallback, this.inserts));
	}
	
}
