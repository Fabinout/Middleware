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

import model.Result;
import model.SourceFile;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class Client {

    /**
     * @param args
     * @throws ResourceException
     */
    public static void main(String[] args) throws Exception {

        ClientResource cr = new ClientResource("http://localhost:8182/source");

        // Add a source file
        SourceFile s = new SourceFile();
        s.setName("Exemple");
        s.setContent("class Exemple {" +
        		"public void main (String[] args) {" +
        		"System.out.println(\"test\");" +
        		"}" +
        		"}");
        cr.post(s);
        
        // Compile
        cr = new ClientResource("http://localhost:8182/source/Exemple/compile");
        Result r = cr.get(Result.class);
        System.out.println(r.getOut());
        System.out.println(r.getErr());
        System.out.println(r.getRc());   
        

        // Run
        cr = new ClientResource("http://localhost:8182/source/Exemple/run");
        r = cr.get(Result.class);
        System.out.println(r.getOut());
        System.out.println(r.getErr());
        System.out.println(r.getRc());
       
    }

}
