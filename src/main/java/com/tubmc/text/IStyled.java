package com.tubmc.text;

import java.awt.Color;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import fun.bb1.objects.annotations.AllowsEmptyString;

@Internal
sealed interface IStyled permits IComponent {
	
	public @Nullable Color getColor();
	
	public void setColor(final @Nullable Color newColor);
	
	public boolean isBold();
	
	public boolean setBold(final boolean isBold);
	
	public boolean isItalic();
	
	public boolean setItalic(final boolean isItalic);
	
	public boolean isUnderlined();
	
	public boolean setUnderlined(final boolean isUnderlined);
	
	public boolean isStrikedThrough();
	
	public boolean setStrikeThrough(final boolean isStrikedThrough);
	
	public boolean isObfuscated();
	
	public boolean setObfuscated(final boolean isObfuscated);
	
	public @Nullable @AllowsEmptyString String getFont();
	
	public void setFont(final @Nullable @AllowsEmptyString String newFont);
	
}
