package org.soluvas.web.site;

import java.io.Serializable;

public interface CssLink extends Serializable {

	String getHref();

	void setHref(String href);

	int getWeight();

	void setWeight(int weight);

}