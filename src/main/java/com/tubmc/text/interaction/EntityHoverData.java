package com.tubmc.text.interaction;

import java.util.UUID;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.tubmc.text.IComponent;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final record EntityHoverData(@Nullable IComponent entityName, @NotNull @DisallowsEmptyString String typeIdentifier, @NotNull UUID entityUUID) {

}
