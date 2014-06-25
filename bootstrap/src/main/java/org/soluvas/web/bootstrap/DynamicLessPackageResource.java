package org.soluvas.web.bootstrap;

import java.util.Locale;

import org.apache.wicket.util.resource.IResourceStream;

import de.agilecoders.wicket.less.LessPackageResource;

/**
 * A package resource that uses a custom IResourceStream to
 * load Less content but return CSS content generated out of it.
 * @deprecated kayanya gak jadi, pake {@link ThemeManagerImpl} aja
 */
@Deprecated
public class DynamicLessPackageResource extends LessPackageResource {

	private static final long serialVersionUID = 1L;

	/**
     * Constructor.
     *
     * @param scope     This argument will be used to get the class loader for loading the package
     *                  resource, and to determine what package it is in
     * @param name      The relative path to the resource
     * @param locale    The locale of the resource
     * @param style     The style of the resource
     * @param variation The variation of the resource
     */
    public DynamicLessPackageResource(Class<?> scope, String name, Locale locale, String style, String variation) {
        super(scope, name, locale, style, variation);
    }

    @Override
    public IResourceStream getResourceStream() {
        IResourceStream resourceStream = super.getResourceStream();
        return new StringTemplateLessResourceStream(resourceStream);
    }

}
