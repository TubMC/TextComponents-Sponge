package com.tubmc.text.builder;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.IScoreboardComponent;

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
 * An {@link AbstractComponentBuilder} for building {@link IScoreboardComponent}
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see AbstractComponentBuilder
 * @see IScoreboardComponent
 */
public final class ScoreboardComponentBuilder extends AbstractComponentBuilder<ScoreboardComponentBuilder> {
	/**
	 * The selector to lookup
	 * 
	 * @since 1.0.0
	 * @see IScoreboardComponent#of(String, String)
	 */
	private final @NotNull @DisallowsEmptyString String selector;
	/**
	 * The object to lookup
	 * 
	 * @since 1.0.0
	 * @see IScoreboardComponent#of(String, String)
	 */
	private final @NotNull @DisallowsEmptyString String objective;
	/**
	 * The value to display
	 * 
	 * @since 1.0.0
	 * @see IScoreboardComponent#of(String, String, String)
	 */
	private @Nullable @AllowsEmptyString String value = null;
	/**
	 * @param selector The selector to use
	 * @param objective The objective to use
	 * @since 1.0.0
	 * @see IScoreboardComponent#builder(String)
	 */
	@Internal
	public ScoreboardComponentBuilder(@NotNull final String selector, @NotNull final String objective) {
		this.selector = selector;
		this.objective = objective;
	}
	/**
	 * Sets {@link #value} to the provided value
	 * 
	 * @since 1.0.0
	 * @param value The new {@link #value} to display
	 * @return The builder instance
	 */
	public final @NotNull ScoreboardComponentBuilder value(@NotNull @AllowsEmptyString final String value) {
		this.value = value;
		return this;
	}
	/**
	 * Sets {@link #value} to null
	 * 
	 * @since 1.0.0
	 * @param value The new {@link #value} to display
	 * @return The builder instance
	 */
	public final @NotNull ScoreboardComponentBuilder noValue() {
		this.value = null;
		return this;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final @NotNull ScoreboardComponentBuilder self() {
		return this;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull IScoreboardComponent build() {
		if (this.value == null || this.value.length() == 0) {
			return this.applyCommon(IScoreboardComponent.of(this.selector, this.objective));
		}
		return this.applyCommon(IScoreboardComponent.of(this.selector, this.objective, this.value));
	}
}