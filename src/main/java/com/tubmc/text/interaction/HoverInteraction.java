package com.tubmc.text.interaction;

import org.jetbrains.annotations.NotNull;

import com.tubmc.text.IComponent;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public record HoverInteraction(
		/**
		 * The {@link HoverType} to use
		 * 
		 * @since 1.0.0
		 */
		@NotNull HoverType type,
		/**
		 * @since 1.0.0
		 */
		@NotNull @DisallowsEmptyString IComponent data) implements IInteraction<HoverType> {
}
