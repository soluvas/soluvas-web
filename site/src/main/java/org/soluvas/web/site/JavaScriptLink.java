package org.soluvas.web.site;

import java.io.Serializable;

public interface JavaScriptLink extends Serializable {

	String getSrc();

	void setSrc(String src);

	int getWeight();

	void setWeight(int weight);

}