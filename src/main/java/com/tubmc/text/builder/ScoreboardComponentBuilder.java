package com.tubmc.text.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import com.tubmc.text.IScoreboardComponent;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;

public final class ScoreboardComponentBuilder extends AbstractComponentBuilder<ScoreboardComponentBuilder> {
	
	private final @NotNull @DisallowsEmptyString String selector;
	private final @NotNull @DisallowsEmptyString String objective;
	private @Nullable @AllowsEmptyString String value;
	
	@Internal
	public ScoreboardComponentBuilder(@NotNull final String selector, @NotNull final String objective) {
		this.selector = selector;
		this.objective = objective;
	}
	
	public final @NotNull ScoreboardComponentBuilder value(@NotNull @AllowsEmptyString final String value) {
		this.value = value;
		return this;
	}
	
	public final @NotNull ScoreboardComponentBuilder noValue() {
		this.value = null;
		return this;
	}
	
	@Override
	protected final @NotNull ScoreboardComponentBuilder self() {
		return this;
	}

	@Override
	public final @NotNull IScoreboardComponent build() {
		if (this.value == null || this.value.length() == 0) {
			return this.applyCommon(IScoreboardComponent.of(this.selector, this.objective));
		}
		return this.applyCommon(IScoreboardComponent.of(this.selector, this.objective, this.value));
	}
	
}
