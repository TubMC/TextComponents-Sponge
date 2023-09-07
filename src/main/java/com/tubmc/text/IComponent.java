package com.tubmc.text;

import java.util.Collection;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public sealed interface IComponent extends Cloneable, IStyled, IInteractable permits ITranslatableComponent, IScoreboardComponent, ISelectedComponent, IKeybindComponent, ILiteralComponent {
	
	static IImplementation IMPLEMENTATION = null;
	
	public static @NotNull IComponent union(@NotNull final IComponent firstComponent, @NotNull final IComponent secondComponent) {
		final IComponent ret = IMPLEMENTATION.createLiteral("");
		ret.setChildren(List.of(firstComponent, secondComponent));
		return ret;
	}
	
	public @Nullable Collection<@NotNull IComponent> getChildren();
	
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
