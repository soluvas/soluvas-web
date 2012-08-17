package org.soluvas.web.site;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class AmdJavaScriptSource implements JavaScriptSource {
	
	private String body;
	private Map<String, String> dependencies = ImmutableMap.of();
	
	public AmdJavaScriptSource() {
		super();
	}

	/**
	 * 
	 * @param body
	 * @param dependencies moduleName => variableName
	 */
	public AmdJavaScriptSource(String body, Map<String, String> dependencies) {
		super();
		this.body = body;
		this.dependencies = dependencies;
	}

	public Map<String, String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Map<String, String> dependencies) {
		this.dependencies = dependencies;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getBody()
	 */
	@Override
	public String getBody() {
		return body;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#setBody(java.lang.String)
	 */
	@Override
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return String.format("AmdJavaScriptSource [body=%s, dependencies=%s]",
				body, dependencies);
	}

	@Override
	public int compareTo(JavaScriptSource o) {
		return 0;
	}

	@Override
	public String getScript() {
		String buf = "require([";
		buf += Joiner.on(", ").join( Iterables.transform(dependencies.keySet(), new Function<String, String>() {
			@Override
			public String apply(String input) {
				return "'" + input + "'";
			}
		}) );
		buf += "],\n";
		buf += "function(";
		buf += Joiner.on(", ").join( dependencies.values() );
		buf += ") {\n";
		buf += body + "\n";
		buf += "} );\n";
		return buf;
	}

}
