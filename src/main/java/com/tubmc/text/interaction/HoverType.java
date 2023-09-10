package com.tubmc.text.interaction;

import org.jetbrains.annotations.NotNull;

import com.tubmc.text.IComponent;

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
 * Lists actions that can occur when an {@link IComponent} is hovered upon
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see HoverInteraction
 */
public final class HoverType<T> implements IInteractableType<HoverInteraction<T>> {
	/**
	 * Displays information about the entity specified
	 * 
	 * @see EntityHoverData
	 * @since 1.0.0
	 */
	public static final @NotNull HoverType<EntityHoverData> ENTITY = new HoverType<EntityHoverData>();
	/**
	 * Displays information about the item specified
	 * 
	 * @see ItemHoverData
	 * @since 1.0.0
	 */
	public static final @NotNull HoverType<ItemHoverData> ITEM = new HoverType<ItemHoverData>();
	/**
	 * Displays the text specified
	 * 
	 * @see IComponent
	 * @since 1.0.0
	 */
	public static final @NotNull HoverType<IComponent> TEXT = new HoverType<IComponent>();
	
	private HoverType() { }
}