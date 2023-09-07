package com.tubmc.text.interaction;

public enum HoverType implements IInteractableType<HoverInteraction> {
	/**
	 * Displays information about the entity 
	 * 
	 * @since 1.0.0
	 */
	ENTITY,
	ITEM,
	TEXT,
	;
}
