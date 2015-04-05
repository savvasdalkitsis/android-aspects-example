package com.savvasdalkitsis.android.aspect.example.pageview;

public class AnnotatedPageRetriever implements PageRetriever {

	/**
     * Retrieve and configure (via a call to {@link PageViewConfigurator#configurePage(ConfigurablePage)})})
     * a page from the annotations of the supplied object). If a page cannot be instantiated, a
     * {@link javax.xml.parsers.ParserConfigurationException} will be thrown.
	 * 
	 * @param annotatedObject The object to retrieve the page from via annotations.
	 * @return The <strong>configured</strong> page.
	 * @throws PageViewInitializationException If a page was not found in the annotations.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page retrieveConfiguredPageFrom(Object annotatedObject) throws PageViewInitializationException {
		WithPageView session = annotatedObject.getClass().getAnnotation(WithPageView.class);
		Class<? extends Page> pageClass = session.page();
		try {
			Page page = pageClass.newInstance();
			if (annotatedObject instanceof PageViewConfigurator && page instanceof ConfigurablePage) {
				PageViewConfigurator<ConfigurablePage> sessionConfigurable =
                        (PageViewConfigurator<ConfigurablePage>) annotatedObject;
				// noinspection unchecked
				sessionConfigurable.configurePage((ConfigurablePage) page);
			}
			return page;
		} catch (Exception e) {
			throw new PageViewInitializationException("Could not create page from annotated class", e);
		}
	}
}