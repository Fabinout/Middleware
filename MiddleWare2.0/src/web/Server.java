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

import model.SourceFiles;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class Server {   
	public static volatile SourceFiles sourcefiles = new SourceFiles();


	public static void main(String[] args) throws Exception {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8183);
		component.getDefaultHost().attach("/source", SourceFilesResource.class);
		component.getDefaultHost().attach("/source/{name}", SourceFileResource.class);
		component.getDefaultHost().attach("/source/{name}/compile", CompileResource.class);
		component.getDefaultHost().attach("/source/{name}/run", RunResource.class);
		component.start();
	}

}
