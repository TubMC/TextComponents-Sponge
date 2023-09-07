package com.tubmc.text.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

import com.tubmc.text.IKeybindComponent;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final class KeybindComponentBuilder extends AbstractComponentBuilder<KeybindComponentBuilder> {
	
	private final @NotNull @DisallowsEmptyString String keybind;
	
	@Internal
	public KeybindComponentBuilder(@NotNull final String keybind) {
		this.keybind = keybind;
	}
	
	@Override
	protected final @NotNull KeybindComponentBuilder self() {
		return this;
	}

	@Override
	public final @NotNull IKeybindComponent build() {
		return this.applyCommon(IKeybindComponent.of(this.keybind));
	}
	
}
