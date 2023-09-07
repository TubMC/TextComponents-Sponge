package com.tubmc.text;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import com.tubmc.text.interaction.ClickInteraction;
import com.tubmc.text.interaction.HoverInteraction;

@Internal
sealed interface IInteractable permits IComponent {
	
	public @Nullable ClickInteraction getClicked();
	
	public void setClicked(final @Nullable ClickInteraction interaction);
	
	public @Nullable HoverInteraction getHovering();
	
	public void setHovering(final @Nullable HoverInteraction interaction);
	
}
