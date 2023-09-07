package com.tubmc.text.interaction;

import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
sealed interface IInteraction<T extends IInteractableType<?>> permits HoverInteraction, ClickInteraction {
	
	public T type();
	
}
