package com.tubmc.text;

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
 * An internal way to implement {@link IComponent} (as it's sealed)
 * 
 * @apiNote Only use to be used by {@link AbstractImplementation}'s to reduce code repetition
 * 
 * @author BradBot_1
 * @since 1.0.0
 * @version 1.0.0
 * @see IComponent
 */
@Internal
non-sealed interface ImplementationComponentBase extends IComponent { }