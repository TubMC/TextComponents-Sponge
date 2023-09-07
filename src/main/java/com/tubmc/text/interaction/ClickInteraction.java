package com.tubmc.text.interaction;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final record ClickInteraction(
		/**
		 * The {@link HoverType} to use
		 * 
		 * @since 1.0.0
		 */
		@NotNull ClickType type,
		/**
		 * @since 1.0.0
		 */
		@NotNull @DisallowsEmptyString String data) implements IInteraction<ClickType> {
}
