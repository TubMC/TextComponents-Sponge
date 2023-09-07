package com.tubmc.text.interaction;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fun.bb1.objects.annotations.DisallowsEmptyString;

public final record ItemHoverData(@NotNull @DisallowsEmptyString String itemIdentifier, int count, @Nullable @DisallowsEmptyString String nbtTagAsString) {

}
