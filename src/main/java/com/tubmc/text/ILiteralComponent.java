package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.LiteralComponentBuilder;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;

public non-sealed interface ILiteralComponent extends IComponent {
	
	public static @NotNull ILiteralComponent of(final @NotNull @AllowsEmptyString String text) {
		return IMPLEMENTATION.createLiteral(text);
	}
	
	public static @NotNull LiteralComponentBuilder builder(@NotNull final String text) {
		return new LiteralComponentBuilder(text);
	}
	
	public @Nullable @DisallowsEmptyString String getMessage();
	
	public void setMessage(final @Nullable @DisallowsEmptyString String newMessage);
	
}
