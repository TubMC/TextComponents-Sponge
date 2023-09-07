package com.tubmc.text;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import com.tubmc.text.interaction.ClickInteraction;
import com.tubmc.text.interaction.HoverInteraction;

/**
 *    Copyright 2023 TubMC.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
/**
 * Defines all interactive aspects of an {@link IComponent}
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see IComponent
 * @see ClickInteraction
 * @see HoverInteraction
 */
@Internal
sealed interface IInteractable permits IComponent {
	/**
	 * @since 1.0.0
	 * @return The {@link ClickInteraction} (if one is set)
	 */
	public @Nullable ClickInteraction getClicked();
	/**
	 * Replaces the current {@link ClickInteraction} with the provided one
	 * 
	 * @param interaction The {@link ClickInteraction} to use
	 * @since 1.0.0
	 */
	public void setClicked(final @Nullable ClickInteraction interaction);
	/**
	 * @since 1.0.0
	 * @return The {@link HoverInteraction} (if one is set)
	 */
	public @Nullable HoverInteraction getHovering();
	/**
	 * Replaces the current {@link HoverInteraction} with the provided one
	 * 
	 * @param interaction The {@link HoverInteraction} to use
	 * @since 1.0.0
	 */
	public void setHovering(final @Nullable HoverInteraction interaction);
	
}
