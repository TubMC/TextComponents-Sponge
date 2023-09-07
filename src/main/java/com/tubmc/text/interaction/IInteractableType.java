package com.tubmc.text.interaction;

import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
sealed interface IInteractableType<T extends IInteraction<?>> permits ClickType, HoverType {

}
