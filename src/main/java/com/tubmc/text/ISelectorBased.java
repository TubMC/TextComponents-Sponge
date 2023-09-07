package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

import fun.bb1.objects.annotations.DisallowsEmptyString;

@Internal
sealed interface ISelectorBased permits IScoreboardComponent, ISelectedComponent {
	
	public @NotNull @DisallowsEmptyString String getSelector();
	
	public void setSelector(final @NotNull @DisallowsEmptyString String newSelector);
	
}
