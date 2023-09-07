package com.tubmc.text.builder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.IComponent;
import com.tubmc.text.ILiteralComponent;
import com.tubmc.text.interaction.ClickInteraction;
import com.tubmc.text.interaction.ClickType;
import com.tubmc.text.interaction.HoverInteraction;
import com.tubmc.text.interaction.HoverType;

import fun.bb1.objects.annotations.AllowsEmptyString;
import fun.bb1.objects.annotations.DisallowsEmptyString;
import fun.bb1.objects.defineables.ITypedBuilder;

@Internal
public sealed abstract class AbstractComponentBuilder<T extends AbstractComponentBuilder<T>> implements ITypedBuilder<IComponent> permits KeybindComponentBuilder, LiteralComponentBuilder, TranslatableComponentBuilder, SelectorComponentBuilder, ScoreboardComponentBuilder {
	
	// lock to package
	AbstractComponentBuilder() {}
	
	protected @Nullable Color color;
	protected final @NotNull Set<Style> styles = new HashSet<Style>();
	protected @Nullable String font;
	protected @Nullable ClickInteraction click;
	protected @Nullable HoverInteraction<?> hover;
	protected @Nullable List<IComponent> children;
	
	public final @NotNull T color(@NotNull final Color color) {
		this.color = color;
		return self();
	}
	
	public final @NotNull T withoutColor() {
		this.color = null;
		return self();
	}
	
	public final @NotNull T style(@NotNull final Style style, @Nullable final Style... styles) {
		this.styles.add(style);
		if (styles != null && styles.length != 0) {
			for (final Style style2 : styles) {
				this.styles.add(style2);
			}
		}
		return self();
	}
	
	public final @NotNull T noStyle() {
		this.styles.clear();
		return self();
	}
	
	public final @NotNull T font(@NotNull @DisallowsEmptyString final String font) {
		this.font = font;
		return self();
	}
	
	public final @NotNull T defaultFont() {
		this.font = null;
		return self();
	}
	
	public final @NotNull T click(@NotNull final ClickInteraction click) {
		this.click = click;
		return self();
	}
	
	public final @NotNull T linkTo(@NotNull @DisallowsEmptyString final String url) {
		this.click = new ClickInteraction(ClickType.OPEN_URL, url);
		return self();
	}
	
	public final @NotNull T putOnClipboard(@NotNull @AllowsEmptyString final String toAddToClipboard) {
		this.click = new ClickInteraction(ClickType.CLIPBOARD, toAddToClipboard);
		return self();
	}
	
	public final @NotNull T run(@NotNull @DisallowsEmptyString final String command) {
		this.click = new ClickInteraction(ClickType.EXECUTE, command);
		return self();
	}
	
	public final @NotNull T suggest(@NotNull @AllowsEmptyString final String command) {
		this.click = new ClickInteraction(ClickType.SUGGEST, command);
		return self();
	}
	
	public final @NotNull T noClick() {
		this.click = null;
		return self();
	}
	
	public final @NotNull T hover(@NotNull final HoverInteraction<?> hover) {
		this.hover = hover;
		return self();
	}
	
	public final @NotNull T tooltip(@NotNull @DisallowsEmptyString final String display) {
		this.hover = new HoverInteraction<IComponent>(HoverType.TEXT, ILiteralComponent.of(display));
		return self();
	}
	
	public final @NotNull T tooltip(@NotNull @DisallowsEmptyString final IComponent display) {
		this.hover = new HoverInteraction<IComponent>(HoverType.TEXT, display);
		return self();
	}
	
	public final @NotNull T noHover() {
		this.hover = null;
		return self();
	}
	
	public final @NotNull T noChildren() {
		this.children = null;
		return self();
	}
	
	public final @NotNull T then(@NotNull @AllowsEmptyString final String literal) {
		return this.then(ILiteralComponent.of(literal));
	}
	
	public final @NotNull T then(@NotNull final IComponent component) {
		if (this.children == null) this.children = new ArrayList<IComponent>();
		this.children.add(component);
		return self();
	}
	
	private final @NotNull T then(@NotNull final ITypedBuilder<IComponent> builder) {
		return this.then(builder.build());
	}
	
	public final @NotNull T thenKeybind(@NotNull @DisallowsEmptyString final String keybind, @NotNull final Consumer<KeybindComponentBuilder> consumer) {
		final KeybindComponentBuilder builder = new KeybindComponentBuilder(keybind);
		consumer.accept(builder);
		return this.then(builder);
	}
	
	public final @NotNull T thenTranslation(@NotNull @DisallowsEmptyString final String translationKey, @NotNull final Consumer<TranslatableComponentBuilder> consumer) {
		final TranslatableComponentBuilder builder = new TranslatableComponentBuilder(translationKey);
		consumer.accept(builder);
		return this.then(builder);
	}
	
	public final @NotNull T thenLiteral(@NotNull @DisallowsEmptyString final String literal, @NotNull final Consumer<LiteralComponentBuilder> consumer) {
		final LiteralComponentBuilder builder = new LiteralComponentBuilder(literal);
		consumer.accept(builder);
		return this.then(builder);
	}
	
	public final @NotNull T thenSelector(@NotNull @DisallowsEmptyString final String selector, @NotNull final Consumer<SelectorComponentBuilder> consumer) {
		final SelectorComponentBuilder builder = new SelectorComponentBuilder(selector);
		consumer.accept(builder);
		return this.then(builder);
	}
	
	public final @NotNull T thenScoreboard(@NotNull @DisallowsEmptyString final String selector, @NotNull @DisallowsEmptyString final String objective, @NotNull final Consumer<ScoreboardComponentBuilder> consumer) {
		final ScoreboardComponentBuilder builder = new ScoreboardComponentBuilder(selector, objective);
		consumer.accept(builder);
		return self();
	}
	
	protected abstract @NotNull T self();
	
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
	
}
