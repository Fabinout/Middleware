package web;

import java.io.IOException;

import model.Result;
import model.SourceFile;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Compilation.Main;

public class DotNetConnector extends ServerResource {

	@Post
	public Representation store(Form form) {
		SourceFile sourcefile = new SourceFile();
		sourcefile.setName(form.getFirst("fileName").getValue());
		sourcefile.setContent(form.getFirst("sourceCode").getValue());
		Server.sourcefiles.set(sourcefile);
		Result rco = Main.compile(sourcefile.getName());
		Result rru = Main.run(sourcefile.getName());
		DomRepresentation result = null;
		try {
			result = new DomRepresentation(MediaType.TEXT_XML);
			Document d = result.getDocument();
			Element r = d.createElement("GlobalResult");
			d.appendChild(r);
			Element co = d.createElement("Compilation");
			r.appendChild(co);
			Element coer = d.createElement("Error");
			coer.setTextContent(rco.getErr());
			co.appendChild(coer);
			Element coru = d.createElement("Output");
			coru.setTextContent(rco.getOut());
			co.appendChild(coru);
			Element coti = d.createElement("ElapsedTime");
			coti.setTextContent("0");
			co.appendChild(coti);
			Element ex = d.createElement("Execution");
			r.appendChild(ex);
			Element exer = d.createElement("Error");
			exer.setTextContent(rru.getErr());
			ex.appendChild(exer);
			Element exru = d.createElement("Output");
			exru.setTextContent(rru.getOut());
			ex.appendChild(exru);
			Element exti = d.createElement("ElapsedTime");
			exti.setTextContent("0");
			ex.appendChild(exti);
		} catch (IOException e) {
		}
		return result;
	}

}
