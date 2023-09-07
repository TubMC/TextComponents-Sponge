package com.tubmc.text.interaction;

import org.jetbrains.annotations.NotNull;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final record HoverInteraction<T>(
		/**
		 * The {@link HoverType} to use
		 * 
		 * @since 1.0.0
		 */
		@NotNull HoverType<T> type,
		/**
		 * @since 1.0.0
		 */
		@NotNull @DisallowsEmptyString T data) implements IInteraction<HoverType<T>> {
}
