package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.ScoreboardComponentBuilder;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public non-sealed interface IScoreboardComponent extends IComponent, ISelectorBased {
	/**
	 * Displays the recipients score
	 * 
	 * @since 1.0.0
	 * @see <a href="https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Scoreboard_Value">https://minecraft.fandom.com/wiki/Raw_JSON_text_format#Scoreboard_Value</a>
	 */
	public static final @NotNull @DisallowsEmptyString String SELF_TARGET_SELECTOR = "*";
	
	public static @NotNull IScoreboardComponent of(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective) {
		return IMPLEMENTATION.createScoreboard(selector, objective, null);
	}
	
	public static @NotNull IScoreboardComponent of(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @NotNull @DisallowsEmptyString final String value) {
		return IMPLEMENTATION.createScoreboard(selector, objective, value);
	}
	
	public static @NotNull ScoreboardComponentBuilder builder(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective) {
		return new ScoreboardComponentBuilder(selector, objective);
	}
	
	public @NotNull @DisallowsEmptyString String getObjective();
	
	public void setObjective(final @NotNull @DisallowsEmptyString String newObjective);
	/**
	 * @apiNote When used the actual value of {@link #getObjective()} for {@link #getSelector()} is ignored
	 * 
	 * @return The value to display
	 */
	public @Nullable @DisallowsEmptyString String getValue();
	
	public void setValue(final @Nullable @DisallowsEmptyString String newValue);
	
}
