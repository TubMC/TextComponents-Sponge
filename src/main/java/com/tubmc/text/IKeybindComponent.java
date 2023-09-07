package com.tubmc.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.builder.KeybindComponentBuilder;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public non-sealed interface IKeybindComponent extends IComponent {
	
	public static @NotNull IKeybindComponent of(final @NotNull @DisallowsEmptyString String keybind) {
		return AbstractImplementation.IMPLEMENTATION.createKeybind(keybind);
	}
	
	public static @NotNull KeybindComponentBuilder builder(@NotNull final String keybind) {
		return new KeybindComponentBuilder(keybind);
	}
	
	public @Nullable @DisallowsEmptyString String getKeybind();
	
	public void setKeybind(final @Nullable @DisallowsEmptyString String newKeybind);
	
}
