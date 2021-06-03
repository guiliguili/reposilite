/*
 * Copyright (c) 2021 dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.resource.application

import io.javalin.Javalin
import org.panda_lang.reposilite.config.Configuration
import org.panda_lang.reposilite.resource.ResourceFacade
import org.panda_lang.reposilite.resource.infrastructure.FrontendHandler
import org.panda_lang.reposilite.resource.infrastructure.WebJarsHandler

internal object ResourceWebConfiguration {

    fun createFacade(configuration: Configuration): ResourceFacade {
        return ResourceFacade.load(configuration)
    }

    fun installRouting(javalin: Javalin, resourceFacade: ResourceFacade) =
        javalin
            .get("/webjars/*", WebJarsHandler())
            .get("/js/app.js", FrontendHandler(resourceFacade))

}