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

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class SourceFileResource extends ServerResource {
	@Get
	public SourceFile retrieve() {
		String name = (String) getRequest().getAttributes().get("name");
		return Server.sourcefiles.get(name);
	}
	
	@Put
	public void update(SourceFile sourcefile) {
		String name = (String) getRequest().getAttributes().get("name");
		Server.sourcefiles.remove(name);
		Server.sourcefiles.set(sourcefile);
	}
	
	@Delete
	public void remove() {
		String name = (String) getRequest().getAttributes().get("name");
		Server.sourcefiles.remove(name);
	}

}
