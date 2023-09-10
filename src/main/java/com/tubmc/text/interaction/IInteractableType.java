package com.tubmc.text.interaction;

import org.jetbrains.annotations.ApiStatus.Internal;

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
 * Internal definition for interaction type's so that {@link IInteraction} can have good generics
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see ClickType
 * @see HoverType
 */
@Internal
sealed interface IInteractableType<T extends IInteraction<?>> permits ClickType, HoverType<T> { }