/*
 * Copyright 2012 Lionel Bécuwe, Paul Blouët, Fabien Lamarque, Frédéric Lucas
 *
 * This file is part of aca-middleware.
 *
 * aca-middleware is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * aca-middleware is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with aca-middleware.  If not, see <http://www.gnu.org/licenses/>.
 */
package web;

import model.SourceFile;
import model.SourceFiles;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class SourceFilesResource extends ServerResource {

    @Get
    public SourceFiles retrieve() {
        return Server.sourcefiles;
    }

    @Post
    public void store(SourceFile sourcefile) {
    	Server.sourcefiles.set(sourcefile);
    }

}
