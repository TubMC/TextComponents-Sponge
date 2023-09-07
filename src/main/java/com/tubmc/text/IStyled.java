package com.tubmc.text;

import java.awt.Color;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

import fun.bb1.objects.annotations.AllowsEmptyString;

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
 * Defines all stylistic aspects of an {@link IComponent}
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see IComponent
 */
@Internal
sealed interface IStyled permits IComponent {
	
	public @Nullable Color getColor();
	
	public void setColor(final @Nullable Color newColor);
	/**
	 * @since 1.0.0
	 * @return If this text will display as bold
	 */
	public boolean isBold();
	
	public void setBold(final boolean isBold);
	/**
	 * @since 1.0.0
	 * @return If this text will display as italicised
	 */
	public boolean isItalic();
	
	public void setItalic(final boolean isItalic);
	/**
	 * @since 1.0.0
	 * @return If this text will display as underlined
	 */
	public boolean isUnderlined();
	
	public void setUnderlined(final boolean isUnderlined);
	/**
	 * @since 1.0.0
	 * @return If this text will display with a line through it
	 */
	public boolean isStrikedThrough();
	
	public void setStrikeThrough(final boolean isStrikedThrough);
	/**
	 * @since 1.0.0
	 * @return If this text will be displayed randomly
	 * @see <a href="https://www.minecraftforum.net/forums/minecraft-java-edition/redstone-discussion-and/commands-command-blocks-and/2766692-obfuscation-in-entity-names#c6">https://www.minecraftforum.net/forums/minecraft-java-edition/redstone-discussion-and/commands-command-blocks-and/2766692-obfuscation-in-entity-names#c6</a>
	 */
	public boolean isObfuscated();
	
	public void setObfuscated(final boolean isObfuscated);
	/**
	 * @since 1.0.0
	 * @return The font for this {@link IComponent} (or null if using the default one)
	 */
	public @Nullable @AllowsEmptyString String getFont();
	
	public void setFont(final @Nullable @AllowsEmptyString String newFont);
}
