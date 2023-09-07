package com.tubmc.text.interaction;

import org.jetbrains.annotations.NotNull;

import com.tubmc.text.IComponent;

public final class HoverType<T> implements IInteractableType<HoverInteraction<T>> {
	/**
	 * Displays information about the entity 
	 * 
	 * @since 1.0.0
	 */
	public static final @NotNull HoverType<EntityHoverData> ENTITY = new HoverType<EntityHoverData>();
	public static final @NotNull HoverType<ItemHoverData> ITEM = new HoverType<ItemHoverData>();
	public static final @NotNull HoverType<IComponent> TEXT = new HoverType<IComponent>();
	
	private HoverType() { }
}
