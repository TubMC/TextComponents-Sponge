package com.tubmc.text.builder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

import com.tubmc.text.ILiteralComponent;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final class LiteralComponentBuilder extends AbstractComponentBuilder<LiteralComponentBuilder> {
	
	private final @NotNull @DisallowsEmptyString String text;
	
	@Internal
	public LiteralComponentBuilder(@NotNull final String text) {
		this.text = text;
	}
	
	@Override
	protected final @NotNull LiteralComponentBuilder self() {
		return this;
	}

	@Override
	public final @NotNull ILiteralComponent build() {
		return this.applyCommon(ILiteralComponent.of(this.text));
	}
	
}
