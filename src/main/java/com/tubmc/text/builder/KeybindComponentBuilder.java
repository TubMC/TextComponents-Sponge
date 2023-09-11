package com.tubmc.text.builder;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import com.tubmc.text.IKeybindComponent;

import fun.bb1.objects.annotations.DisallowsEmptyString;

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
 * An {@link AbstractComponentBuilder} for building {@link IKeybindComponent}
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see AbstractComponentBuilder
 * @see IKeybindComponent
 */
public final class KeybindComponentBuilder extends AbstractComponentBuilder<KeybindComponentBuilder> {
	/**
	 * The keybind to use
	 * 
	 * @since 1.0.0
	 * @see IKeybindComponent#of(String)
	 */
	private final @NotNull @DisallowsEmptyString String keybind;
	/**
	 * @param keybind The keybind to use
	 * @since 1.0.0
	 * @see IKeybindComponent#builder(String)
	 */
	@Internal
	public KeybindComponentBuilder(@NotNull final String keybind) {
		this.keybind = keybind;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final @NotNull KeybindComponentBuilder self() {
		return this;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final @NotNull IKeybindComponent build() {
		return this.applyCommon(IKeybindComponent.of(this.keybind));
	}
}