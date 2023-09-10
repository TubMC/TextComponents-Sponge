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
 * Defines the behaviour that should occur when an {@link IComponent} is hovered upon
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see HoverType
 * @see IComponent#setHovering(HoverInteraction)
 * @see IComponent#getHovering()
 */
public final record HoverInteraction<T>(
		/**
		 * The {@link HoverType} to use
		 * 
		 * @since 1.0.0
		 */
		@NotNull HoverType<T> type,
		/**
		 * The data that will be used in tandem with the {@link #type}
		 * 
		 * @since 1.0.0
		 */
		@NotNull T data) implements IInteraction<HoverType<T>> {
}