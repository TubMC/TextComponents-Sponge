package com.tubmc.text;

import java.util.Collection;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
 * The base of all components, holds common logic and methods
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see IKeybindComponent
 * @see ILiteralComponent
 * @see IScoreboardComponent
 * @see ISelectedComponent
 * @see ITranslatableComponent
 */
public sealed interface IComponent extends Cloneable, IStyled, IInteractable, ImplementationSpecificComponentMethods permits ITranslatableComponent, IScoreboardComponent, ISelectedComponent, IKeybindComponent, ILiteralComponent, ImplementationComponentBase {
	/**
	 * Conjoins two {@link IComponent}'s into one
	 * 
	 * @since 1.0.0
	 * @param firstComponent
	 * @param secondComponent
	 * @return An {@link IComponent} with the provided {@link IComponent}'s as it's children
	 */
	public static @NotNull IComponent union(@NotNull final IComponent firstComponent, @NotNull final IComponent secondComponent) {
		final IComponent ret = AbstractImplementation.IMPLEMENTATION.createLiteral("");
		ret.setChildren(List.of(firstComponent, secondComponent));
		return ret;
	}
	/**
	 * @since 1.0.0
	 * @return This {@link IComponent}'s children
	 */
	public @Nullable Collection<@NotNull IComponent> getChildren();
	/**
	 * Overrides the defined children of this {@link IComponent}
	 * 
	 * @since 1.0.0
	 */
	public void setChildren(@NotNull final Collection<@NotNull IComponent> newChildrenComponents);
	/**
	 * Creates a shallow clone of this object
	 * 
	 * @return A shallow clone of this element
	 * @see #deepClone()
	 */
	public @NotNull IComponent clone();
	/**
	 * @return A deep clone of this object and it's children
	 */
	public default @NotNull IComponent deepClone() {
		final IComponent toReturn = this.clone();
		toReturn.setChildren(this.getChildren().stream().map(IComponent::deepClone).toList());
		return toReturn;
	}
}