package com.tubmc.text.builder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.IComponent;
import com.tubmc.text.IKeybindComponent;
import com.tubmc.text.ILiteralComponent;
import com.tubmc.text.IScoreboardComponent;
import com.tubmc.text.ISelectedComponent;
import com.tubmc.text.ITranslatableComponent;
import com.tubmc.text.interaction.ClickInteraction;
import com.tubmc.text.interaction.ClickType;
import com.tubmc.text.interaction.HoverInteraction;
import com.tubmc.text.interaction.HoverType;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;
import fun.bb1.objects.defineables.ITypedBuilder;

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
 * Base class for building {@link IComponent}'s
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 */
@Internal
public sealed abstract class AbstractComponentBuilder<T extends AbstractComponentBuilder<T>> implements ITypedBuilder<IComponent> permits KeybindComponentBuilder, LiteralComponentBuilder, TranslatableComponentBuilder, SelectorComponentBuilder, ScoreboardComponentBuilder {
	
	protected AbstractComponentBuilder() {}
	/**
	 * The {@link Color} to apply to the {@link IComponent} during {@link #build()}
	 * 
	 * @since 1.0.0
	 * @apiNote Applied during {@link #applyCommon(IComponent)}
	 * @see #color(Color)
	 * @see #withoutColor()
	 */
	protected @Nullable Color color;
	/**
	 * The {@link Style}'s to apply to the {@link IComponent} during {@link #build()}
	 * 
	 * @since 1.0.0
	 * @apiNote Applied during {@link #applyCommon(IComponent)}
	 * @see #style(Style, Style...)
	 * @see #noStyle()
	 * @see #modify(Function)
	 * @see StagedComponent#setBold(boolean)
	 * @see StagedComponent#setItalic(boolean)
	 * @see StagedComponent#setObfuscated(boolean)
	 * @see StagedComponent#setStrikeThrough(boolean)
	 * @see StagedComponent#setUnderlined(boolean)
	 */
	protected final @NotNull Set<Style> styles = new HashSet<Style>();
	/**
	 * The font to apply to the {@link IComponent} during {@link #build()}
	 * 
	 * @since 1.0.0
	 * @apiNote Applied during {@link #applyCommon(IComponent)}
	 * @see #font(String)
	 * @see #defaultFont()
	 * @see #modify(Function)
	 * @see StagedComponent#setFont(String)
	 */
	protected @Nullable String font;
	/**
	 * The {@link ClickInteraction} to apply to the {@link IComponent} during {@link #build()}
	 * 
	 * @since 1.0.0
	 * @apiNote Applied during {@link #applyCommon(IComponent)}
	 * @see #click(ClickInteraction)
	 * @see #run(String)
	 * @see #suggest(String)
	 * @see #linkTo(String)
	 * @see #putOnClipboard(String)
	 * @see #noClick()
	 * @see #modify(Function)
	 * @see StagedComponent#setClick(ClickInteraction)
	 */
	protected @Nullable ClickInteraction click;
	/**
	 * The {@link HoverInteraction} to apply to the {@link IComponent} during {@link #build()}
	 * 
	 * @since 1.0.0
	 * @apiNote Applied during {@link #applyCommon(IComponent)}
	 * @see #hover(HoverInteraction)
	 * @see #tooltip(IComponent)
	 * @see #tooltip(String)
	 * @see #noHover()
	 * @see #modify(Function)
	 * @see StagedComponent#setHover(HoverInteraction)
	 */
	protected @Nullable HoverInteraction<?> hover;
	/**
	 * The {@link IComponent}'s to add as children via {@link IComponent#setChildren(java.util.Collection)}
	 * 
	 * @since 1.0.0
	 * @apiNote Applied during {@link #applyCommon(IComponent)}
	 * @see #then(IComponent)
	 * @see #then(String)
	 * @see #then(Supplier)
	 * @see #thenKeybind(String, Consumer)
	 * @see #thenLiteral(String, Consumer)
	 * @see #thenScoreboard(String, String, Consumer)
	 * @see #thenSelector(String, Consumer)
	 * @see #thenTranslation(String, Consumer)
	 */
	protected @Nullable List<IComponent> children;
	/**
	 * Set's the {@link Color} to display as
	 * 
	 * @since 1.0.0
	 * @param color The {@link Color} to display as
	 * @return The builder instance
	 */
	public final @NotNull T color(@NotNull final Color color) {
		this.color = color;
		return self();
	}
	/**
	 * Removes any {@link Color} defined for this component
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 */
	public final @NotNull T withoutColor() {
		this.color = null;
		return self();
	}
	/**
	 * Adds the {@link Style}'s to {@link #styles}
	 * 
	 * @apiNote This doesn't clear {@link #styles}, for that see {@link #noStyle()}
	 * @since 1.0.0
	 * @param style The style to add
	 * @param styles Any additional styles to also add
	 * @return The builder instance
	 */
	public final @NotNull T style(@NotNull final Style style, @Nullable final Style... styles) {
		this.styles.add(style);
		if (styles != null && styles.length != 0) {
			for (final Style style2 : styles) {
				this.styles.add(style2);
			}
		}
		return self();
	}
	/**
	 * Removes any styles defined for this component
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 */
	public final @NotNull T noStyle() {
		this.styles.clear();
		return self();
	}
	/**
	 * Set's the {@link #font} to use
	 * 
	 * @since 1.0.0
	 * @param font The font to display as
	 * @return The builder instance
	 */
	public final @NotNull T font(@NotNull @DisallowsEmptyString final String font) {
		this.font = font;
		return self();
	}
	/**
	 * Reverts to using the default font
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 */
	public final @NotNull T defaultFont() {
		this.font = null;
		return self();
	}
	/**
	 * Sets {@link #click} to the provided instance of {@link ClickInteraction}
	 * 
	 * @param click The {@link ClickInteraction} to use
	 * @since 1.0.0
	 * @return The builder instance
	 * @see ClickInteraction
	 * @see ClickType
	 */
	public final @NotNull T click(@NotNull final ClickInteraction click) {
		this.click = click;
		return self();
	}
	/**
	 * Sets {@link #click} to an instance of {@link ClickInteraction} with {@link ClickType#OPEN_URL} and the provided string
	 * 
	 * @param url The url to open
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #click(ClickInteraction)
	 * @see ClickInteraction
	 * @see ClickType#OPEN_URL
	 */
	public final @NotNull T linkTo(@NotNull @DisallowsEmptyString final String url) {
		this.click = new ClickInteraction(ClickType.OPEN_URL, url);
		return self();
	}
	/**
	 * Sets {@link #click} to an instance of {@link ClickInteraction} with {@link ClickType#CLIPBOARD} and the provided string
	 * 
	 * @param toAddToClipboard The text to copy to the clipboard
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #click(ClickInteraction)
	 * @see ClickInteraction
	 * @see ClickType#CLIPBOARD
	 */
	public final @NotNull T putOnClipboard(@NotNull @AllowsEmptyString final String toAddToClipboard) {
		this.click = new ClickInteraction(ClickType.CLIPBOARD, toAddToClipboard);
		return self();
	}
	/**
	 * Sets {@link #click} to an instance of {@link ClickInteraction} with {@link ClickType#EXECUTE} and the provided string
	 * 
	 * @param command The command to run
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #click(ClickInteraction)
	 * @see ClickInteraction
	 * @see ClickType#EXECUTE
	 */
	public final @NotNull T run(@NotNull @DisallowsEmptyString final String command) {
		this.click = new ClickInteraction(ClickType.EXECUTE, command);
		return self();
	}
	/**
	 * Sets {@link #click} to an instance of {@link ClickInteraction} with {@link ClickType#SUGGEST} and the provided string
	 * 
	 * @param command The command to suggest
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #click(ClickInteraction)
	 * @see ClickInteraction
	 * @see ClickType#SUGGEST
	 */
	public final @NotNull T suggest(@NotNull @AllowsEmptyString final String command) {
		this.click = new ClickInteraction(ClickType.SUGGEST, command);
		return self();
	}
	/**
	 * Sets {@link #click} to null
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 * @see ClickInteraction
	 * @see ClickType
	 */
	public final @NotNull T noClick() {
		this.click = null;
		return self();
	}
	/**
	 * Sets {@link #hover} to the provided instance of {@link HoverInteraction}
	 * 
	 * @param hover The {@link HoverInteraction} to use
	 * @since 1.0.0
	 * @return The builder instance
	 * @see HoverInteraction
	 * @see HoverType
	 */
	public final @NotNull T hover(@NotNull final HoverInteraction<?> hover) {
		this.hover = hover;
		return self();
	}
	/**
	 * Sets {@link #hover} to the an instance of {@link HoverInteraction} with the type of {@link HoverType#TEXT}
	 * 
	 * @param display The text to display
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #hover(HoverInteraction)
	 * @see HoverInteraction
	 * @see HoverType
	 */
	public final @NotNull T tooltip(@NotNull @DisallowsEmptyString final String display) {
		this.hover = new HoverInteraction<IComponent>(HoverType.TEXT, ILiteralComponent.of(display));
		return self();
	}
	/**
	 * Sets {@link #hover} to the an instance of {@link HoverInteraction} with the type of {@link HoverType#TEXT}
	 * 
	 * @param display The {@link IComponent} to display
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #hover(HoverInteraction)
	 * @see HoverInteraction
	 * @see HoverType
	 */
	public final @NotNull T tooltip(@NotNull @DisallowsEmptyString final IComponent display) {
		this.hover = new HoverInteraction<IComponent>(HoverType.TEXT, display);
		return self();
	}
	/**
	 * Sets {@link #hover} to null
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 * @see HoverInteraction
	 * @see HoverType
	 */
	public final @NotNull T noHover() {
		this.hover = null;
		return self();
	}
	/**
	 * Removes all children from this builder
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 */
	public final @NotNull T noChildren() {
		this.children = null;
		return self();
	}
	/**
	 * Andy's special syntax
	 * 
	 * @since 1.0.0
	 * @param stagedComponentFunction A function to provide the current instance of the {@link AbstractComponentBuilder}
	 * @return The builder instance
	 * @see StagedComponent
	 */
	public final @NotNull T modify(@NotNull final Function<@NotNull T, @NotNull StagedComponent> stagedComponentFunction) {
		stagedComponentFunction.apply(self());
		return self();
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @param literal The text to append
	 * @since 1.0.0
	 * @return The builder instance
	 * @see ILiteralComponent
	 * @see #then(IComponent)
	 */
	public final @NotNull T then(@NotNull @AllowsEmptyString final String literal) {
		return this.then(ILiteralComponent.of(literal));
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @apiNote Will set {@link #children} to an instance of {@link ArrayList} if it's null
	 * @param component The {@link IComponent} to append
	 * @since 1.0.0
	 * @return The builder instance
	 * @see IComponent
	 */
	public final @NotNull T then(@NotNull final IComponent component) {
		if (this.children == null) this.children = new ArrayList<IComponent>();
		this.children.add(component.deepClone());
		return self();
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @apiNote Immediately calls {@link Supplier#get()} and then {@link #then(IComponent)}
	 * @param component The supplier to get the element from
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #then(IComponent)
	 */
	public final @NotNull T then(@NotNull final Supplier<IComponent> component) {
		return this.then(component.get());
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @apiNote Immediately calls {@link AbstractComponentBuilder#build()} then {@link #then(IComponent)}
	 * @param builder The {@link AbstractComponentBuilder} to append
	 * @since 1.0.0
	 * @return The builder instance
	 * @see #then(IComponent)
	 */
	private final @NotNull T then(@NotNull final ITypedBuilder<IComponent> builder) {
		return this.then(builder.build());
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @param keybind The keybind to initialise {@link KeybindComponentBuilder} with
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link KeybindComponentBuilder}
	 * @since 1.0.0
	 * @return The builder instance
	 * @see IKeybindComponent
	 * @see KeybindComponentBuilder
	 * @see #then(ITypedBuilder)
	 */
	public final @NotNull T thenKeybind(@NotNull @DisallowsEmptyString final String keybind, @NotNull final Consumer<KeybindComponentBuilder> consumer) {
		final KeybindComponentBuilder builder = new KeybindComponentBuilder(keybind);
		consumer.accept(builder);
		return this.then(builder);
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @param translationKey The translationKey to initialise {@link TranslatableComponentBuilder} with
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link TranslatableComponentBuilder}
	 * @since 1.0.0
	 * @return The builder instance
	 * @see ITranslatableComponent
	 * @see TranslatableComponentBuilder
	 * @see #then(ITypedBuilder)
	 */
	public final @NotNull T thenTranslation(@NotNull @DisallowsEmptyString final String translationKey, @NotNull final Consumer<TranslatableComponentBuilder> consumer) {
		final TranslatableComponentBuilder builder = new TranslatableComponentBuilder(translationKey);
		consumer.accept(builder);
		return this.then(builder);
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @param literal The text to initialise {@link LiteralComponentBuilder} with
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link LiteralComponentBuilder}
	 * @since 1.0.0
	 * @return The builder instance
	 * @see ILiteralComponent
	 * @see LiteralComponentBuilder
	 * @see #then(ITypedBuilder)
	 */
	public final @NotNull T thenLiteral(@NotNull @DisallowsEmptyString final String literal, @NotNull final Consumer<LiteralComponentBuilder> consumer) {
		final LiteralComponentBuilder builder = new LiteralComponentBuilder(literal);
		consumer.accept(builder);
		return this.then(builder);
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @param selector The selector to initialise {@link SelectorComponentBuilder} with
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link SelectorComponentBuilder}
	 * @since 1.0.0
	 * @return The builder instance
	 * @see ISelectedComponent
	 * @see SelectorComponentBuilder
	 * @see #then(ITypedBuilder)
	 */
	public final @NotNull T thenSelector(@NotNull @DisallowsEmptyString final String selector, @NotNull final Consumer<SelectorComponentBuilder> consumer) {
		final SelectorComponentBuilder builder = new SelectorComponentBuilder(selector);
		consumer.accept(builder);
		return this.then(builder);
	}
	/**
	 * Adds a new {@link #children} element
	 * 
	 * @param selector The selector to initialise {@link ScoreboardComponentBuilder} with
	 * @param objective The objective to initialise {@link ScoreboardComponentBuilder} with
	 * @param consumer The consumer to {@link Consumer#accept(Object)} the {@link ScoreboardComponentBuilder}
	 * @since 1.0.0
	 * @return The builder instance
	 * @see IScoreboardComponent
	 * @see ScoreboardComponentBuilder
	 * @see #then(ITypedBuilder)
	 */
	public final @NotNull T thenScoreboard(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @NotNull final Consumer<ScoreboardComponentBuilder> consumer) {
		final ScoreboardComponentBuilder builder = new ScoreboardComponentBuilder(selector, objective);
		consumer.accept(builder);
		return self();
	}
	/**
	 * Here for better return typing as <code>this</code> causes casting issues
	 * 
	 * @since 1.0.0
	 * @return The builder instance
	 */
	protected abstract @NotNull T self();
	/**
	 * Sets common fields for all {@link IComponent}'s
	 * 
	 * @param component The {@link IComponent} to apply common features to
	 * @since 1.0.0
	 * @return The provided {@link IComponent}
	 */
	protected final <C extends IComponent> @NotNull C applyCommon(@NotNull final C component) {
		if (this.color != null) component.setColor(this.color);
		if (this.styles.contains(Style.BOLD)) component.setBold(true);
		if (this.styles.contains(Style.ITALIC)) component.setItalic(true);
		if (this.styles.contains(Style.OBFUSCATED)) component.setObfuscated(true);
		if (this.styles.contains(Style.STRIKETHOUGH)) component.setStrikeThrough(true);
		if (this.styles.contains(Style.UNDERLINE)) component.setUnderlined(true);
		if (this.font != null && this.font.length() != 0) component.setFont(this.font);
		if (this.click != null) component.setClicked(this.click);
		if (this.hover != null) component.setHovering(this.hover);
		if (this.children != null && this.children.size() != 0) component.setChildren(this.children);
		return component;
	}
	/**
	 * Used by {@link AbstractComponentBuilder} for andy's special syntax
	 * 
	 * @author BradBot_1
	 * @since 1.0.0
	 * @version 1.0.0
	 * @see AbstractComponentBuilder#modify(Function)
	 */
	public class StagedComponent {
		/**
		 * @since 1.0.0
		 * @param newColor The {@link Color} to use
		 * @see AbstractComponentBuilder#color(Color)
		 */
		public void setColor(final @Nullable Color newColor) {
			color(newColor);
		}
		/**
		 * @since 1.0.0
		 * @param newFont The font to display as
		 * @see AbstractComponentBuilder#font(String)
		 */
		public void setFont(final @Nullable @AllowsEmptyString String newFont) {
			font(newFont);
		}
		/**
		 * @since 1.0.0
		 * @param isBold If the element should display as bold
		 * @see AbstractComponentBuilder#style(Style, Style...)
		 * @see Style#BOLD
		 */
		public void setBold(final boolean isBold) {
			if (isBold) style(Style.BOLD);
			else styles.remove(Style.BOLD);
		}
		/**
		 * @since 1.0.0
		 * @param isItalic If the element should display as italic
		 * @see AbstractComponentBuilder#style(Style, Style...)
		 * @see Style#ITALIC
		 */
		public void setItalic(final boolean isItalic) {
			if (isItalic) style(Style.ITALIC);
			else styles.remove(Style.ITALIC);
		}
		/**
		 * @since 1.0.0
		 * @param isUnderlined If the element should display as underlined
		 * @see AbstractComponentBuilder#style(Style, Style...)
		 * @see Style#UNDERLINE
		 */
		public void setUnderlined(final boolean isUnderlined) {
			if (isUnderlined) style(Style.UNDERLINE);
			else styles.remove(Style.UNDERLINE);
		}
		/**
		 * @since 1.0.0
		 * @param isStrikedThrough If the element should display as stricken
		 * @see AbstractComponentBuilder#style(Style, Style...)
		 * @see Style#STRIKETHOUGH
		 */
		public void setStrikeThrough(final boolean isStrikedThrough) {
			if (isStrikedThrough) style(Style.STRIKETHOUGH);
			else styles.remove(Style.STRIKETHOUGH);
		}
		/**
		 * @since 1.0.0
		 * @param isBold If the element should display as obfuscated
		 * @see AbstractComponentBuilder#style(Style, Style...)
		 * @see Style#OBFUSCATED
		 */
		public void setObfuscated(final boolean isObfuscated) {
			if (isObfuscated) style(Style.OBFUSCATED);
			else styles.remove(Style.OBFUSCATED);
		}
		/**
		 * @since 1.0.0
		 * @param hoverInteraction The {@link HoverInteraction} to use
		 * @see AbstractComponentBuilder#hover(HoverInteraction)
		 * @see HoverInteraction
		 */
		public void setHover(final @Nullable HoverInteraction<?> hoverInteraction) {
			hover(hoverInteraction);
		}
		/**
		 * @since 1.0.0
		 * @param clickInteraction The {@link ClickInteraction} to use
		 * @see AbstractComponentBuilder#click(ClickInteraction)
		 * @see ClickInteraction
		 */
		public void setClick(final @Nullable ClickInteraction clickInteraction) {
			click(clickInteraction);
		}
	}
}