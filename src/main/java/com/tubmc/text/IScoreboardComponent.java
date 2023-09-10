package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.ScoreboardComponentBuilder;

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
 * An {@link IComponent} that represent a scoreboard's value
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see ScoreboardComponentBuilder
 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Scoreboard_Value">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Scoreboard_Value</a>
 */
public non-sealed interface IScoreboardComponent extends IComponent, ISelectorBased {
	/**
	 * Displays the recipients score
	 * 
	 * @since 1.0.0
	 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Scoreboard_Value">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Scoreboard_Value</a>
	 */
	public static final @NotNull @DisallowsEmptyString String SELF_TARGET_SELECTOR = "*";
	/**
	 * @since 1.0.0
	 * @param selector The selector to use (must only resolve to one entity [limit=1])
	 * @param objective The objective to lookup
	 * @return An instance of {@link IScoreboardComponent}
	 */
	public static @NotNull IScoreboardComponent of(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective) {
		return AbstractImplementation.IMPLEMENTATION.createScoreboard(selector, objective, null);
	}
	/**
	 * @since 1.0.0
	 * @param selector The selector to use (must only resolve to one entity [limit=1])
	 * @param objective The objective to use
	 * @param value The value to say the objective is at for the given selector
	 * @return An instance of {@link IScoreboardComponent}
	 */
	public static @NotNull IScoreboardComponent of(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @NotNull @DisallowsEmptyString final String value) {
		return AbstractImplementation.IMPLEMENTATION.createScoreboard(selector, objective, value);
	}
	/**
	 * @since 1.0.0
	 * @param selector The selector to pass along to the builder (this cannot be changed via the builder)
	 * @param objective The objective to pass along to the builder (this cannot be changed via the builder)
	 * @return An instance of {@link ScoreboardComponentBuilder} with the selector and objective passed to it
	 */
	public static @NotNull ScoreboardComponentBuilder builder(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective) {
		return new ScoreboardComponentBuilder(selector, objective);
	}
	/**
	 * @since 1.0.0
	 * @return The objective to lookup
	 */
	public @NotNull @DisallowsEmptyString String getObjective();
	/**
	 * Sets the lookup objective
	 * 
	 * @param newObjective The new objective to lookup
	 */
	public void setObjective(final @NotNull @DisallowsEmptyString String newObjective);
	/**
	 * @apiNote When used the actual value of {@link #getObjective()} for {@link #getSelector()} is ignored
	 * 
	 * @since 1.0.0
	 * @return The value to display
	 */
	public @Nullable @DisallowsEmptyString String getValue();
	/**
	 * @since 1.0.0
	 * @param newValue The value to display
	 */
	public void setValue(final @Nullable @DisallowsEmptyString String newValue);
}