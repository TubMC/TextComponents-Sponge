package com.tubmc.text.builder;

import java.util.function.Consumer;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.IComponent;
import com.tubmc.text.IKeybindComponent;
import com.tubmc.text.ILiteralComponent;
import com.tubmc.text.IScoreboardComponent;
import com.tubmc.text.ISelectedComponent;
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
 * An {@link AbstractComponentBuilder} for building {@link ISelectedComponent}
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see AbstractComponentBuilder
 * @see ISelectedComponent
 */
public final class SelectorComponentBuilder extends AbstractComponentBuilder<SelectorComponentBuilder> {
	/**
	 * The selector to lookup
	 * 
	 * @since 1.0.0
	 * @see ISelectedComponent#of(String)
	 */
	private final @NotNull @DisallowsEmptyString String selector;
	/**
	 * The {@link IComponent} to place between each value of {@link #selector}
	 * 
	 * @since 1.0.0
	 * @see ISelectedComponent#of(String, IComponent)
	 */
	private @Nullable IComponent seperator;
	/**
	 * @param selector The selector to use
	 * @since 1.0.0
	 * @see ISelectedComponent#builder(String)
	 */
	@Internal
	public SelectorComponentBuilder(@NotNull final String selector) {
		this.selector = selector;
	}
	/**
	 * Sets {@link #selector} to the provided seperator wrapped in an {@link ILiteralComponent}
	 * 
	 * @since 1.0.0
	 * @param seperator The separator to place between all responses of {@link #selector}
	 * @return The builder instance
	 * @see ILiteralComponent
	 */
	public final @NotNull SelectorComponentBuilder seperator(@NotNull @AllowsEmptyString final String seperator) {
		this.seperator = ILiteralComponent.of(seperator);
		return this;
	}
	/**
	 * Sets {@link #selector} to the provided seperator
	 * 
	 * @since 1.0.0
	 * @param seperator The separator to place between all responses of {@link #selector}}
	 * @return The builder instance
	 */
	public final @NotNull SelectorComponentBuilder seperator(@NotNull final IComponent seperator) {
		this.seperator = seperator;
		return this;
	}
	/**
	 * Sets {@link #selector} to null
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 */
	public final @NotNull SelectorComponentBuilder defaultSeperator() {
		this.seperator = null;
		return this;
	}
	/**
	 * Sets the {@link #seperator}
	 * 
	 * @apiNote Immediately calls {@link AbstractComponentBuilder#build()} then {@link #seperator(IComponent)}
	 * @since 1.0.0
	 * @param insert The {@link ITypedBuilder} to use
	 * @return The builder instance
	 * @see #seperator(IComponent)
	 */
	private final @NotNull SelectorComponentBuilder seperator(@NotNull final ITypedBuilder<IComponent> insert) {
		this.seperator = insert.build();
		return this;
	}
	/**
	 * Sets the {@link #seperator}
	 * 
	 * @since 1.0.0
	 * @param text Passed to {@link LiteralComponentBuilder}
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link LiteralComponentBuilder}
	 * @return The builder instance
	 * @see #seperator(ITypedBuilder)
	 * @see LiteralComponentBuilder
	 * @see ILiteralComponent
	 */
	public final @NotNull SelectorComponentBuilder literalSeperator(@NotNull @DisallowsEmptyString final String text, @NotNull final Consumer<LiteralComponentBuilder> consumer) {
		final LiteralComponentBuilder builder = new LiteralComponentBuilder(text);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	/**
	 * Sets the {@link #seperator}
	 * 
	 * @since 1.0.0
	 * @param keybind Passed to {@link KeybindComponentBuilder}
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link KeybindComponentBuilder}
	 * @return The builder instance
	 * @see #seperator(ITypedBuilder)
	 * @see KeybindComponentBuilder
	 * @see IKeybindComponent
	 */
	public final @NotNull SelectorComponentBuilder keybindSeperator(@NotNull @DisallowsEmptyString final String keybind, @NotNull final Consumer<KeybindComponentBuilder> consumer) {
		final KeybindComponentBuilder builder = new KeybindComponentBuilder(keybind);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	/**
	 * Sets the {@link #seperator}
	 * 
	 * @since 1.0.0
	 * @param translationKey Passed to {@link SelectorComponentBuilder}
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link TranslatableComponentBuilder}
	 * @return The builder instance
	 * @see #seperator(ITypedBuilder)
	 * @see TranslatableComponentBuilder
	 * @see ITranslatableComponent
	 */
	public final @NotNull SelectorComponentBuilder translationSeperator(@NotNull @DisallowsEmptyString final String translationKey, @NotNull final Consumer<TranslatableComponentBuilder> consumer) {
		final TranslatableComponentBuilder builder = new TranslatableComponentBuilder(translationKey);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	/**
	 * Sets the {@link #seperator}
	 * 
	 * @since 1.0.0
	 * @param selector Passed to {@link SelectorComponentBuilder}
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link SelectorComponentBuilder}
	 * @return The builder instance
	 * @see #seperator(ITypedBuilder)
	 * @see SelectorComponentBuilder
	 * @see ISelectedComponent
	 */
	public final @NotNull SelectorComponentBuilder selectorSeperator(@NotNull @DisallowsEmptyString final String selector, @NotNull final Consumer<SelectorComponentBuilder> consumer) {
		final SelectorComponentBuilder builder = new SelectorComponentBuilder(selector);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	/**
	 * Sets the {@link #seperator}
	 * 
	 * @since 1.0.0
	 * @param selector Passed to {@link ScoreboardComponentBuilder}
	 * @param objective Passed to {@link ScoreboardComponentBuilder}
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link ScoreboardComponentBuilder}
	 * @return The builder instance
	 * @see #seperator(ITypedBuilder)
	 * @see ScoreboardComponentBuilder
	 * @see IScoreboardComponent
	 */
	public final @NotNull SelectorComponentBuilder scoreboardSeperator(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @NotNull final Consumer<ScoreboardComponentBuilder> consumer) {
		final ScoreboardComponentBuilder builder = new ScoreboardComponentBuilder(selector, objective);
		consumer.accept(builder);
		return this.seperator(builder);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final @NotNull SelectorComponentBuilder self() {
		return this;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull ISelectedComponent build() {
		if (this.seperator == null) {
			return this.applyCommon(ISelectedComponent.of(this.selector));
		}
		return this.applyCommon(ISelectedComponent.of(this.selector, this.seperator));
	}
}