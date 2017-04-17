
package com.revature.taghandlers;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FirstTag extends SimpleTagSupport {

	public FirstTag() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		StringWriter writeString =new StringWriter();
		JspWriter out= getJspContext().getOut();
		getJspBody().invoke(writeString);
		
		out.println("Hello World"+writeString.toString());
	}

}
