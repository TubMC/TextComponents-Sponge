package com.tubmc.text.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.IComponent;
import com.tubmc.text.ILiteralComponent;
import com.tubmc.text.ITranslatableComponent;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;
import fun.bb1.objects.defineables.ITypedBuilder;

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
 * An {@link AbstractComponentBuilder} for building {@link ITranslatableComponent}
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see AbstractComponentBuilder
 * @see ITranslatableComponent
 */
public final class TranslatableComponentBuilder extends AbstractComponentBuilder<TranslatableComponentBuilder> {
	/**
	 * The translation to lookup
	 * 
	 * @since 1.0.0
	 * @see ITranslatableComponent#of(String)
	 */
	private final @NotNull @DisallowsEmptyString String translation;
	/**
	 * The selector to lookup
	 * 
	 * @since 1.0.0
	 * @see ITranslatableComponent#of(String, String)
	 * @see ITranslatableComponent#of(String, String, Collection)
	 */
	private @Nullable @AllowsEmptyString String fallback = null;
	/**
	 * The selector to lookup
	 * 
	 * @since 1.0.0
	 * @see ITranslatableComponent#of(String, Collection)
	 * @see ITranslatableComponent#of(String, String, Collection)
	 */
	private final @NotNull Collection<@NotNull IComponent> inserts = new ArrayList<@NotNull IComponent>();
	/**
	 * @param translation The translationKey to use
	 * @since 1.0.0
	 * @see ITranslatableComponent#builder(String)
	 */
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
	/**
	 * Clears all inserts
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 */
	public final @NotNull TranslatableComponentBuilder noInserts() {
		this.inserts.clear();
		return this;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final @NotNull TranslatableComponentBuilder self() {
		return this;
	}
	/**
	 * {@inheritDoc}
	 */
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